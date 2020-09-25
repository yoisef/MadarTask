package com.example.madarsofttask.SaveModule.Activitiy;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.madarsofttask.SaveModule.Adapter.GenderAdapter;
import com.example.madarsofttask.R;
import com.example.madarsofttask.RoomDatabase.UserModel;
import com.example.madarsofttask.ShowModule.Activity.ShowUser;
import com.example.madarsofttask.Utils.BaseActivity;
import com.example.madarsofttask.databinding.SaveScreenBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveActivity extends BaseActivity {

    SaveScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this, R.layout.save_screen);

       initUi();


    }

    void initUi()
    {

        List<CharSequence> list=new ArrayList<>();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.gender)));
        GenderAdapter madapter=new GenderAdapter(this,android.R.layout.simple_spinner_item,list);
        madapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.genderSpinner.setAdapter(madapter);
        binding.genderSpinner.setSelection(0);
        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateUser();
            }
        });


    }

    boolean validateUser()
    {
       String userName=binding.userName.getText().toString();
       String userAge=binding.userAge.getText().toString();
       String userJob=binding.userJob.getText().toString();

       if (userName.equals(""))
       {
           binding.userName.setError(binding.userName.getHint());
           return false;
       }
       if (userAge.equals(""))
       {
           binding.userAge.setError(binding.userName.getHint());
           return false;
       }
       if (userJob.equals(""))
       {
           binding.userJob.setError(binding.userJob.getHint());
           return false;
       }
       if (binding.genderSpinner.getSelectedItemPosition()==0)
       {
           Toast.makeText(this, getResources().getString(R.string.choose_gender), Toast.LENGTH_SHORT).show();
           return false;
       }

       int gender= binding.genderSpinner.getSelectedItemPosition();


        userViewModel.insertUser(new UserModel(userName,userJob,userAge,gender));

        binding.userName.setText(null);
        binding.userAge.setText(null);
        binding.userJob.setText(null);
        binding.genderSpinner.setSelection(0);
        startActivity(new Intent(SaveActivity.this, ShowUser.class));
       return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        binding.userName.requestFocus();
    }
}