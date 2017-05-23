package com.example.micha.swimlab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class activityRelativeL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_l);
    }

    public void powrotDo1(View view){
        onBackPressed();
    }

    public void podsumowanieRelative(View view){
        CheckBox cb1 = (CheckBox)findViewById(R.id.checkBox);
        CheckBox cb2 = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox)findViewById(R.id.checkBox3);
        RadioButton rb1 = (RadioButton)findViewById(R.id.radioButton);
        RadioButton rb2 = (RadioButton)findViewById(R.id.radioButton2);
        String rbValue;
        if(rb1.isChecked()){
            rbValue = "Tak";
        }else {
            if(rb2.isChecked()){
                rbValue = "Nie";
            }else{
                rbValue = "bez zaznaczenia";
            }
        }

        Toast.makeText(getApplicationContext(),"stan  " +
                "\nkwadracika1:"+cb1.isChecked() + "\nkwadracika2:"+cb2.isChecked()+
                "\nkwadracika3:"+cb3.isChecked()
                + "\nwartosc RadioButton "+rbValue,Toast.LENGTH_SHORT).show();
    }
}
