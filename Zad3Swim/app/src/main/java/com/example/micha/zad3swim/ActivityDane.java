package com.example.micha.zad3swim;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class ActivityDane extends AppCompatActivity {

    private FileOutputStream os;
    private FileInputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dane);
    }

    public void zapisz(View view){
        byte[] byff = null;
        try{
            is = openFileInput("dane");
            byff = new byte[1024];
            is.read(byff);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try{
            os = openFileOutput("dane", Context.MODE_PRIVATE);

            os.write(makestring().getBytes());
            os.write(byff);
            os.close();
            Toast.makeText(getApplicationContext(),"zapisano",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String makestring(){
        int k=0;
        if(((RadioButton)findViewById(R.id.mammal)).isChecked()){
            k=1;
        }else {
            if(((RadioButton)findViewById(R.id.bird)).isChecked()){
                k = 2;
            }else {
                if(((RadioButton)findViewById(R.id.reptile)).isChecked()){
                    k=3;
                }
            }
        }

        EditText name = (EditText)findViewById(R.id.editText3Imie);
        EditText data = (EditText)findViewById(R.id.editTextDataUr);
        EditText opis = (EditText)findViewById(R.id.editTextOpis);
        return name.getText()+";"+k+";"+data.getText()+";"+opis.getText()+"#";
    }
}
