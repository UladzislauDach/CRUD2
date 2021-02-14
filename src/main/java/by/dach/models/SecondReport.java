package by.dach.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class SecondReport {
    private int storeId;
    private String storeName;
    private int temp;
    private char chose; // (sum or count)
    private int days;

    public SecondReport() {
    }

    public SecondReport(int storeId, String storeName, int temp, char chose, int days) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.temp = temp;
        this.chose = chose;
        this.days = days;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public char getChose() {
        return chose;
    }

    public void setChose(char chose) {
        this.chose = chose;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}