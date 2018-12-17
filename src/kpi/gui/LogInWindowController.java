package kpi.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LogInWindowController {

    @FXML
    private Button button;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField loginField;

    @FXML
    private Label info;

    @FXML
    void initialize() {
       button.setOnMouseClicked(event -> {
           info.setText("Button was clicked!");
           //openNewScene("AdminWindow.fxml");
           //Stage stage = (Stage) button.getScene().getRoot();
       });
    }

    public void openNewScene(String window)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("MusicIsMyWay");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
