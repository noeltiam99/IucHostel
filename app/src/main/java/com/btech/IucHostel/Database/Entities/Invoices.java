package com.btech.IucHostel.Database.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "invoices")
public class Invoices {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private int id;
    
    @SerializedName("NewIndex")
    @Expose
    private String NewIndex;

    @SerializedName("TotalIndexConsumption")
    @Expose
    private float TotalIndexConsumption;

    @SerializedName("Price")
    @Expose
    private float Price;

    @SerializedName("Incharge")
    @Expose
    private String Incharge;

    @SerializedName("Month")
    @Expose
    private String Month;

    @SerializedName("Transportation")
    @Expose
    private float Transportation;

    @SerializedName("HostelNames")
    @Expose
    private int HostelNames;

    @SerializedName("Year")
    @Expose
    private String Year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewIndex() {
        return NewIndex;
    }

    public void setNewIndex(String newIndex) {
        NewIndex = newIndex;
    }

    public float getTotalIndexConsumption() {
        return TotalIndexConsumption;
    }

    public void setTotalIndexConsumption(float totalIndexConsumption) {
        TotalIndexConsumption = totalIndexConsumption;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getIncharge() {
        return Incharge;
    }

    public void setIncharge(String incharge) {
        Incharge = incharge;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public float getTransportation() {
        return Transportation;
    }

    public void setTransportation(float transportation) {
        Transportation = transportation;
    }

    public int getHostelNames() {
        return HostelNames;
    }

    public void setHostelNames(int hostelNames) {
        HostelNames = hostelNames;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}
