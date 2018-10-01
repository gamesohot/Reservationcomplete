package com.delaroystudios.sqlitelogin.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.delaroystudios.sqlitelogin.R;

public class AdminNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_news);

        final ImageView next0 = (ImageView) findViewById(R.id.backq);
        next0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView btn_next2 = (ImageView) findViewById(R.id.backq);
                Intent intent = new Intent(AdminNewsActivity.this, AdminActivity.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        });

    }


}
