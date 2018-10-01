package com.delaroystudios.sqlitelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.delaroystudios.sqlitelogin.Admin.AdminActivity;
import com.delaroystudios.sqlitelogin.R;
import com.delaroystudios.sqlitelogin.sql.MyDBClass;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ticket);

        final MyDBClass myDb = new MyDBClass(this);
        final ArrayList<HashMap<String, String>> VegdisList = myDb.SelectAllData();

        // listView1
        ListView lisView2 = (ListView)findViewById(R.id.listView2);

        SimpleAdapter sAdap;
        sAdap = new SimpleAdapter(AdminTicketActivity.this, VegdisList, R.layout.activity_column,
                new String[] {"name", "phone","date","category","time"}, new int[] {R.id.name, R.id.phone,R.id.date,R.id.category,R.id.time});
        lisView2.setAdapter(sAdap);

        final ImageView next2 = (ImageView) findViewById(R.id.backa);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView btn_next2 = (ImageView) findViewById(R.id.backa);
                Intent intent = new Intent(AdminTicketActivity.this, AdminActivity.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        });

    }

}
