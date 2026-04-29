package edu.utsa.cs3443.offthescales.controller;

import edu.utsa.cs3443.offthescales.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class TitleScreenController {

    @FXML
    private Button LeaderboardButton;

    @FXML
    private Button SongSelectButton;

    @FXML
    void LeaderboardClicked(MouseEvent event) {
        MainApp.showLeaderboardView();
    }

    @FXML
    void SongSelectClicked(MouseEvent event) {
        MainApp.showSongSelectView();
    }

}
