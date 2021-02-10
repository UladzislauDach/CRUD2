package by.dach.models;

public class MyCustomObject {
    private int personId;
    private String name;
    private String email;
    private String itemName;
    private int itemQuantity;
    private String date;

    public MyCustomObject(){}

    public MyCustomObject(int personId, String name, String email, String itemName, int itemQuantity, String date) {
        this.personId = personId;
        this.name = name;
        this.email = email;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
