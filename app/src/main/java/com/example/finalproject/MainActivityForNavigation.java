package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivityForNavigation extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.drawer_nav);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_vehicle:
                        Intent intent = new Intent(MainActivityForNavigation.this,Mycontent.class);
                        startActivity(intent);


                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_gallery:
                        Intent intent2 = new Intent(MainActivityForNavigation.this,MainActivity3.class);
                        startActivity(intent2);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_about:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_container, new UploadFragment(), UploadFragment.FRAGMENT_TAG)
                            .commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                }
                return true;
            }
        });


    }
}
