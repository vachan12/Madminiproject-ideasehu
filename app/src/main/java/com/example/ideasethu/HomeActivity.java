package com.example.ideasethu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button btninnovator, btninvestor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btninnovator = findViewById(R.id.button);
        btninvestor = findViewById(R.id.button2);

        innovator();
        investor();
    }

    private void innovator(){
        btninnovator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this , innovatorpage.class));
                finish();
            }
        });

    }

    private void investor(){

        btninvestor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this , investorpage.class));
                finish();
            }
        });


    }

    public void backhome(View view) {
        Intent i = new Intent(HomeActivity.this,MainActivity.class);
        startActivity(i);
    }
}