package qal.lab18.dto;

import java.io.Serializable;

/**
 *
 * @author qal
 */
public class CD implements Serializable {

    String cdName;
    String cdType;
    String title;
    int price;
    String ID;
    int publishYear;

    public CD() {
    }

    public CD(String ID, String title, String cdName, String cdType, int publishYear, int price) {
        this.cdName = cdName;
        this.cdType = cdType;
        this.title = title;
        this.price = price;
        this.ID = ID;
        this.publishYear = publishYear;
    }

    public String getCdName() {
        return cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

    public String getCdType() {
        return cdType;
    }

    public void setCdType(String cdType) {
        this.cdType = cdType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return String.format("%5s|%20s|%12s|%7s|%5d|%6d$",
                getID(), getTitle(), getCdName(), getCdType(), getPublishYear(), getPrice());
    }
}
