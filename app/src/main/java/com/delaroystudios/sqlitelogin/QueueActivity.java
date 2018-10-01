package com.delaroystudios.sqlitelogin;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

import th.ac.up.se.testdb.RoomDB;

public class QueueActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Integer day, month, year;

    private RoomDB roomDB;

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month + 1;
        this.day = dayOfMonth;

        Button date = (Button) findViewById(R.id.q_date_button);
        date.setText(convertDateToString(year,month+1,dayOfMonth));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);

        Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);


        final DatePickerDialog datePickerDialog = new DatePickerDialog(this, QueueActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        Button date = (Button) findViewById(R.id.q_date_button);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        final Button save = (Button) findViewById(R.id.conq);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                booking();

            }
        });

        final ImageView next2 = (ImageView) findViewById(R.id.backf);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void onStart() {
        super.onStart();
    }

    public void booking() {

        final Spinner time = (Spinner) findViewById(R.id.spinnertime);

        this.roomDB = new RoomDB(this, year.toString(), month.toString(), day.toString(), 2);

        int timei = time.getSelectedItemPosition();

        if (timei == 0) {
            setTime(8, 00);
        } else if (timei == 1) {
            setTime(8, 30);
        } else if (timei == 2) {
            setTime(9, 00);

        } else if (timei == 3) {
            setTime(9, 30);

        } else if (timei == 4) {
            setTime(10, 00);

        } else if (timei == 5) {
            setTime(10, 30);

        } else if (timei == 6) {
            setTime(11, 00);

        } else if (timei == 7) {
            setTime(11, 30);

        } else if (timei == 8) {
            setTime(12, 00);

        } else if (timei == 9) {
            setTime(12, 30);

        } else if (timei == 10) {
            setTime(13, 00);

        } else if (timei == 11) {
            setTime(13, 30);

        } else if (timei == 12) {
            setTime(14, 00);

        } else if (timei == 13) {
            setTime(14, 30);
        } else if (timei == 14) {
            setTime(15, 00);
        } else if (timei == 15) {
            setTime(15, 30);
        } else {
            Log.e("", "");
        }

    }

    public void setTime(Integer hour, Integer minute) {

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText phone = (EditText) findViewById(R.id.phone);
        final Spinner category = (Spinner) findViewById(R.id.spinnercategory);

        if(roomDB.isSpace(hour,minute)){
            if(roomDB.booking(hour, minute, name.getText().toString(), phone.getText().toString(), category.getSelectedItemPosition())){
                Toast.makeText(this,"จองสำเร็จ",Toast.LENGTH_SHORT).show();

                finish();
            }else {
                Toast.makeText(this,"จองไม่สำเร็จ",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"ไม่สำเร็จ เลือกเวลาใหม่",Toast.LENGTH_SHORT).show();
        }

    }

    private String convertDateToString(Integer year, Integer month, Integer day) {
        Integer yea = year + 543;
        return "วันที่ " + day + " " + convertMonth_intToName(month) + " พ.ศ. " + (yea);
    }

    private String convertMonth_intToName(Integer month){
        switch (month) {
            case 1 : return "มกราคม";
            case 2 : return "กุมภาพันธ์";
            case 3 : return "มีนาคม";
            case 4 : return "เมษายน";
            case 5 : return "พฤษภาคม";
            case 6 : return "มิถุนายน";
            case 7 : return "กรกฎาคม";
            case 8 : return "สิงหาคม";
            case 9 : return "กันยายน";
            case 10 : return "ตุลาคม";
            case 11 :return "พฤศจิกายน";
            default : return "ธันวาคม";
        }
    }


}



