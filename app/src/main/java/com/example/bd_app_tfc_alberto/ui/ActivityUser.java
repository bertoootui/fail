package com.example.bd_app_tfc_alberto.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bd_app_tfc_alberto.R;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;


public class ActivityUser extends AppCompatActivity {
    BottomNavigationMenuView nav;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


    }
}
