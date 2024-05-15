package com.example.darkmode;


import androidx.annotation.IntegerRes;

import java.util.Date;

public class Annonces {
    int id;
    String title;
    int price;
    String description;
    String datePublication;
    String dateFinPublication;
    String dateCreation;
    String dateModification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getDateFinPublication() {
        return dateFinPublication;
    }

    public void setDateFinPublication(String dateFinPublication) {
        this.dateFinPublication = dateFinPublication;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateModification() {
        return dateModification;
    }

    public void setDateModification(String dateModification) {
        this.dateModification = dateModification;
    }

    public Annonces(){}
    public Annonces(String title, int price, String description, String datePublication, String dateFinPublication, String dateCreation, String dateModification){
        this.title = title;
        this.price = price;
        this.description = description;
        this.datePublication = datePublication;
        this.dateFinPublication = dateFinPublication;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }
    public Annonces(String title, int price, String description, String datePublication, String dateFinPublication){
        this.title = title;
        this.price = price;
        this.description = description;
        this.datePublication = datePublication;
        this.dateFinPublication = dateFinPublication;
    }
}
