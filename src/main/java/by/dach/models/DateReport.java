package by.dach.models;

import java.time.LocalDateTime;

public class DateReport {
    private LocalDateTime date;
    private String personName;
    private String personEmail;
    private String storeName;
    private String storeType;
    private String itemName;
    private int quantity;
    private int personId;

    public DateReport() {
    }

    public DateReport(LocalDateTime date, String personName, String personEmail, String storeName,
                      String storeType, String itemName, int quantity, int personId) {
        this.date = date;
        this.personName = personName;
        this.personEmail = personEmail;
        this.storeName = storeName;
        this.storeType = storeType;
        this.itemName = itemName;
        this.quantity = quantity;
        this.personId = personId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}