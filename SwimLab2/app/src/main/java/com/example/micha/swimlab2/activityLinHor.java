package com.example.micha.swimlab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activityLinHor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lin_hor);
    }

    public void podsumowanie(View view){
        EditText text = (EditText)findViewById(R.id.textLinH1);
        EditText text2 = (EditText)findViewById(R.id.textLinH2);

        Toast.makeText(getApplicationContext(),"wpisany tekst: " + text.getText() + " " + text2.getText(),Toast.LENGTH_SHORT).show();
    }

    public void powrot(View view){
        onBackPressed();
    }
}
