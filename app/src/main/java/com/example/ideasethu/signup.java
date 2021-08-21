package com.example.ideasethu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    private EditText email_sign,password_sign,password_confirm,uname;
    private Button btnsignup;
    private DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email_sign = findViewById(R.id.email);
        password_sign = findViewById(R.id.pwd);
        password_confirm = findViewById(R.id.pwd1);
        uname = findViewById(R.id.uname);

        btnsignup = findViewById(R.id.sbutton);

        myDB = new DBHelper(this);

        insertUser();

    }

   /* Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern number= Pattern.compile("^.*[0-9].*$");
    Pattern special_char= Pattern.compile("^.*[~a-z A-Z 0-9].*$");

    private Boolean isvalid(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!lowercase.matcher(password).matches()) {
            return false;
        }
        if (!uppercase.matcher(password).matches()) {
            return false;
        }
        if (!number.matcher(password).matches()) {
            return false;
        }
        return special_char.matcher(password).matches();
    }*/

    private void  insertUser(){
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uname.getText().toString().equals("")
                        || password_sign.getText().toString().equals(""))
                {
                    Toast.makeText(signup.this, "please enter the details", Toast.LENGTH_SHORT).show();
                }
                boolean var = myDB.registerUser(uname.getText().toString() , email_sign.getText().toString() , password_sign.getText().toString());
                if (var){
                    Toast.makeText(signup.this, "registered successfully", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(signup.this , login.class));
                    finish();
                }
                else
                    Toast.makeText(signup.this, "registration failed", Toast.LENGTH_SHORT).show();


        }
    });
    }

    public void backhome(View view) {
        Intent i = new Intent(signup.this,HomeActivity.class);
        startActivity(i);
    }
}


    /*public void click(View view) {

        String email = email_sign.getText().toString();
        String password = password_sign.getText().toString();
        if (!isvalid(password)) {

            Toast.makeText(signup.this, "password is not strong enough", Toast.LENGTH_SHORT).show();
        }

    }*/