package com.example.madarsofttask.ShowModule.Activity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.madarsofttask.R;
import com.example.madarsofttask.RoomDatabase.UserModel;
import com.example.madarsofttask.ShowModule.Adapter.UserAdapter;
import com.example.madarsofttask.Utils.BaseActivity;
import com.example.madarsofttask.databinding.ActivityShowUserBinding;

import java.util.List;

public class ShowUser extends BaseActivity  {

    ActivityShowUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_show_user);

        initToolbar(false);
        enableUpButton();
        initUi();
    }

    void initUi()
    {
        userViewModel.getAllUsers().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {

                binding.recycleUser.setLayoutManager(new LinearLayoutManager(ShowUser.this));
                binding.recycleUser.setAdapter(new UserAdapter(ShowUser.this,userModels));
            }
        });


        binding.deleteAllusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.deleteallUsers();
            }
        });

    }


}