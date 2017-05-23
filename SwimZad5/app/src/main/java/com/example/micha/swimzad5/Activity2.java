package com.example.micha.swimzad5;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity{

    ImageView imgView ;
    TextView textView ;
    ProgressBar progressBar;
    boolean isRed;
    boolean isBold;
    boolean isItalic;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        imgView = (ImageView)findViewById(R.id.imageView1);
        textView = (TextView) findViewById(R.id.Text1);
        progressBar = (ProgressBar)findViewById(R.id.progresBar);
        registerForContextMenu(textView);
        isRed = false;
        isBold = false;
        isItalic = false;

        progressBar.setOnLongClickListener( new View.OnLongClickListener(){
            public boolean onLongClick(View view){
                if(actionMode!=null){
                    return false;
                }

                actionMode = startActionMode(mActionModeCallback);
                view.setSelected(true);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem option1 = menu.add(0,7771,1,"opcja 1");
        MenuItem option2 = menu.add(0,7772,2,"opcja 2");
        SubMenu subMenu = menu.addSubMenu(0,3,3,"sub menu");
        MenuItem option3 = subMenu.add(0,7774,1,"opcja 3");
        MenuItem option4 = subMenu.add(0,7775,2,"opcja 4");
        option1.setIcon(R.drawable.ic_memory_black_24dp);
        option2.setIcon(R.drawable.ic_restaurant_menu_black_24dp);
        option3.setIcon(R.drawable.ic_panorama_fish_eye_black_24dp);
        option4.setIcon(R.drawable.ic_timelapse_black_24dp);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 7771:
                textView.setText("SWiM");
                break;

            case 7772:
                textView.setText("PWR");
                break;

            case 7774:
                imgView.setScaleX(0.75f);
                imgView.setScaleY(0.75f);
                break;

            case 7775:
                imgView.setScaleX(0.5f);
                imgView.setScaleY(0.5f);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if(v.getId() == textView.getId()){
            inflater.inflate(R.menu.checkable_menu,menu);
        }
        if(isRed){
            menu.findItem(R.id.buttonBackground).setChecked(true);
        }
        if(isBold){
            menu.findItem(R.id.buttonBold).setChecked(true);
        }
        if(isItalic){
            menu.findItem(R.id.buttonItalic).setChecked(true);
        }
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.buttonBackground:
                if(item.isChecked())item.setChecked(true);
                if(isRed){
                    isRed = false;
                    textView.setBackgroundColor(Color.WHITE);
                }else {
                    isRed = true;
                    //isBlue = false;
                    textView.setBackgroundColor(Color.RED);
                }
                break;

            case R.id.buttonBold:
                if(item.isChecked())item.setChecked(true);
                if(isBold){
                    isBold = false;
                    if(isItalic){
                        textView.setTypeface(null, Typeface.ITALIC);
                    }else {
                        textView.setTypeface(null, Typeface.NORMAL);
                    }
                }else {
                    isBold = true;
                    if(isItalic){
                        textView.setTypeface(null, Typeface.BOLD_ITALIC);
                    }else {
                        textView.setTypeface(null, Typeface.BOLD);
                    }
                }
                break;

            case R.id.buttonItalic:
                if(item.isChecked())item.setChecked(true);
                if(isItalic){
                    isItalic = false;
                    if(isBold){
                        textView.setTypeface(null, Typeface.BOLD);
                    }else {
                        textView.setTypeface(null, Typeface.NORMAL);
                    }
                }else {
                    isItalic = true;
                    if(isBold){
                        textView.setTypeface(null, Typeface.BOLD_ITALIC);
                    }else {
                        textView.setTypeface(null, Typeface.ITALIC);
                    }
                }
                break;
        }
        return super.onContextItemSelected(item);
    }




    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback(){
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_action_menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.red:
                    progressBar.getIndeterminateDrawable().setColorFilter(0xFFFF0000, android.graphics.PorterDuff.Mode.MULTIPLY);
                    mode.finish();
                    break;

                case R.id.green:
                    progressBar.getIndeterminateDrawable().setColorFilter(0xFF00FF00, android.graphics.PorterDuff.Mode.MULTIPLY);
                    mode.finish();
                    break;

                case R.id.blue:
                    progressBar.getIndeterminateDrawable().setColorFilter(0xFF0000FF, android.graphics.PorterDuff.Mode.MULTIPLY);
                    mode.finish();
                    break;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };

}
