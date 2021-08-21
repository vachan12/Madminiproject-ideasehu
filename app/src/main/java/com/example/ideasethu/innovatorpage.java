package com.example.ideasethu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class innovatorpage extends AppCompatActivity {

    private static final String TAG = "innovatorpage";


    DatabaseHelper mDatabaseHelper;
    private Button btnadd, btnViewData;
    private EditText editText;

    /*public static final String EXTRA_TEXT = "com.example.ideasethu.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "com.example.ideasethu.EXTRA_NUMBER";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innovatorpage);

        editText = (EditText) findViewById(R.id.editText);
        btnadd = (Button) findViewById(R.id.post);
        btnViewData = (Button) findViewById(R.id.viewidea);
        mDatabaseHelper = new DatabaseHelper(this);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry);
                    editText.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }

            }
        });
        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(innovatorpage.this, ListDataActivity.class);
                startActivity(intent);
            }
        });

    }
    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }



    public void backhome(View view) {
        Intent i = new Intent(innovatorpage.this,home1.class);
        startActivity(i);
    }
}