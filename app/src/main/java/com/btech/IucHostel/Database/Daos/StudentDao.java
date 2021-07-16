package com.btech.IucHostel.Database.Daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.btech.IucHostel.Database.Entities.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("select * from student")
    List<Student> getAll();

    @Query("Select * from student where UserMatricule=:matricule AND password=:password")
    Student getFromKeyPair(String matricule, String password);

    @Insert
    void insert(Student student);

    @Insert
    void insertAll(Student... students);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);
}
