package com.example.madarsofttask.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "userName")
    private String userName;

    @ColumnInfo(name = "userJobTitle")
    private String userJobTitle;

    @ColumnInfo(name = "userAge")
    private String userAge;

    @ColumnInfo(name = "useGender")
    private int useGender;

    public UserModel(String userName, String userJobTitle, String userAge, int useGender) {
        this.userName = userName;
        this.userJobTitle = userJobTitle;
        this.userAge = userAge;
        this.useGender = useGender;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserJobTitle() {
        return userJobTitle;
    }

    public void setUserJobTitle(String userJobTitle) {
        this.userJobTitle = userJobTitle;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public int getUseGender() {
        return useGender;
    }

    public void setUseGender(int useGender) {
        this.useGender = useGender;
    }

}
