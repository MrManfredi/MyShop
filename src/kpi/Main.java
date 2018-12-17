package kpi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("gui/LogInWindow.fxml"));
            primaryStage.setTitle("MusicIsMyWay");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/MyShopDB?useSSL=false";
//        String userName = "root";
//        String password = "root";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        }
//        catch (ClassNotFoundException e)
//        {
//            e.printStackTrace();
//            return;
//        }
//        try (Connection connection = DriverManager.getConnection(url, userName, password);
//             Statement statement = connection.createStatement())
//        {
//            //statement.executeUpdate("INSERT into clients (name, surname, lastname, age, phone)  VALUE ('Frank', 'Malkov', 'Biggest', 21, '0686645987')");
//            ResultSet resultSet = statement.executeQuery("select id, name, surname, phone from clients");
//            while (resultSet.next())
//            {
//                System.out.print(resultSet.getInt("id") + " ");
//                System.out.print(resultSet.getString("name") + " ");
//                System.out.print(resultSet.getString("surname") + " ");
//                System.out.println(resultSet.getString("phone"));
//            }
//            String band = "Slipknot";
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, (SELECT name FROM genres WHERE id = genre_id) AS genre FROM bands WHERE name = ?");
//            preparedStatement.setString(1, band);
//            ResultSet band_info = preparedStatement.executeQuery();
//            while (band_info.next())
//            {
//                System.out.print(band_info.getInt("id") + " " + band_info.getString("name") + " " + band_info.getString("genre"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
