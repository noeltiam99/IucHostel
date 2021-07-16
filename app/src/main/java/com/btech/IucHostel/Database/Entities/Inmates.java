package com.btech.IucHostel.Database.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Entity(tableName = "inmates")
public class Inmates {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private int id;
    
    @SerializedName("studentName")
    @Expose
    private String studentName;

    @SerializedName("StudentMatricul")
    @Expose
    private Float StudentMatricul;

    @SerializedName("StudentHostel")
    @Expose
    private int StudentHostel;

    @SerializedName("StudentRoom")
    @Expose
    private int StudentRoom;

    @SerializedName("paidAmmount")
    @Expose
    private float paidAmmount;

    @SerializedName("Status")
    @Expose
    private int Status;

    @SerializedName("Date")
    @Expose
    private String Date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Float getStudentMatricul() {
        return StudentMatricul;
    }

    public void setStudentMatricul(Float studentMatricul) {
        StudentMatricul = studentMatricul;
    }

    public int getStudentHostel() {
        return StudentHostel;
    }

    public void setStudentHostel(int studentHostel) {
        StudentHostel = studentHostel;
    }

    public int getStudentRoom() {
        return StudentRoom;
    }

    public void setStudentRoom(int studentRoom) {
        StudentRoom = studentRoom;
    }

    public float getPaidAmmount() {
        return paidAmmount;
    }

    public void setPaidAmmount(float paidAmmount) {
        this.paidAmmount = paidAmmount;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
