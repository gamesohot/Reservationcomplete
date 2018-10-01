package com.delaroystudios.sqlitelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.delaroystudios.sqlitelogin.R;
import com.delaroystudios.sqlitelogin.Systemusers.Buttomnavigation;
import com.delaroystudios.sqlitelogin.Systemusers.FirstActivity;
import com.delaroystudios.sqlitelogin.Systemusers.Setting;
import com.delaroystudios.sqlitelogin.sql.MyDBClass;

import java.util.ArrayList;
import java.util.HashMap;

public class TicketQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_q);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        Buttomnavigation.disableShiftMode(bottomNavigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_home:
                                Intent intent0 =new Intent(TicketQActivity.this,FirstActivity.class);
                                startActivities(new Intent[]{intent0});
                                break;

                            case R.id.item_plus:
                                Intent intent1 =new Intent(TicketQActivity.this,QueueActivity.class);
                                startActivities(new Intent[]{intent1});
                                break;

                            case R.id.item_ticket:
                                Intent intent2 =new Intent(TicketQActivity.this,TicketQActivity.class);
                                startActivities(new Intent[]{intent2});
                                break;
                            case R.id.item_setting:
                                Intent intent3 =new Intent(TicketQActivity.this,Setting.class);
                                startActivities(new Intent[]{intent3});
                                break;
                        }
                        return true;
                    }
                });

        final MyDBClass myDb = new MyDBClass(this);
        final ArrayList<HashMap<String, String>> VegdisList = myDb.SelectAllData();

        // listView1
        ListView lisView1 = (ListView)findViewById(R.id.listView1);

        SimpleAdapter sAdap;
        sAdap = new SimpleAdapter(TicketQActivity.this, VegdisList, R.layout.activity_column,
                new String[] {"name", "phone","date","category","time"}, new int[] {R.id.name, R.id.phone,R.id.date,R.id.category,R.id.time});
        lisView1.setAdapter(sAdap);


        // Show on new activity



    };




}






