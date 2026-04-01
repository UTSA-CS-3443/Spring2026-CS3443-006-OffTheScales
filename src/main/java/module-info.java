module edu.utsa.cs3443.offthescales {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.utsa.cs3443.offthescales to javafx.fxml;
    exports edu.utsa.cs3443.offthescales;
}