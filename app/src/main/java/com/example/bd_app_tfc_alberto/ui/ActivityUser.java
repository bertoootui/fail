package com.example.bd_app_tfc_alberto.ui;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bd_app_tfc_alberto.R;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.internal.NavigationMenuView;


public class ActivityUser extends AppCompatActivity {
    BottomNavigationMenuView nav;
    CalendarFragment calendarFragment = new CalendarFragment();
    NewDateFragment newDateFragment = new NewDateFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        nav = findViewById(R.id.navBar);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,newDateFragment).commit();




    }
}
