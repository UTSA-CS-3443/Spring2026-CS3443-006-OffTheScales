package edu.utsa.cs3443.offthescales.controller;

import edu.utsa.cs3443.offthescales.MainApp;
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

    @FXML
    private Button TitleScreenButton;

    @FXML
    void SaveHighScoreClicked(MouseEvent event) {

    }

    @FXML
    void TitleScreenClicked(MouseEvent event) {
        MainApp.showTitleScreenView();
    }

}
