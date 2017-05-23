package com.example.micha.swimlab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class activityLinearL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_l);
    }

    public void powrotDo1(View view){
        onBackPressed();
    }

    public void podsumowanieLiner(View view){
        EditText insertText2 = (EditText)findViewById(R.id.tekstDoWprowadzenia);
        EditText insertText = (EditText)findViewById(R.id.editText);
        ToggleButton tgButton = (ToggleButton)findViewById(R.id.OnOfLinear);
        Toast.makeText(getApplicationContext(), "Guzik: " + tgButton.isChecked() + " tekst1: "+ insertText.getText().toString() +" tekst2:"+ insertText2.getText().toString(),Toast.LENGTH_SHORT).show();
    }

    public void doKolejnegoOkna(View view){
        Bundle stringBundle = new Bundle();
        stringBundle.putString("pierwszy",((EditText)findViewById(R.id.editText)).getText().toString());
        stringBundle.putString("drugi",((EditText)findViewById(R.id.tekstDoWprowadzenia)).getText().toString());

        Intent intencja = new Intent(getApplicationContext(),activityResponse.class);
        intencja.putExtra("bundle",stringBundle);
        startActivityForResult(intencja,2);
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        EditText insertText = (EditText)findViewById(R.id.editText);
        insertText.setText(data.getStringExtra(activityResponse.RESPONSE));
    }
}
