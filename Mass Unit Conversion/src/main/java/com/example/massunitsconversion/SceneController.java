package com.example.massunitsconversion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SceneController implements Initializable
{
    @FXML
    private ComboBox<String> massUnitsBox1;
    @FXML
    private ComboBox<String> massUnitsBox2;
    @FXML
    private TextField txtField1, txtField2;

    private String[] units = {"gm", "kg"};

    double MassInGram, MassInKilogram;


    public void initialize(URL url, ResourceBundle rb)
    {
        for (int i = 0; i < units.length; i++)
        {
            massUnitsBox1.getItems().add(units[i].toString());
            massUnitsBox2.getItems().add(units[i].toString());
        }
        massUnitsBox1.setOnAction(this::changeUnit);
        massUnitsBox2.setOnAction(this::changeUnit);
    }

    public void changeUnit(ActionEvent event)
    {

    }
    @FXML
    protected void calculate()
    {
        try {
            if (massUnitsBox1.getValue().equalsIgnoreCase("gm") && massUnitsBox2.getValue().equalsIgnoreCase("kg")) {
                MassInGram = Double.parseDouble(txtField1.getText());
                MassInKilogram = MassInGram / 1000;
                txtField2.setText(Double.toString(MassInKilogram));
            } else if (massUnitsBox1.getValue().equalsIgnoreCase("kg") && massUnitsBox2.getValue().equalsIgnoreCase("gm")) {
                MassInKilogram = Double.parseDouble(txtField1.getText());
                MassInGram = MassInKilogram * 1000;
                txtField2.setText(Double.toString(MassInGram));
            } else if (massUnitsBox1.getValue().equalsIgnoreCase("gm") && massUnitsBox2.getValue().equalsIgnoreCase("gm")) {
                MassInGram = Double.parseDouble(txtField1.getText());
                txtField2.setText(Double.toString(MassInGram));
            } else if (massUnitsBox1.getValue().equalsIgnoreCase("kg") && massUnitsBox2.getValue().equalsIgnoreCase("kg")) {
                MassInKilogram = Double.parseDouble(txtField1.getText());
                txtField2.setText(Double.toString(MassInKilogram));
            }
        } catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("No unit was selected!!!");
            alert.setContentText("Please select unit!!!");
            alert.showAndWait();
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("No mass value was given!!!");
            alert.setContentText("Please enter mass!!!");
            alert.showAndWait();
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong!!!\nOr value maybe out of range!!!");
            alert.setContentText("Please enter correct values and unit!!!");
            alert.showAndWait();
        }
    }

}