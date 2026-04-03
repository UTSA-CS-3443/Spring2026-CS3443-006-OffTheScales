package edu.utsa.cs3443.offthescales;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Driver extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("TitleScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Title Screen");
        stage.setScene(scene);
        stage.show();

    }
}
