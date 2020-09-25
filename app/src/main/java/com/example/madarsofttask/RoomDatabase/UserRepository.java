package com.example.madarsofttask.RoomDatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<UserModel>> allUsers;
      UserRepository (Application application) {
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        allUsers =userDao.getAll_Users();


    }

    LiveData<List<UserModel>> getAllUsers() {
        return allUsers;
    }

    public void insertUser(UserModel newUser) {
        new insertUserAsyncTask(userDao).execute(newUser);
    }
    public void deletallUsers(){new deleteallUsers(userDao).execute();}
    private static class insertUserAsyncTask extends AsyncTask<UserModel, Void, Void> {

        private UserDao asyncTaskDao;

        insertUserAsyncTask(UserDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final UserModel... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
    private static class deleteallUsers extends AsyncTask<Long, Void, Void> {

        private UserDao mAsyncTaskDao;

        deleteallUsers(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Long... params) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

}

