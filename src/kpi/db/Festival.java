package kpi.db;

public class Festival {
    private int id;
    private String name;
    private int place_id;
    private String date;
    private int price;
    private int all_tickets;
    private int free_tickets;
    private String info;

    public Festival(int id, String name, int place_id, String date, int price, int all_tickets, int free_tickets, String info) {
        this.id = id;
        this.name = name;
        this.place_id = place_id;
        this.date = date;
        this.price = price;
        this.all_tickets = all_tickets;
        this.free_tickets = free_tickets;
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

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAll_tickets() {
        return all_tickets;
    }

    public void setAll_tickets(int all_tickets) {
        this.all_tickets = all_tickets;
    }

    public int getFree_tickets() {
        return free_tickets;
    }

    public void setFree_tickets(int free_tickets) {
        this.free_tickets = free_tickets;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
