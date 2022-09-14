module com.example.massunitsconversion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.massunitsconversion to javafx.fxml;
    exports com.example.massunitsconversion;
}