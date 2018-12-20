package kpi.db;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class Genre {
    private static List<Genre> genresList = new ArrayList<Genre>();
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty info;

    public Genre(int id, String name, String info) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.info = new SimpleStringProperty(info);
    }

    public static List<Genre> getGenresList() {
        return genresList;
    }

    public static void addGenre(Genre genre) {
        genresList.add(genre);
    }

    public int getId() {
        return id.getValue();
    }

    public void setId(int id) {
        this.id.setValue(id);
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public String getInfo() {
        return info.getValue();
    }

    public void setInfo(String info) {
        this.info.setValue(info);
    }
}
