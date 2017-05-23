package com.example.micha.swimlab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class activityTableL extends AppCompatActivity {

    int clickerCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_l);
    }

    public void powrotDo1(View view){
        onBackPressed();
    }

    public void clickerCountUp(View view){
        clickerCount++;
    }

    public void podsumowanieTableL(View view){
        Switch sw = (Switch)findViewById(R.id.switch1);
        Toast.makeText(getApplicationContext(),"pozycja opcji1:" + sw.isChecked()
        + "\n ilosc klikniec clickera:" + clickerCount,Toast.LENGTH_LONG).show();
    }
}
