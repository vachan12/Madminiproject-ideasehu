package com.example.ideasethu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class investorpage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investorpage);


        Intent intent = getIntent();
        String text = intent.getStringExtra(innovatorpage.EXTRA_TEXT);

        TextView textView1 = (TextView) findViewById(R.id.textappear);
        textView1.setText(text);

    }

    public void backhome(View view) {
        Intent i = new Intent(investorpage.this,HomeActivity.class);
        startActivity(i);
    }
}