package com.btech.IucHostel.Database.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "hostelindex")
public class HostelIndex {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("HostelName")
    @Expose
    private String HostelName;

    @SerializedName("OldIndex")
    @Expose
    private String OldIndex;

    @SerializedName("PrevIndex")
    @Expose
    private String PrevIndex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostelName() {
        return HostelName;
    }

    public void setHostelName(String hostelName) {
        HostelName = hostelName;
    }

    public String getOldIndex() {
        return OldIndex;
    }

    public void setOldIndex(String oldIndex) {
        OldIndex = oldIndex;
    }

    public String getPrevIndex() {
        return PrevIndex;
    }

    public void setPrevIndex(String prevIndex) {
        PrevIndex = prevIndex;
    }
}
