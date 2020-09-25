package com.example.madarsofttask.Utils;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.example.madarsofttask.R;
import com.example.madarsofttask.RoomDatabase.UserViewModel;

public class BaseActivity extends AppCompatActivity {

    protected UserViewModel userViewModel;
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
    }

    public void initToolbar(boolean isTitleEnabled) {
        mToolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(isTitleEnabled);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return true;
    }

    public void enableUpButton() {
        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
              getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
            getSupportActionBar().setDisplayShowTitleEnabled(false);


        }
    }
}
