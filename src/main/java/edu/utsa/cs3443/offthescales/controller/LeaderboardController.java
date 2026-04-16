package edu.utsa.cs3443.offthescales.controller;

import edu.utsa.cs3443.offthescales.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.MouseEvent;

public class LeaderboardController {

    @FXML
    private TreeTableView<?> HighScoreTable;

    @FXML
    private TreeTableColumn<?, ?> NameTableColumn;

    @FXML
    private TreeTableColumn<?, ?> ScoreTableColumn;

    @FXML
    private Button TitleScreenButton;

    @FXML
    void TitleScreenClicked(MouseEvent event) {
        MainApp.showTitleScreenView();
    }

}
