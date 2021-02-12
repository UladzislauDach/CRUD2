package by.dach.models;

import java.time.LocalDateTime;

public class CustomObjectForReport {
    private int personId;
    private String personName;
    private String itemName;
    private int quantity;
    private String  date; //local date time
   // private LocalDateTime date; //local date time

    public CustomObjectForReport() {
    }

    public CustomObjectForReport(int personId, String personName, String itemName, int quantity, String date) {
        this.personId = personId;
        this.personName = personName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.date = date;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

