package edu.utsa.cs3443.offthescales.controller;

import edu.utsa.cs3443.offthescales.MainApp;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.util.*;

public class MainGameController {

    @FXML private Pane gamePane;
    @FXML private Button EndGameButton;

    private final List<Circle> notes = new ArrayList<>();

    private int score = 0;
    private int combo = 0;

    private final int[] lanesX = {100, 200, 300, 400};
    private final String[] keys = {"f", "g", "h", "j"};

    private Text scoreText;
    private Text comboText;

    private final double HIT_LINE_Y = 350;
    private final double SPEED = 2;

    @FXML
    public void initialize() {
        createHitLine();
        createLaneLines();
        createKeyBoxes();
        createScoreUI();

        gamePane.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #5a0000, #444444);"
        );

        spawnNotes();
        startGameLoop();

        gamePane.setFocusTraversable(true);
        gamePane.setOnKeyPressed(this::handleKeyPress);
    }


    private void createHitLine() {
        Rectangle line = new Rectangle(600, 5);
        line.setY(HIT_LINE_Y);
        line.setStyle("-fx-fill: #bbbbbb;");
        gamePane.getChildren().add(line);
    }

    private void createLaneLines() {
        for (int x : lanesX) {
            Line lane = new Line(x, 0, x, 400);
            lane.setStyle("-fx-stroke: #aaaaaa; -fx-stroke-width: 2;");
            gamePane.getChildren().add(lane);
        }
    }

    private void createKeyBoxes() {
        for (int i = 0; i < lanesX.length; i++) {
            Rectangle box = new Rectangle(60, 40);
            box.setX(lanesX[i] - 30);
            box.setY(HIT_LINE_Y + 10);
            box.setStyle("-fx-fill: white; -fx-stroke: black;");

            Text keyText = new Text(lanesX[i] - 5, HIT_LINE_Y + 35, keys[i].toUpperCase());

            gamePane.getChildren().addAll(box, keyText);
        }
    }

    private void createScoreUI() {


        Rectangle box = new Rectangle(180, 80);
        box.setX(10);
        box.setY(10);
        box.setArcWidth(15);
        box.setArcHeight(15);
        box.setStyle("-fx-fill: rgba(255,255,255,0.9); -fx-stroke: black;");


        scoreText = new Text(20, 35, "Score: 0");
        scoreText.setStyle("-fx-fill: red; -fx-font-size: 20px; -fx-font-weight: bold;");

        comboText = new Text(20, 60, "Combo: 0");
        comboText.setStyle("-fx-fill: darkred; -fx-font-size: 16px;");

        gamePane.getChildren().addAll(box, scoreText, comboText);
    }


    private void spawnNotes() {
        for (int i = 0; i < 20; i++) {
            int lane = i % lanesX.length;

            Circle note = new Circle(10);
            note.setCenterX(lanesX[lane]);
            note.setCenterY(-i * 60);

            note.setFill(createTealGradient());
            note.setStroke(Color.BLACK);
            note.setStrokeWidth(2);

            notes.add(note);
            gamePane.getChildren().add(note);
        }
    }

    private Paint createTealGradient() {
        return new RadialGradient(
                0, 0, 0.5, 0.5, 0.8, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#6fffe0")),
                new Stop(1, Color.web("#0f8f79"))
        );
    }

    private void startGameLoop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (Circle note : notes) {
                    note.setCenterY(note.getCenterY() + SPEED);

                    if (note.getCenterY() > 400) {
                        combo = 0;
                        updateUI();
                    }
                }
            }
        }.start();
    }

    private void handleKeyPress(KeyEvent event) {
        String key = event.getText().toLowerCase();

        for (int lane = 0; lane < keys.length; lane++) {
            if (!keys[lane].equals(key)) continue;

            Iterator<Circle> it = notes.iterator();

            while (it.hasNext()) {
                Circle note = it.next();

                if (Math.abs(note.getCenterY() - HIT_LINE_Y) < 20 &&
                        note.getCenterX() == lanesX[lane]) {

                    gamePane.getChildren().remove(note);
                    it.remove();

                    score += 10;
                    combo++;
                    updateUI();
                    return;
                }
            }
        }
    }

    private void updateUI() {
        scoreText.setText("Score: " + score);
        comboText.setText("Combo: " + combo);
    }

    @FXML
    void EndGameClicked(MouseEvent event) {
    }
}