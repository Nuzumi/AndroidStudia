package com.example.micha.zad3swim;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.VectorEnabledTintResources;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView napisPowitalny;
    private SharedPreferences pref;
    private String tekstPowitalny;
    private View mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        napisPowitalny = (TextView)findViewById(R.id.textPowitalny);
        mainView = findViewById(R.id.activity_main);
        pref = getSharedPreferences("plik", Activity.MODE_PRIVATE);
        odczyt();
    }

    protected void onRestart(){
        super.onRestart();
        odczyt();
    }

    public void doWprowadzania(View view){
        Intent doWpro = new Intent(this,wprowadzanie.class);
        startActivity(doWpro);
    }

    public void doListy(View view){
        Intent doLis = new Intent(this,Lista.class);
        startActivity(doLis);
    }

    public void doDanyc(View view){
        Intent doLis = new Intent(this,ActivityDane.class);
        startActivity(doLis);
    }

    private void odczyt(){
        tekstPowitalny = pref.getString("napis","chyba nie bylo");
        napisPowitalny.setText(tekstPowitalny);
        mainView.setBackgroundColor(pref.getInt("tlo", Color.DKGRAY));
        napisPowitalny.setTextColor(pref.getInt("tColor",Color.BLACK));
        napisPowitalny.setTextSize(pref.getInt("wielkosc",25));
    }

}
