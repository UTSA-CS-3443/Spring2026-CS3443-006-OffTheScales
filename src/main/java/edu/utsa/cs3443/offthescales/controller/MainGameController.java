package edu.utsa.cs3443.offthescales.controller;

import edu.utsa.cs3443.offthescales.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainGameController {

    @FXML
    private Button EndGameButton;

    @FXML
    void EndGameClicked(MouseEvent event) {
        MainApp.showGameOverView();
    }

}
