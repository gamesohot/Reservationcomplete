package com.delaroystudios.sqlitelogin.Systemusers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.delaroystudios.sqlitelogin.QueueActivity;
import com.delaroystudios.sqlitelogin.R;
import com.delaroystudios.sqlitelogin.TicketQActivity;
import com.delaroystudios.sqlitelogin.activities.LoginActivity;

public class Setting extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        Buttomnavigation.disableShiftMode(bottomNavigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_home:
                                Intent intent0 = new Intent(Setting.this, FirstActivity.class);
                                startActivities(new Intent[]{intent0});
                                break;

                            case R.id.item_plus:
                                Intent intent1 = new Intent(Setting.this, QueueActivity.class);
                                startActivities(new Intent[]{intent1});
                                break;

                            case R.id.item_ticket:
                                Intent intent2 = new Intent(Setting.this, TicketQActivity.class);
                                startActivities(new Intent[]{intent2});
                                break;
                            case R.id.item_setting:
                                Intent intent3 = new Intent(Setting.this, Setting.class);
                                startActivities(new Intent[]{intent3});
                                break;
                        }
                        return true;
                    }
                });

        final Button btn1 = (Button) findViewById(R.id.logout);
        // Perform action on click
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                finish();
                Intent newActivity = new Intent(Setting.this, LoginActivity.class);
                startActivity(newActivity);
            }
        });




    }


}


