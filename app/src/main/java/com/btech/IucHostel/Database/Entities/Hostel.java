package com.btech.IucHostel.Database.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "hostel")
public class Hostel {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("HostelNames")
    @Expose
    private String HostelNames;

    @SerializedName("HostelRoomCode")
    @Expose
    private int HostelRoomCode;

    @SerializedName("NumberOfRooms")
    @Expose
    private String NumberOfRooms;

    @SerializedName("PricePerRoom")
    @Expose
    private float PricePerRoom;

    @SerializedName("HostelManager")
    @Expose
    private String HostelManager;

    @SerializedName("ManagerContact")
    @Expose
    private String ManagerContact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostelNames() {
        return HostelNames;
    }

    public void setHostelNames(String hostelNames) {
        HostelNames = hostelNames;
    }

    public int getHostelRoomCode() {
        return HostelRoomCode;
    }

    public void setHostelRoomCode(int hostelRoomCode) {
        HostelRoomCode = hostelRoomCode;
    }

    public String getNumberOfRooms() {
        return NumberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        NumberOfRooms = numberOfRooms;
    }

    public float getPricePerRoom() {
        return PricePerRoom;
    }

    public void setPricePerRoom(float pricePerRoom) {
        PricePerRoom = pricePerRoom;
    }

    public String getHostelManager() {
        return HostelManager;
    }

    public void setHostelManager(String hostelManager) {
        HostelManager = hostelManager;
    }

    public String getManagerContact() {
        return ManagerContact;
    }

    public void setManagerContact(String managerContact) {
        ManagerContact = managerContact;
    }
}
