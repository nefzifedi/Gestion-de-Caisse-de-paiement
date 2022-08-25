package com.caisse.caisse.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long id ;

    private String name;

    private long price;

    private String imageUrl;

    @Column(nullable = false,updatable = false)
    private String produitCode;


    public Produit(){}

    public Produit(String name , String imageUrl ,String produitCode, Long price){
        this.price=price;
        this.imageUrl=imageUrl;
        this.name=name;
        this.produitCode=produitCode;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public String getProduitCode() {
        return produitCode;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setProduitCode(String produitCode) {
        this.produitCode = produitCode;
    }

    @Override
    public String toString()
    {
        return "Product{" + "id=" + this.id + ", name='" + this.name + '\'' + ", price='" + this.price + '\'' + ",produitCode ='" + this.produitCode + ", imageUrl='" + this.imageUrl + '\'' +'}';
    }

}

