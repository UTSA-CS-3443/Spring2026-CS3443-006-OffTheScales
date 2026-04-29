package edu.utsa.cs3443.offthescales.controller;

import edu.utsa.cs3443.offthescales.MainApp;
import edu.utsa.cs3443.offthescales.model.Player;
import edu.utsa.cs3443.offthescales.model.PlayerDataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.Comparator;
import java.util.List;

public class LeaderboardController {

    @FXML
    private TableView<Player> HighScoreTable;

    @FXML
    private TableColumn<Player, String> NameTableColumn;

    @FXML
    private TableColumn<Player, Integer> ScoreTableColumn;

    @FXML
    private Button TitleScreenButton;

    private ObservableList<Player> playerList;

    private PlayerDataManager manager;

    @FXML
    void TitleScreenClicked(MouseEvent event) {
        MainApp.showTitleScreenView();
    }

    @FXML
    public void initialize() {
        manager = new PlayerDataManager();

        List<Player> players = manager.loadPlayersFromFile("data/players.csv");

        setUpColumns();

        playerList = FXCollections.observableList(players);
        FXCollections.sort(playerList, Comparator.comparing(Player::getScore).reversed());
        HighScoreTable.setItems(playerList);
        HighScoreTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    private void setUpColumns() {
        NameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ScoreTableColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
    }

    @FXML
    void Song1Clicked(MouseEvent event) {
        playerList = FXCollections.observableList(manager.getListFromSong("song1"));
        HighScoreTable.setItems(playerList);
        HighScoreTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    void Song2Clicked(MouseEvent event) {
        playerList = FXCollections.observableList(manager.getListFromSong("song2"));
        HighScoreTable.setItems(playerList);
        HighScoreTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    void Song3Clicked(MouseEvent event) {
        playerList = FXCollections.observableList(manager.getListFromSong("song3"));
        HighScoreTable.setItems(playerList);
        HighScoreTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
