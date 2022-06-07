package com.example.bd_app_tfc_alberto.ui;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bd_app_tfc_alberto.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class ActivityUser extends AppCompatActivity {
    BottomNavigationView nav;

    ScriptGroup.Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        nav = findViewById(R.id.navBar);
        final Fragment[] selectedFragment = {new NewDateFragment()};
        getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment[0]).commit();
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.menu_newDate:
                        selectedFragment[0] = new NewDateFragment();
                        nav.setSelected(true);
                        break;
                    case R.id.menu_calendar:
                        selectedFragment[0] = new CalendarFragment();
                        nav.setSelected(true);
                        break;
                    case R.id.menu_profile:
                        selectedFragment[0] = new ProfileFragment();
                        nav.setSelected(true);
                        break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedFragment[0]).commit();
                return true;
            }
        });




    }
}
