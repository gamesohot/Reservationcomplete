package com.delaroystudios.sqlitelogin.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.delaroystudios.sqlitelogin.R;
import com.delaroystudios.sqlitelogin.activities.LoginActivity;

public class LoginAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);


        final ImageView next2 = (ImageView) findViewById(R.id.backo);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView btn_next2 = (ImageView) findViewById(R.id.backo);
                Intent intent = new Intent(LoginAdminActivity.this, LoginActivity.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        });


        Button button = (Button) findViewById(R.id.comfirm);
        final EditText txtUsers =(EditText) findViewById(R.id.adminname);
        final EditText txtPass =(EditText) findViewById(R.id.addminpassword);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUser = txtUsers.getText().toString();
                String txtpass = txtPass.getText().toString();
                if ((txtUser.equals("admin"))&&(txtpass.equals("12345678"))) {
                    Intent intent = new Intent(LoginAdminActivity.this, AdminActivity.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(LoginAdminActivity.this, "HELLO ADMIN CRYSTAL", Toast.LENGTH_LONG).show();

                }
               else if ((txtUser.equals("toon_jc2"))&&(txtpass.equals("12345678"))) {
                    Intent intent = new Intent(LoginAdminActivity.this, AdminActivity.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(LoginAdminActivity.this, "HELLO ADMIN TOON", Toast.LENGTH_LONG).show();

                }

                else if ((txtUser.equals("bnkz"))&&(txtpass.equals("12345678"))) {
                    Intent intent = new Intent(LoginAdminActivity.this, AdminActivity.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(LoginAdminActivity.this, "HELLO ADMIN BNKZ", Toast.LENGTH_LONG).show();

                }
               else if ((txtUser.equals("bitch"))&&(txtpass.equals("12345678"))) {
                    Intent intent = new Intent(LoginAdminActivity.this, AdminActivity.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(LoginAdminActivity.this, "HELLO ADMIN BITCH", Toast.LENGTH_LONG).show();


                }else {
                    finish();
                    Toast.makeText(LoginAdminActivity.this,"You are not an admin" ,Toast.LENGTH_LONG).show();



                }


            }
        });

    }

}
