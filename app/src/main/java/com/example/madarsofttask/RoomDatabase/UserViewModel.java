package com.example.madarsofttask.RoomDatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mRepository;
    private LiveData<List<UserModel>> allUsers;
    public UserViewModel(@NonNull Application application) {
        super(application);

        mRepository = new UserRepository(application);

        allUsers = mRepository.getAllUsers();
    }

    public LiveData<List<UserModel>> getAllUsers() { return allUsers; }
    public void insertUser(UserModel user) { mRepository.insertUser(user); }
    public void deleteallUsers(){mRepository.deletallUsers();}

}
