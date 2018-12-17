package kpi.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kpi.db.User;
import kpi.gui.Controller;

import java.sql.ResultSet;

public class AdminWindowController extends Controller {

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem logOutButton;


    @FXML
    private Tab places;

    @FXML
    private Tab clients;

    @FXML
    private Tab festivals;

    @FXML
    private Tab tickets;

    @FXML
    private Tab bands_festivals;

    @FXML
    private Tab genres;

    @FXML
    private Tab bands;

    @FXML
    private TableView<?> genresTable;

    @FXML
    void initialize() {

        logOutButton.setOnAction(event -> {
            User.getUser().setLogin("");
            User.getUser().setPassword("");
            Stage currentStage = (Stage) menuBar.getScene().getWindow();
            currentStage.close();
            openNewScene("LogInWindow.fxml");
        });
    }
}
