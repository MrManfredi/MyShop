package kpi.db;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static List<Client> clients = new ArrayList<>();
    private int id;
    private String name;
    private String surname;
    private String lastname;
    private String phone;
    private String address;

    public Client(int id, String name, String surname, String lastname, String phone, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
    }

    public static List<Client> getClientsList() {
        return clients;
    }

    public static void addClient(Client client) {
        Client.clients.add(client);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
