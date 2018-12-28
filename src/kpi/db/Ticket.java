package kpi.db;

public class Ticket {
    private int id;
    private int client_id;
    private String client_name;
    private int festival_id;
    private String festival_name;

    public Ticket(int id, int client_id, String client_name, int festival_id, String festival_name) {
        this.id = id;
        this.client_id = client_id;
        this.client_name = client_name;
        this.festival_id = festival_id;
        this.festival_name = festival_name;
    }

    public int getId() {
        return id;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public int getFestival_id() {
        return festival_id;
    }

    public String getFestival_name() {
        return festival_name;
    }
}
