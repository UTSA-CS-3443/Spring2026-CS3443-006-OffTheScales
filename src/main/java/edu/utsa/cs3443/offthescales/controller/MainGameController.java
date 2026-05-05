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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.util.*;

public class MainGameController {

    @FXML
    private Pane gamePane;
    @FXML
    private Button EndGameButton;

    private final List<Circle> notes = new ArrayList<>();

    private int score = 0;
    private int combo = 0;

    private final int[] lanesX = {100, 200, 300, 400};
    private final String[] keys = {"f", "g", "h", "j"};

    private Text scoreText;
    private Text comboText;

    private final double HIT_LINE_Y = 350;
    private final double SPEED = 2;

    private MediaPlayer mediaPlayer;

    private String currentSong = "song1";

    private boolean gameEnded = false;
    private boolean waitingToEnd = false;
    private double endStartTime = 0;

    @FXML
    public void initialize() {
        createHitLine();
        createLaneLines();
        createKeyBoxes();
        createScoreUI();

        gamePane.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #5a0000, #444444);"
        );

        gamePane.setFocusTraversable(true);
        gamePane.setOnKeyPressed(this::handleKeyPress);
    }

    public void setSong(String song) {
        this.currentSong = song;
        System.out.println("Selected song: " + currentSong);

        startMusic();
        spawnNotes();
        startGameLoop();

        gamePane.requestFocus();
    }

    private void startMusic() {
        String musicPath = getClass()
                .getResource("/edu/utsa/cs3443/offthescales/songs/" + currentSong + ".mp3")
                .toExternalForm();

        Media media = new Media(musicPath);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();

        mediaPlayer.setOnEndOfMedia(this::endGame);
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

        double[] noteTimes;
        int[] lanes;

        switch (currentSong) {
            case "song2":
                noteTimes = loadSong2Times();
                lanes = loadSong2Lanes();
                break;
            case "song3":
                noteTimes = loadSong3Times();
                lanes = loadSong3Lanes();
                break;
            default:
                noteTimes = loadSong1Times();
                lanes = loadSong1Lanes();
                break;
        }

        for (int i = 0; i < noteTimes.length; i++) {

            Circle note = new Circle(10);
            note.setCenterX(lanesX[lanes[i]]);
            note.setCenterY(-100);

            note.setFill(createTealGradient());
            note.setStroke(Color.BLACK);
            note.setStrokeWidth(2);

            note.setUserData(noteTimes[i]);

            notes.add(note);
            gamePane.getChildren().add(note);
        }
    }



    // This is the note spawn for song1
    private double[] loadSong1Times() {
        return new double[] {
                2040.0,2840.0,3690.0,4680.0,5560.0,6470.0,7460.0,
                9280.0,10160.0,11120.0,12030.0,12940.0,13830.0,14720.0,
                16610.0,17520.0,18520.0,19450.0,20340.0,21260.0,22210.0,
                24070.0,25060.0,25960.0,26850.0,27820.0,28690.0,29610.0,
                31490.0,32380.0,33300.0,34210.0,35100.0,36010.0,37040.0,
                38970.0,39860.0,40720.0,41590.0,42520.0,43410.0,44370.0

        };
    }

    private int[] loadSong1Lanes() {
        return new int[] {
                0,0,2,2,3,3,2,
                1,1,0,0,1,1,0,
                3,3,2,2,1,1,0,
                3,3,2,2,1,1,0,
                0,0,2,2,3,3,2,
                1,1,0,0,1,1,0
        };
    }
    // This is the note spawn for song2
    private double[] loadSong2Times() {
        return new double[] {
                5103, 5600, 6000, 6600, 7300, 8000,
                9300, 10000, 10317, 11000, 11500,
                12400, 13160, 13900, 14300, 14650,
                15400, 16105, 16835, 17576, 18280,
                18830, 19000, 19780, 20528, 21266,
                22005, 22735, 23239, 23500, 24249,
                24963, 25640, 26431

        };
    }

    private int[] loadSong2Lanes() {
        return new int[] {
                0, 2, 2, 3, 1, 1,
                2, 0, 0, 1, 3,
                2, 2, 1, 3, 1,
                0, 3, 2, 1, 0,
                2, 3, 1, 0, 1,
                3, 1, 3, 2, 0,
                0, 2, 1

        };
    }
    // This is the note spawn for song3
    private double[] loadSong3Times() {
        return new double[] {
             400,1150, 1430, 2210,2420, 3000, 3400,
             4000, 4225,4280, 5100, 5560, 6300, 8000,8300,9150, 9500,
             10400, 11100, 11500, 12300,13000, 13500,14300,15000, 15460,
             16300
        };
    }

    private int[] loadSong3Lanes() {
        return new int[] {
                1,0, 3, 2,1, 3, 0,
                2, 3,1, 2, 0, 3, 0,1,2, 3,
                0, 3, 2, 1,0, 3,2,3, 1,
                3
        };
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

                double currentTime = mediaPlayer.getCurrentTime().toMillis();

                if (!gameEnded && currentTime >= getEndTime()) {
                    gameEnded = true;
                    endGame();
                    return;
                }

                Iterator<Circle> it = notes.iterator();

                while (it.hasNext()) {
                    Circle note = it.next();

                    double spawnTime = (double) note.getUserData();

                    double travelTime = 4000;
                    double timeUntilHit = spawnTime - currentTime;

                    if (timeUntilHit < travelTime) {

                        double progress = 1 - (timeUntilHit / travelTime);

                        double startY = -100;
                        double endY = HIT_LINE_Y;

                        note.setCenterY(startY + progress * (endY - startY));
                    }


                    if (note.getCenterY() > 400) {
                        combo = 0;

                        gamePane.getChildren().remove(note);
                        it.remove();

                        updateUI();
                    }
                }
            }
        }.start();
    }

    private double getEndTime() {
        switch (currentSong) {
            case "song1":
                return 46000;

            case "song2":
                return 30000; // change when updated

            case "song3":
                return 20000; // change when updated

            default:
                return Double.MAX_VALUE;
        }
    }

    private void handleKeyPress(KeyEvent event) {
        String key = event.getText().toLowerCase();

         System.out.println(mediaPlayer.getCurrentTime().toMillis()); // Turn this on for when you want to sync notes for new songs, and off by default

        for (int lane = 0; lane < keys.length; lane++) {
            if (!keys[lane].equals(key)) continue;

            Iterator<Circle> it = notes.iterator();

            while (it.hasNext()) {
                Circle note = it.next();

                if (Math.abs(note.getCenterY() - HIT_LINE_Y) < 20 &&
                        note.getCenterX() == lanesX[lane]) {

                    gamePane.getChildren().remove(note);
                    it.remove();

                    score += 100; // For changing how much each hit gives
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
        endGame();
    }

    private void endGame() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        MainApp.showGameOverView(score, currentSong);
    }
    private void stopGame() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        MainApp.showGameOverView(score, currentSong);
    }
}