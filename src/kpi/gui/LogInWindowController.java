package kpi.gui;


import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kpi.db.ConnectionToDB;
import kpi.db.User;

import java.sql.*;

public class LogInWindowController extends Controller{

    @FXML
    private Button button;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;


    @FXML
    private Label info;

    @FXML
    void initialize() {
       button.setOnMouseClicked(event -> {
           if (ConnectionToDB.setConnection(loginField.getText(), passwordField.getText()))
           {
               Stage currentStage = (Stage) button.getScene().getWindow();
               currentStage.close();
               openNewScene("AdminWindow.fxml");
           }
           else
           {
               info.setText("Info: Login or Password uncorrected!");
           }
       });
    }
}
