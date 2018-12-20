package kpi.db;

public class Band {
    private int id;
    private String name;
    private int genre_id;
    private String info;

    public Band(int id, String name, int genre_id, String info) {
        this.id = id;
        this.name = name;
        this.genre_id = genre_id;
        this.info = info;
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

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
