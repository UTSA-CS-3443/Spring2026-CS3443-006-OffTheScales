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

    @FXML
    private TextField NameTextField;

    @FXML
    private Button SaveHighScoreButton;

    @FXML
    private Label ScoreLabel;

    public void setScore(int score) {
        ScoreLabel.setText(String.valueOf(score));
    }

    @FXML
    private Button TitleScreenButton;

    @FXML
    void SaveHighScoreClicked(MouseEvent event) {

        String name = NameTextField.getText().trim();

        if (name.isEmpty()) {
            ScoreLabel.setText("Enter a name!");
            return;
        }

        int score = Integer.parseInt(ScoreLabel.getText());

        Player player = new Player(name, score, "song1");

        PlayerDataManager manager = new PlayerDataManager();
        manager.savePlayerToFile(player, "data/players.csv");

        ScoreLabel.setText("Saved!");
    }

    @FXML
    void TitleScreenClicked(MouseEvent event) {
        MainApp.showTitleScreenView();
    }



}
