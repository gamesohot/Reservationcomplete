package com.delaroystudios.sqlitelogin;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.delaroystudios.sqlitelogin.Admin.AdminActivity;
import com.delaroystudios.sqlitelogin.Systemusers.DateDialog;
import com.delaroystudios.sqlitelogin.R;
import com.delaroystudios.sqlitelogin.sql.MyDBClass;

public class AdminQueueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_queue);

        final ImageView next2 = (ImageView) findViewById(R.id.backb);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView btn_next2 = (ImageView) findViewById(R.id.backb);
                Intent intent = new Intent(AdminQueueActivity.this, AdminActivity.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        });
        super.onStart();
        EditText txtdate=(EditText)findViewById(R.id.txtdate1);
        txtdate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    DateDialog dialog=new DateDialog(v);
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    dialog.show(ft,"DatePicker");
                }
            }
        });


        // btnSave (Save)
        final Button save = (Button) findViewById(R.id.conq1);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // If Save Complete
                if (SaveData()) {
                    // Open Form Main
                    AdminQueueActivity.this.finish();
                }
            }
        });




    }

    public boolean SaveData() {
        //addName,addSyndrome,addRemedy

        final EditText tVegdisName = (EditText) findViewById(R.id.name1);
        final EditText tVegdisArea = (EditText) findViewById(R.id.phone1);
        final EditText tVegdisType = (EditText) findViewById(R.id.txtdate1);
        final Spinner category = (Spinner) findViewById(R.id.spinnercategory1);
        final Spinner time = (Spinner) findViewById(R.id.spinnertime1);


        // Dialog
        final AlertDialog.Builder adb = new AlertDialog.Builder(this);
        AlertDialog ad = adb.create();


        // new Class DB
        final MyDBClass myDb = new MyDBClass(this);


        // Save Data
        long saveStatus = myDb.InsertData(
                tVegdisName.getText().toString(),
                tVegdisArea.getText().toString(),
                tVegdisType.getText().toString(),
                category.getSelectedItem().toString(),
                time.getSelectedItem().toString());
        if (saveStatus <= 0) {
            ad.setMessage("การจองสำเร็จ");
            ad.show();
            return false;
        }
        myDb.close();
        Toast.makeText(AdminQueueActivity.this, "จองสำเร็จแล้ว",
                Toast.LENGTH_SHORT).show();


        return true;

    }



}
