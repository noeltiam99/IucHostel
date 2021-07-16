package com.btech.IucHostel.Database.Daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.btech.IucHostel.Database.Entities.Localuser;
import com.btech.IucHostel.Database.Entities.Student;

import java.util.List;

@Dao
public interface LocalUserDao {
    @Query("select * from localuser")
    List<Localuser> getAll();

    @Insert
    void insert(Localuser student);

    @Insert
    void insertAll(Localuser... students);

    @Update
    void update(Localuser student);

    @Delete
    void delete(Localuser student);
}
