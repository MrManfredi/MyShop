package kpi.db;

public class Band {
    private int id;
    private String name;
    private int genre_id;
    private String genre_name;
    private String info;

    public Band(int id, String name, int genre_id, String genre_name, String info) {
        this.id = id;
        this.name = name;
        this.genre_id = genre_id;
        this.genre_name = genre_name;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public String getInfo() {
        return info;
    }
}
