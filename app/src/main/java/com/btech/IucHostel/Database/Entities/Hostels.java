package com.btech.IucHostel.Database.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "hostels")
public class Hostels {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("HostelId")
    @Expose
    private int HostelId;
    
    @SerializedName("HostelName")
    @Expose
    private String HostelName;

    @SerializedName("HustelConsumption")
    @Expose
    private Float HustelConsumption;

    @SerializedName("HustelRoomNumbers")
    @Expose
    private int HustelRoomNumbers;

    public int getHostelId() {
        return HostelId;
    }

    public void setHostelId(int hostelId) {
        HostelId = hostelId;
    }

    public String getHostelName() {
        return HostelName;
    }

    public void setHostelName(String hostelName) {
        HostelName = hostelName;
    }

    public Float getHustelConsumption() {
        return HustelConsumption;
    }

    public void setHustelConsumption(Float hustelConsumption) {
        HustelConsumption = hustelConsumption;
    }

    public int getHustelRoomNumbers() {
        return HustelRoomNumbers;
    }

    public void setHustelRoomNumbers(int hustelRoomNumbers) {
        HustelRoomNumbers = hustelRoomNumbers;
    }
}
