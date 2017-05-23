package com.example.micha.swimlab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activityResponse extends AppCompatActivity {

    public static String RESPONSE = "RESPONSE";
    private String odebrany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        Intent intent = getIntent();
        Bundle getBundle = intent.getBundleExtra("bundle");
        String odebrnyString = getBundle.getString("pierwszy") + ", " + getBundle.get("drugi");
        TextView tv = (TextView)findViewById(R.id.textResponse);
        tv.setText(odebrnyString);
        odebrany = odebrnyString;
    }

    public void onBackPressed(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(RESPONSE,odebrany);
        setResult(RESULT_OK,resultIntent);
        activityResponse.super.onBackPressed();
    }
}
