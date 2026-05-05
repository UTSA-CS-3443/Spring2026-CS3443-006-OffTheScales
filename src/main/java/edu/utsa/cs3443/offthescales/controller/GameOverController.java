package edu.utsa.cs3443.offthescales.controller;

import edu.utsa.cs3443.offthescales.MainApp;
import edu.utsa.cs3443.offthescales.model.Player;
import edu.utsa.cs3443.offthescales.model.PlayerDataManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class GameOverController {

    private int finalScore;
    private String songPlayed;

    @FXML
    private TextField NameTextField;

    @FXML
    private Button SaveHighScoreButton;

    @FXML
    private Label ScoreLabel;

    @FXML
    private Button TitleScreenButton;

    public void setScore(int score) {
        this.finalScore = score;
        ScoreLabel.setText(String.valueOf(score));
    }

    public void setSongPlayed(String songPlayed) {
        this.songPlayed = songPlayed;
    }

    @FXML
    void SaveHighScoreClicked(MouseEvent event) {

        String name = NameTextField.getText().trim();

        if (name.isEmpty()) {
            ScoreLabel.setText("Enter a name!");
            return;
        }

        Player player = new Player(name, finalScore, songPlayed);

        PlayerDataManager manager = new PlayerDataManager();
        manager.savePlayerToFile(player, "data/players.csv");

        ScoreLabel.setText("Saved!");
    }

    @FXML
    void TitleScreenClicked(MouseEvent event) {
        MainApp.showTitleScreenView();
    }
}