package edu.utsa.cs3443.offthescales.controller;

import edu.utsa.cs3443.offthescales.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class SongSelectController {

    @FXML
    private Button MainMenuButton;

    @FXML
    private Button Song1Button;

    @FXML
    private Button Song2Button;

    @FXML
    private Button Song3Button;

    @FXML
    void MainMenuClicked(MouseEvent event) {
        MainApp.showTitleScreenView();
    }

    @FXML
    void Song1Clicked(MouseEvent event) {
        MainApp.showMainGameView();
    }

    @FXML
    void Song2Clicked(MouseEvent event) {
        MainApp.showMainGameView();
    }

    @FXML
    void Song3Clicked(MouseEvent event) {
        MainApp.showMainGameView();
    }

}
