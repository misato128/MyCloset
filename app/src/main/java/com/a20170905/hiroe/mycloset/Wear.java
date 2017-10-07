package com.a20170905.hiroe.mycloset;

import java.sql.Statement;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by hiroe on 2017/10/07.
 */

public class Wear extends RealmObject {
    @PrimaryKey
    private long id;
    private String imagePath;
    private String season;
    private String color;
    private String boughtAt;
    private String shopName;
    private int rate;
    private String wearType;

    public Wear(){}
    public Wear(String imagePath, String season, String color, String boughtAt, String shopName, int rate, String wearType) {
        this.imagePath = imagePath;
        this.season = season;
        this.color = color;
        this.boughtAt = boughtAt;
        this.shopName = shopName;
        this.rate = rate;
        this.wearType = wearType;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getImagePath(){
        return imagePath;
    }

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }

    public String getSeason(){
        return season;
    }

    public void setSeason(String season){
        this.season = season;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getBoughtAt(){
        return boughtAt;
    }

    public void setBoughtAt(String boughtAt){
        this.boughtAt = boughtAt;
    }

    public String getShopName(){
        return shopName;
    }

    public void  setShopName(String shopName){
        this.shopName = shopName;
    }

    public int getRate(){
        return rate;
    }

    public void setRate(int rate){
        this.rate = rate;
    }

    public String getWearType(){
        return wearType;
    }

    public void setWearType(String wearType){
        this.wearType = wearType;
    }
}
