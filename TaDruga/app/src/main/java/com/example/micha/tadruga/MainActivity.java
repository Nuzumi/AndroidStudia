package com.example.micha.tadruga;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(),"To jeszcze nie koniec",Toast.LENGTH_SHORT).show();
    }

    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(),"To jeszcze nie koniec",Toast.LENGTH_SHORT).show();
    }

    protected void onRestart(){
        super.onRestart();
        Toast.makeText(getApplicationContext(),"Nie spodziewales sie mnie tutaj, huh?",Toast.LENGTH_SHORT).show();
    }

    public void startApk1(View view){
        String actionName = "com.example.micha.swimlab2.intent1";
        Intent inte = new Intent(actionName);
        startActivity(inte);
    }

    public void startWybieranieNumerow(View view){
        Intent wybieranie = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:000-000-000"));
        startActivity(wybieranie);
    }

    public void startSms(View view){
        Intent sms = new Intent(Intent.ACTION_SENDTO,Uri.parse("sms:666"));
        sms.putExtra("sms_body","Poprosze pizze");
        startActivity(sms);
    }

    public void startCamera(View view){
        Intent camera = new Intent(Intent.ACTION_CAMERA_BUTTON,null);
        startActivity(camera);
    }
}
