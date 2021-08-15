package com.example.ideasethu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class innovatorpage extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.ideasethu.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "com.example.ideasethu.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innovatorpage);

        Button button = (Button) findViewById(R.id.post);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInvestor();

            }
        });
    }
    public void openInvestor() {
        TextInputEditText editText = (TextInputEditText) findViewById(R.id.posting);
        String text = editText.getText().toString();

        Intent intent = new Intent(innovatorpage.this, investorpage.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);

    }

    public void backhome(View view) {
        Intent i = new Intent(innovatorpage.this,HomeActivity.class);
        startActivity(i);
    }
}