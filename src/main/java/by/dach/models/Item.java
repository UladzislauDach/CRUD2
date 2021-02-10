package by.dach.models;

import java.util.Date;

public class Item {
    private int id;
    private int personId;
    private String name;
    private int quantity;
    private int storeId;
    private String  date;

    public Item(int id, int personId, String name, int quantity, int storeId, String date) {
        this.id = id;
        this.personId = personId;
        this.name = name;
        this.quantity = quantity;
        this.storeId = storeId;
        this.date=date;
    }

    public Item() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
