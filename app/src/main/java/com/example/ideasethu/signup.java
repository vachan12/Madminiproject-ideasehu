package com.example.ideasethu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class signup extends AppCompatActivity {
    EditText email_sign,password_sign,password_confirm,name,uname,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=(EditText)findViewById(R.id.name);
        email_sign=(EditText)findViewById(R.id.email);
        password_sign=(EditText)findViewById(R.id.pwd);
        password_confirm=(EditText)findViewById(R.id.pwd1);
        uname=(EditText)findViewById(R.id.uname);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.phone);
    }
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
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
    }

    public void click(View view) {

        String email = email_sign.getText().toString();
        String password = password_sign.getText().toString();
        if (!isvalid(password)) {

            Toast.makeText(signup.this, "password is not strong enough", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(signup.this, login.class);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        startActivity(intent);
    }

    public void backhome(View view) {
        Intent i = new Intent(signup.this,MainActivity.class);
        startActivity(i);
    }
}