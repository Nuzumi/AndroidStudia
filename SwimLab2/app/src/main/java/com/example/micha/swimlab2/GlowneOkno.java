package com.example.micha.swimlab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GlowneOkno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glowne_okno);
    }

    public void uruchomLinearActivity(View view){
        final Intent intencja1 = new Intent(this,activityLinearL.class);
        startActivity(intencja1);
    }

    public void uruchomRelativeLActivity(View view){
        final Intent intencja2 = new Intent(this,activityRelativeL.class);
        startActivity(intencja2);
    }

    public void uruchomTableLActivity(View view){
        final Intent intencja3 = new Intent(this,activityTableL.class);
        startActivity(intencja3);
    }

    public void uruchomLinearHor(View view){
        final Intent intencja4 = new Intent(this,activityLinHor.class);
        startActivity(intencja4);
    }
}
