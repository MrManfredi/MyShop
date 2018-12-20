package kpi.db;

public class Ticket {
    private int id;
    private int client_id;
    private int festival_id;

    public Ticket(int id, int client_id, int festival_id) {
        this.id = id;
        this.client_id = client_id;
        this.festival_id = festival_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getFestival_id() {
        return festival_id;
    }

    public void setFestival_id(int festival_id) {
        this.festival_id = festival_id;
    }
}
