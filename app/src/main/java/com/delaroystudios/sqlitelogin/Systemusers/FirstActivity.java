package com.delaroystudios.sqlitelogin.Systemusers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.delaroystudios.sqlitelogin.NEWS.DatabaseHelper;
import com.delaroystudios.sqlitelogin.NEWS.MyDividerItemDecoration;
import com.delaroystudios.sqlitelogin.NEWS.Note;
import com.delaroystudios.sqlitelogin.NEWS.NoteAdapter;
import com.delaroystudios.sqlitelogin.NEWS.RecyclerTouchListener;
import com.delaroystudios.sqlitelogin.QueueActivity;
import com.delaroystudios.sqlitelogin.R;
import com.delaroystudios.sqlitelogin.TicketQActivity;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private NoteAdapter mAdapter;
    private List<Note> notesList = new ArrayList<>();
    private RecyclerView recyclerView;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        Buttomnavigation.disableShiftMode(bottomNavigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_home:
                                Intent intent0 =new Intent(FirstActivity.this,FirstActivity.class);
                                startActivities(new Intent[]{intent0});
                                break;

                            case R.id.item_plus:
                                Intent intent1 =new Intent(FirstActivity.this,QueueActivity.class);
                                startActivities(new Intent[]{intent1});
                                break;

                            case R.id.item_ticket:
                                Intent intent2 =new Intent(FirstActivity.this,TicketQActivity.class);
                                startActivities(new Intent[]{intent2});
                                break;
                            case R.id.item_setting:
                                Intent intent3 =new Intent(FirstActivity.this,Setting.class);
                                startActivities(new Intent[]{intent3});
                                break;
                        }
                        return true;
                    }
                });

        recyclerView = findViewById(R.id.recycler_view1);

        db = new DatabaseHelper(this);

        notesList.addAll(db.getAllNotes());


        mAdapter = new NoteAdapter(this, notesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);


        /**
         * On long press on RecyclerView item, open alert dialog
         * with options to choose
         * Edit and Delete
         * */
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));





    }

}
