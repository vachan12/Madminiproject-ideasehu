package com.example.ideasethu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText logusername,logpassword;
    private Button btnlogin;

    private  DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logusername = findViewById(R.id.username);
        logpassword = findViewById(R.id.password);

        btnlogin = findViewById(R.id.login);

        myDB = new DBHelper(this);

        loginUser();

    }

    private void loginUser(){
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDB.checkUser(logusername.getText().toString() , logpassword.getText().toString());
                if (var){
                    Toast.makeText(login.this, "login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this , HomeActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(login.this, "login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void backhome(View view) {
        Intent i = new Intent(login.this,MainActivity.class);
        startActivity(i);
    }

}