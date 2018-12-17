package kpi.db;

import java.util.ArrayList;
import java.util.List;

public class Genre {
    private static List<Genre> genresList = new ArrayList<Genre>();
    private int id;
    private String name;
    private String info;

    public Genre(int id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public static List<Genre> getGenresList() {
        return genresList;
    }

    public static void addGenre(Genre genre) {
        genresList.add(genre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
