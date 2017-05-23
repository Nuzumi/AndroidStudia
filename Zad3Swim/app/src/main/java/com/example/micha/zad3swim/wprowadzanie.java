package com.example.micha.zad3swim;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class wprowadzanie extends AppCompatActivity {

    String[] lista = {"Witaj uzytkowniku", "Welcome user", "привem пользователь"};
    private String napis;
    private SeekBar sbR;
    private SeekBar sbG;
    private SeekBar sbB;
    private CheckBox back;
    private CheckBox textColor;
    private TextView tv;
    private View myApk;
    private EditText et;
    private SharedPreferences myPref;
    private int bColor;
    private int tColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wprowadzanie);
        sbR = (SeekBar)findViewById(R.id.seekBarR);
        sbG = (SeekBar)findViewById(R.id.seekBarG);
        sbB = (SeekBar)findViewById(R.id.seekBarB);
        back = (CheckBox)findViewById(R.id.checkBoxBackground);
        textColor = (CheckBox)findViewById(R.id.checkBoxTextColor);
        tv = (TextView)findViewById(R.id.textView3);
        et = (EditText)findViewById(R.id.editText);
        myApk = findViewById(R.id.activity_wprowadzanie);
        myPref = getSharedPreferences("plik", Activity.MODE_PRIVATE);
        Spinner tekstPow = (Spinner)findViewById(R.id.spinnerTekstPowitalny);
        if(tekstPow!=null){
            tekstPow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    napis = lista[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, lista);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            tekstPow.setAdapter(adapter);
        }
        sbR.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY));
        sbR.getThumb().setColorFilter(Color.RED,PorterDuff.Mode.SRC_IN);
        sbR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sbG.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY));
        sbG.getThumb().setColorFilter(Color.GREEN,PorterDuff.Mode.SRC_IN);
        sbG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sbB.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY));
        sbB.getThumb().setColorFilter(Color.BLUE,PorterDuff.Mode.SRC_IN);
        sbB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void save(View view){
        SharedPreferences.Editor edytor = myPref.edit();
        edytor.putInt("tlo",bColor);
        edytor.putInt("tColor",tColor);
        edytor.putString("napis",napis);
        edytor.putInt("wielkosc", Integer.parseInt(et.getText().toString()));
        edytor.commit();
        Toast.makeText(getApplicationContext(), "Zapisano", Toast.LENGTH_SHORT).show();
    }

    private void changeColor(){
        if(back.isChecked()){
            bColor = Color.rgb(sbR.getProgress(),sbG.getProgress(),sbB.getProgress());
            myApk.setBackgroundColor(bColor);
        }

        if(textColor.isChecked()){
            tColor = Color.rgb(sbR.getProgress(),sbG.getProgress(),sbB.getProgress());
            tv.setTextColor(tColor);
        }
    }
}
