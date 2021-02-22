package by.dach.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class SecondReport {
    private int storeId;
    private String storeName;
    private int result;
    private char chose; // (sum or count)
    private int days;
    private String pattern;
    private boolean isEmpty;

    public SecondReport() {
    }

    public SecondReport(int storeId, String storeName, int result, char chose, int days, String pattern, boolean isEmpty) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.result = result;
        this.chose = chose;
        this.days = days;
        this.pattern = pattern;
        this.isEmpty = isEmpty;
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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
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

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}