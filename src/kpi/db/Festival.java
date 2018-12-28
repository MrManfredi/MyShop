package kpi.db;

public class Festival {
    private int id;
    private String name;
    private int price;
    private int all_tickets;
    private int free_tickets;
    private String date;
    private int place_id;
    private String place_name;
    private String info;

    public Festival(int id, String name, int price, int all_tickets, int free_tickets, String date, int place_id, String place_name, String info) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.all_tickets = all_tickets;
        this.free_tickets = free_tickets;
        this.date = date;
        this.place_id = place_id;
        this.place_name = place_name;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAll_tickets() {
        return all_tickets;
    }

    public int getFree_tickets() {
        return free_tickets;
    }

    public String getDate() {
        return date;
    }

    public int getPlace_id() {
        return place_id;
    }

    public String getPlace_name() {
        return place_name;
    }

    public String getInfo() {
        return info;
    }
}
