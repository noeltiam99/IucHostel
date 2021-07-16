package com.btech.IucHostel.Database.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "rooms")
public class Rooms {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("RoomId")
    @Expose
    private int RoomId;
    
    @SerializedName("RoomNumber")
    @Expose
    private String RoomNumber;

    @SerializedName("RoomHustelName")
    @Expose
    private String RoomHustelName;

    @SerializedName("State")
    @Expose
    private String State;

    @SerializedName("RoomState")
    @Expose
    private String RoomState;

    public int getRoomId() {
        return RoomId;
    }

    public void setRoomId(int roomId) {
        RoomId = roomId;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getRoomHustelName() {
        return RoomHustelName;
    }

    public void setRoomHustelName(String roomHustelName) {
        RoomHustelName = roomHustelName;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getRoomState() {
        return RoomState;
    }

    public void setRoomState(String roomState) {
        RoomState = roomState;
    }
}
