package kpi.gui;


import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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

           try (Connection connection = DriverManager.getConnection(User.getUser().getUrl(), loginField.getText(), passwordField.getText());
                Statement statement = connection.createStatement())
           {
               User.getUser().setLogin(loginField.getText());
               User.getUser().setPassword(passwordField.getText());
               Stage currentStage = (Stage) button.getScene().getWindow();
               currentStage.close();
               openNewScene("AdminWindow.fxml");
           }
           catch (SQLNonTransientConnectionException ex)
           {
               info.setText("Info: Login or Password uncorrected!");
           }
           catch (SQLException ex)
           {
               info.setText("Info: Input login and password!");
               //ex.printStackTrace();
           }



       });
    }
}
