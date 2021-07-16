package com.btech.IucHostel.Database.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "systemusers")
public class SystemUsers {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("SystemUserId")
    @Expose
    private int SystemUserId;
    
    @SerializedName("SystemUserName")
    @Expose
    private String SystemUserName;

    @SerializedName("SystemUserPassword")
    @Expose
    private String SystemUserPassword;

    @SerializedName("SystemUserStatus")
    @Expose
    private String SystemUserStatus;

    @SerializedName("SystemUserAddress")
    @Expose
    private String SystemUserAddress;

    @SerializedName("SystemUserNumber")
    @Expose
    private String SystemUserNumber;

    @SerializedName("SystemUserPasswordUpdate")
    @Expose
    private String SystemUserPasswordUpdate;

    @SerializedName("SystemUserEmail")
    @Expose
    private String SystemUserEmail;

    @SerializedName("SystemUserGender")
    @Expose
    private String SystemUserGender;

    public int getSystemUserId() {
        return SystemUserId;
    }

    public void setSystemUserId(int systemUserId) {
        SystemUserId = systemUserId;
    }

    public String getSystemUserName() {
        return SystemUserName;
    }

    public void setSystemUserName(String systemUserName) {
        SystemUserName = systemUserName;
    }

    public String getSystemUserPassword() {
        return SystemUserPassword;
    }

    public void setSystemUserPassword(String systemUserPassword) {
        SystemUserPassword = systemUserPassword;
    }

    public String getSystemUserStatus() {
        return SystemUserStatus;
    }

    public void setSystemUserStatus(String systemUserStatus) {
        SystemUserStatus = systemUserStatus;
    }

    public String getSystemUserAddress() {
        return SystemUserAddress;
    }

    public void setSystemUserAddress(String systemUserAddress) {
        SystemUserAddress = systemUserAddress;
    }

    public String getSystemUserNumber() {
        return SystemUserNumber;
    }

    public void setSystemUserNumber(String systemUserNumber) {
        SystemUserNumber = systemUserNumber;
    }

    public String getSystemUserPasswordUpdate() {
        return SystemUserPasswordUpdate;
    }

    public void setSystemUserPasswordUpdate(String systemUserPasswordUpdate) {
        SystemUserPasswordUpdate = systemUserPasswordUpdate;
    }

    public String getSystemUserEmail() {
        return SystemUserEmail;
    }

    public void setSystemUserEmail(String systemUserEmail) {
        SystemUserEmail = systemUserEmail;
    }

    public String getSystemUserGender() {
        return SystemUserGender;
    }

    public void setSystemUserGender(String systemUserGender) {
        SystemUserGender = systemUserGender;
    }
}
