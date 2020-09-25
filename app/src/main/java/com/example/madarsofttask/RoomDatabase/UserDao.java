package com.example.madarsofttask.RoomDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface UserDao {

    @Insert
    void insert(UserModel userModel);

    @Query("DELETE FROM user_table")
    void deleteAll();


    @Query("SELECT * from user_table ")
    LiveData<List<UserModel>> getAll_Users();








}