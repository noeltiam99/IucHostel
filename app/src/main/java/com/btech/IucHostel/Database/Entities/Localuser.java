package com.btech.IucHostel.Database.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "localuser")
public class Localuser extends Student {

    public Localuser() {
    }

    public Localuser(Student student) {
        this.Hostel = student.getHostel();
        this.id = student.getId();
        this.MonthRegistered = student.getMonthRegistered();
        this.Paid = student.getPaid();
        this.password = student.getPassword();
        this.PayementState = student.getPayementState();
        this.UserMatricule = student.getUserMatricule();
        this.username = student.getUsername();
        this.UserRoomNumber = student.getUserRoomNumber();
    }

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("UserMatricule")
    @Expose
    private String UserMatricule;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("UserRoomNumber")
    @Expose
    private String UserRoomNumber;

    @SerializedName("PayementState")
    @Expose
    private String PayementState;

    @SerializedName("MonthRegistered")
    @Expose
    private String MonthRegistered;

    @SerializedName("Hostel")
    @Expose
    private String Hostel;

    @SerializedName("Paid")
    @Expose
    private String Paid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserMatricule() {
        return UserMatricule;
    }

    public void setUserMatricule(String userMatricule) {
        UserMatricule = userMatricule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRoomNumber() {
        return UserRoomNumber;
    }

    public void setUserRoomNumber(String userRoomNumber) {
        UserRoomNumber = userRoomNumber;
    }

    public String getPayementState() {
        return PayementState;
    }

    public void setPayementState(String payementState) {
        PayementState = payementState;
    }

    public String getMonthRegistered() {
        return MonthRegistered;
    }

    public void setMonthRegistered(String monthRegistered) {
        MonthRegistered = monthRegistered;
    }

    public String getHostel() {
        return Hostel;
    }

    public void setHostel(String hostel) {
        Hostel = hostel;
    }

    public String getPaid() {
        return Paid;
    }

    public void setPaid(String paid) {
        Paid = paid;
    }
}
