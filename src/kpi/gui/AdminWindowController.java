package kpi.gui;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import kpi.db.*;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminWindowController extends Controller {

//    menu
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem logOutButton;

//    genres
    @FXML
    private Tab genres;
    @FXML
    private TableView<Genre> genresTable;
    @FXML
    private TableColumn<Genre, SimpleIntegerProperty> genre_id;
    @FXML
    private TableColumn<Genre, String> genre_name;
    @FXML
    private TableColumn<Genre, String> genre_info;
//    clients
    @FXML
    private Tab clients;
    @FXML
    private TableView<Client> clientsTable;
    @FXML
    private TableColumn<Client, Integer> client_id;
    @FXML
    private TableColumn<Client, String> client_name;
    @FXML
    private TableColumn<Client, String> client_surname;
    @FXML
    private TableColumn<Client, String> client_lastname;
    @FXML
    private TableColumn<Client, String> client_phone;
    @FXML
    private TableColumn<Client, String> client_address;

//    insert
    @FXML
    private TextField client_insert_name;
    @FXML
    private TextField client_insert_surname;
    @FXML
    private TextField client_insert_lastname;
    @FXML
    private TextField client_insert_phone;
    @FXML
    private TextField client_insert_address;
    @FXML
    private Button client_insert_button;

//    update
    @FXML
    private GridPane client_update_fields;
    @FXML
    private TextField client_update_id_field;
    @FXML
    private Button client_update_search_button;
    @FXML
    private TextField client_update_name_field;
    @FXML
    private TextField client_update_surname_field;
    @FXML
    private TextField client_update_lastname_field;
    @FXML
    private TextField client_update_phone_field;
    @FXML
    private TextField client_update_address_field;
    @FXML
    private Button client_update_update_button;
    @FXML
    private Button client_update_delete_button;

//    festivals
    @FXML
    private Tab festivals;
    @FXML
    private TableView<Festival> festivalsTable;
    @FXML
    private TableColumn<Festival, Integer> festival_id;
    @FXML
    private TableColumn<Festival, String> festival_name;
    @FXML
    private TableColumn<Festival, Integer> festival_place_id;
    @FXML
    private TableColumn<Festival, String> festival_date;
    @FXML
    private TableColumn<Festival, Integer> festival_price;
    @FXML
    private TableColumn<Festival, Integer> festival_all_tickets;
    @FXML
    private TableColumn<Festival, Integer> festival_free_tickets;
    @FXML
    private TableColumn<Festival, String> festival_info;
//    bands
    @FXML
    private Tab bands;
    @FXML
    private TableView<Band> bandsTable;
    @FXML
    private TableColumn<Band, Integer> band_id;
    @FXML
    private TableColumn<Band, String> band_name;
    @FXML
    private TableColumn<Band, Integer> band_genre_id;
    @FXML
    private TableColumn<Band, String> band_info;
//    tickets
    @FXML
    private Tab tickets;
    @FXML
    private TableView<Ticket> ticketsTable;
    @FXML
    private TableColumn<Ticket, Integer> ticket_id;
    @FXML
    private TableColumn<Ticket, Integer> ticket_client_id;
    @FXML
    private TableColumn<Ticket, Integer> ticket_festival_id;
//    places
    @FXML
    private Tab places;
    @FXML
    private TableView<Place> placesTable;
    @FXML
    private TableColumn<Place, Integer> place_id;
    @FXML
    private TableColumn<Place, String> place_name;
    @FXML
    private TableColumn<Place, String> place_address;
    @FXML
    private TableColumn<Place, String> place_info;
//    bands at festivals
    @FXML
    private Tab BAF;
    @FXML
    private TableView<BandAtFestival> BAFTable;
    @FXML
    private TableColumn<BandAtFestival, Integer> BAF_band_id;
    @FXML
    private TableColumn<BandAtFestival, Integer> BAF_festival_id;

    @FXML
    void initialize() {
        if  (!User.getUser().getLogin().equals("root"))
        {
            festivals.setDisable(true);
            bands.setDisable(true);
            places.setDisable(true);
            genres.setDisable(true);
            BAF.setDisable(true);
        }

        updateClientsTable();

        client_insert_button.setOnMouseClicked(event -> {
            if (client_insert_name.getText().isEmpty() || client_insert_surname.getText().isEmpty() || client_insert_phone.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill in all required fields!");
            }
            else {
                try {
                    PreparedStatement preparedStatement = ConnectionToDB.getConnection().prepareStatement(
                            "INSERT INTO clients (name, surname, lastname, phone, address) VALUES (?, ?, ?, ?, ?)");
                    preparedStatement.setString(1, client_insert_name.getText());
                    preparedStatement.setString(2, client_insert_surname.getText());
                    preparedStatement.setString(3, client_insert_lastname.getText());
                    preparedStatement.setString(4, client_insert_phone.getText());
                    preparedStatement.setString(5, client_insert_address.getText());
                    preparedStatement.executeUpdate();
                    client_insert_name.setText("");
                    client_insert_surname.setText("");
                    client_insert_lastname.setText("");
                    client_insert_phone.setText("");
                    client_insert_address.setText("");
                    updateClientsTable();
                    JOptionPane.showMessageDialog(null, "Client was added successful.");
                } catch (SQLException exc) {
                    exc.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Record where phone = " + client_insert_phone.getText() + " exactly exist!");
                }
            }
        });

        client_update_search_button.setOnMouseClicked(event -> {
            try {
                Integer.parseInt(client_update_id_field.getText());
                PreparedStatement preparedStatement = ConnectionToDB.getConnection().prepareStatement(
                        "select id, name, surname, lastname, phone, address from clients WHERE id = ?");
                preparedStatement.setString(1, client_update_id_field.getText());
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                client_update_name_field.setText(resultSet.getString("name"));
                client_update_surname_field.setText(resultSet.getString("surname"));
                client_update_lastname_field.setText(resultSet.getString("lastname"));
                client_update_phone_field.setText(resultSet.getString("phone"));
                client_update_address_field.setText(resultSet.getString("address"));
                client_update_fields.setDisable(false);
                client_update_update_button.setDisable(false);
                client_update_delete_button.setDisable(false);
            }
            catch (SQLException e)
            {
                // e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Record where id = " + client_update_id_field.getText() + " is not found!");
                cleanAndDisableClientUpdateFields();
            }
            catch (Exception parseException)
            {
                // parseException.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Number expected in 'ID' field but '" + (client_update_id_field.getText().isEmpty() ? "nothing" : client_update_id_field.getText()) + "' was founded!");
                client_update_name_field.setText("");
                client_update_surname_field.setText("");
                client_update_lastname_field.setText("");
                client_update_phone_field.setText("");
                client_update_address_field.setText("");
                client_update_fields.setDisable(true);
                client_update_update_button.setDisable(true);
            }
        });

        client_update_update_button.setOnMouseClicked(event -> {
            if (client_update_name_field.getText().isEmpty() || client_update_surname_field.getText().isEmpty() || client_update_phone_field.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill in all required fields!");
            }
            else{
                try {
                    PreparedStatement preparedStatement = ConnectionToDB.getConnection().prepareStatement(
                            "UPDATE clients SET name = ?, surname = ?, lastname = ?, phone = ?, address = ? WHERE id = ?");
                    preparedStatement.setString(1, client_update_name_field.getText());
                    preparedStatement.setString(2, client_update_surname_field.getText());
                    preparedStatement.setString(3, client_update_lastname_field.getText());
                    preparedStatement.setString(4, client_update_phone_field.getText());
                    preparedStatement.setString(5, client_update_address_field.getText());
                    preparedStatement.setString(6, client_update_id_field.getText());
                    preparedStatement.executeUpdate();
                    cleanAndDisableClientUpdateFields();
                    updateClientsTable();
                    JOptionPane.showMessageDialog(null, "Client was updated successful.");
                }
                catch (SQLException exc)
                {
                    exc.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Record where phone = " + client_insert_phone.getText() + " exactly exist!");
                }
            }
        });

        client_update_delete_button.setOnMouseClicked(event -> {
            if (JOptionPane.showInputDialog("You are trying to remove the client from the database. To confirm, enter his id").equals(client_update_id_field.getText()))
            {
                try {
                    PreparedStatement preparedStatement = ConnectionToDB.getConnection().prepareStatement(
                            "DELETE FROM clients WHERE id = ?");
                    preparedStatement.setString(1, client_update_id_field.getText());
                    preparedStatement.executeUpdate();
                    updateClientsTable();
                    JOptionPane.showMessageDialog(null, "Record where id = " + client_update_id_field.getText() + " was deleted successfully!");
                    cleanAndDisableClientUpdateFields();
                }
                catch (SQLException e)
                {
                    //e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Record where id = " + client_update_id_field.getText() + " cannot be deleted!");
                }
            }
        });

        genres.setOnSelectionChanged(event -> {
            try {
                ResultSet resultSet = ConnectionToDB.getStatement().executeQuery("select id, name, info from genres");
                Genre.getGenresList().clear();
                while (resultSet.next()) {
                    Genre.addGenre(new Genre(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("info")));
                }
                ObservableList<Genre> genres = FXCollections.observableArrayList(Genre.getGenresList());
                genre_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                genre_name.setCellValueFactory(new PropertyValueFactory<>("name"));
                genre_info.setCellValueFactory(new PropertyValueFactory<>("info"));
                genresTable.setScaleShape(true);
                genresTable.setItems(genres);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Can't execute query to DB!");
            }
        });

        festivals.setOnSelectionChanged(event -> {
            try {
                ResultSet resultSet = ConnectionToDB.getStatement().executeQuery("select id, name, place_id, date, price, all_tickets, free_tickets, info from festivals");
                ObservableList<Festival> festivalsList = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    festivalsList.add(new Festival(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("place_id"),
                            resultSet.getString("date"),
                            resultSet.getInt("price"),
                            resultSet.getInt("all_tickets"),
                            resultSet.getInt("free_tickets"),
                            resultSet.getString("info")));
                }
                festival_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                festival_name.setCellValueFactory(new PropertyValueFactory<>("name"));
                festival_place_id.setCellValueFactory(new PropertyValueFactory<>("place_id"));
                festival_date.setCellValueFactory(new PropertyValueFactory<>("date"));
                festival_price.setCellValueFactory(new PropertyValueFactory<>("price"));
                festival_all_tickets.setCellValueFactory(new PropertyValueFactory<>("all_tickets"));
                festival_free_tickets.setCellValueFactory(new PropertyValueFactory<>("free_tickets"));
                festival_info.setCellValueFactory(new PropertyValueFactory<>("info"));
                festivalsTable.setItems(festivalsList);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Can't execute query to DB!");
            }
        });

        bands.setOnSelectionChanged(event ->{
            try {
                ResultSet resultSet = ConnectionToDB.getStatement().executeQuery("select id, name, genre_id, info from bands");
                ObservableList<Band> bandsList = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    bandsList.add(new Band(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("genre_id"),
                            resultSet.getString("info")));
                }
                band_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                band_name.setCellValueFactory(new PropertyValueFactory<>("name"));
                band_genre_id.setCellValueFactory(new PropertyValueFactory<>("genre_id"));
                band_info.setCellValueFactory(new PropertyValueFactory<>("info"));
                bandsTable.setItems(bandsList);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Can't execute query to DB!");
            }
        } );

        tickets.setOnSelectionChanged(event -> {
            try {
                ResultSet resultSet = ConnectionToDB.getStatement().executeQuery(
                        "select id, client_id, festival_id from tickets");
                ObservableList<Ticket> ticketsList = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    ticketsList.add(new Ticket(
                            resultSet.getInt("id"),
                            resultSet.getInt("client_id"),
                            resultSet.getInt("festival_id")));
                }
                ticket_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                ticket_client_id.setCellValueFactory(new PropertyValueFactory<>("client_id"));
                ticket_festival_id.setCellValueFactory(new PropertyValueFactory<>("festival_id"));
                ticketsTable.setItems(ticketsList);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Can't execute query to DB!");
            }
        });

        BAF.setOnSelectionChanged(event -> {
            try {
                ResultSet resultSet = ConnectionToDB.getStatement().executeQuery("select band_id, festival_id from bands_at_festivals");
                ObservableList<BandAtFestival> bandsAtFestivalsList = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    bandsAtFestivalsList.add(new BandAtFestival(
                            resultSet.getInt("band_id"),
                            resultSet.getInt("festival_id")));
                }
                BAF_band_id.setCellValueFactory(new PropertyValueFactory<>("band_id"));
                BAF_festival_id.setCellValueFactory(new PropertyValueFactory<>("festival_id"));
                BAFTable.setItems(bandsAtFestivalsList);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Can't execute query to DB!");
            }
        });

        places.setOnSelectionChanged(event -> {
            try {
                ResultSet resultSet = ConnectionToDB.getStatement().executeQuery("select id, name, address, info from places");
                ObservableList<Place> placesList = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    placesList.add(new Place(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("address"),
                            resultSet.getString("info")));
                }
                place_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                place_name.setCellValueFactory(new PropertyValueFactory<>("name"));
                place_address.setCellValueFactory(new PropertyValueFactory<>("address"));
                place_info.setCellValueFactory(new PropertyValueFactory<>("info"));
                placesTable.setItems(placesList);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Can't execute query to DB!");
            }
        });

        logOutButton.setOnAction(event -> {
            User.getUser().setLogin("");
            User.getUser().setPassword("");
            Stage currentStage = (Stage) menuBar.getScene().getWindow();
            currentStage.close();
            openNewScene("LogInWindow.fxml");
        });
    }

    private void cleanAndDisableClientUpdateFields()
    {
        client_update_fields.setDisable(true);
        client_update_update_button.setDisable(true);
        client_update_delete_button.setDisable(true);
        client_update_id_field.setText("");
        client_update_name_field.setText("");
        client_update_surname_field.setText("");
        client_update_lastname_field.setText("");
        client_update_phone_field.setText("");
        client_update_address_field.setText("");
        client_update_fields.setDisable(true);
    }

    private void updateClientsTable() {
        try {
            ResultSet resultSet = ConnectionToDB.getStatement().executeQuery(
                    "select id, name, surname, lastname, phone, address from clients");
            Client.getClientsList().clear();
            while (resultSet.next()) {
                Client.addClient(new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")));
            }
            ObservableList<Client> clients = FXCollections.observableArrayList(Client.getClientsList());
            client_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            client_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            client_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
            client_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            client_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            client_address.setCellValueFactory(new PropertyValueFactory<>("address"));
            clientsTable.setItems(clients);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Can't execute query to DB!");
        }
    }
}

