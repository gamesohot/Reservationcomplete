package com.delaroystudios.sqlitelogin.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.delaroystudios.sqlitelogin.AdminPlusQActivity;
import com.delaroystudios.sqlitelogin.AdminQueueActivity;
import com.delaroystudios.sqlitelogin.AdminTicketActivity;
import com.delaroystudios.sqlitelogin.NEWS.MainActivity;
import com.delaroystudios.sqlitelogin.R;
import com.delaroystudios.sqlitelogin.activities.RegisterActivity;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        final Button next3 = (Button) findViewById(R.id.queue);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_next2 = (Button) findViewById(R.id.queue);
                Intent intent = new Intent(AdminActivity.this, AdminQueueActivity.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        });
        final Button next1 = (Button) findViewById(R.id.regis);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_next2 = (Button) findViewById(R.id.regis);
                Intent intent = new Intent(AdminActivity.this, RegisterActivity.class);
                startActivities(new Intent[]{intent});

            }
        });


        final Button next0 = (Button) findViewById(R.id.seeq);
        next0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_next2 = (Button) findViewById(R.id.seeq);
                Intent intent = new Intent(AdminActivity.this, AdminTicketActivity.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        });
        final Button next2 = (Button) findViewById(R.id.news);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_next2 = (Button) findViewById(R.id.news);
                Intent intent = new Intent(AdminActivity.this, MainActivity.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        });

        final Button next4 = (Button) findViewById(R.id.plus);
        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_next2 = (Button) findViewById(R.id.plus);
                Intent intent = new Intent(AdminActivity.this, AdminPlusQActivity.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        });

        final Button next5 = (Button) findViewById(R.id.logh);
        next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_next2 = (Button) findViewById(R.id.logh);
                Intent intent = new Intent(AdminActivity.this, LoginAdminActivity.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        });

    }
}