package edu.utsa.cs3443.offthescales;

import edu.utsa.cs3443.offthescales.controller.GameOverController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        showTitleScreenView();
    }

    public static void showTitleScreenView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("TitleScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Title Screen");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showSongSelectView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("SongSelectScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Song Select");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showLeaderboardView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("LeaderboardScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Leaderboard");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showGameOverView(int score) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("GameOverScreen.fxml"));
            Scene scene = new Scene(loader.load());

            GameOverController controller = loader.getController();
            controller.setScore(score);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void showMainGameView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("MainGame.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Main Game");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
