package edu.utsa.cs3443.offthescales;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
}
