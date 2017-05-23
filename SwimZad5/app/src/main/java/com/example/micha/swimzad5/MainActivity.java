package com.example.micha.swimzad5;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.micha.swimzad5.R.drawable.ic_adb_black_24dp;

public class MainActivity extends AppCompatActivity {

    ImageView imgView ;
    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView = (ImageView)findViewById(R.id.imageView1);
        textView = (TextView) findViewById(R.id.Text1);
        registerForContextMenu(imgView);
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if(v.getId() == imgView.getId()){
            inflater.inflate(R.menu.context_menu,menu);
        }else {
            if(v.getId() == textView.getId()){
                inflater.inflate(R.menu.context_menu2,menu);
            }
        }
        menu.setHeaderTitle("tu jest tytul");
        menu.setHeaderIcon(R.drawable.star);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.contextOpcja21:
                textView.setTextColor(Color.RED);
                break;

            case R.id.contextOpcja22:
                textView.setTextColor(Color.GREEN);
                break;

            case R.id.contextOpcja23:
                textView.setTextColor(Color.BLUE);
                break;

            case R.id.contextOpcja1:
                imgView.setRotation(0);
                break;

            case R.id.contextOpcja2:
                imgView.setRotation(60);
                break;

            case R.id.contextOpcja3:
                imgView.setRotation(-60);
                break;
        }

        return super.onContextItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.opcja1:
                imgView.setScaleX(1);
                imgView.setScaleY(1);
                textView.setTextColor(Color.RED);
                break;

            case R.id.opcja2:
                imgView.setScaleX(0.75f);
                imgView.setScaleY(0.75f);
                textView.setTextColor(Color.GREEN);
                break;

            case R.id.opcja3:
                imgView.setScaleX(0.5f);
                imgView.setScaleY(0.5f);
                textView.setTextColor(Color.BLUE);
                break;

            case R.id.opcja4:
                textView.setText("Android");
                imgView.setRotation(0);
                break;

            case R.id.opcja5:
                textView.setText("BazaDanych");
                imgView.setRotation(60);
                break;

            case R.id.opcja6:
                textView.setText("OCaml");
                imgView.setRotation(-60);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToSecound(View view){
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }
}
