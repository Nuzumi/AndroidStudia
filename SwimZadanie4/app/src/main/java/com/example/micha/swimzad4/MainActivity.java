package com.example.micha.swimzad4;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentC.onWybor ,ActionBar.TabListener {

    FragmentC fc;
    FragmentData1 fd1;
    FragmentData2 fd2;
    FragmentList1 fl1;
    FragmentList2 fl2;
    FragmentInfo fi;
    FragmentTransaction transaction;
    ActionBar.Tab tab1;
    ActionBar.Tab tab2;
    ActionBar.Tab tab3;
    ActionBar.Tab tab4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fc = new FragmentC();
        fd1 = new FragmentData1();
        fd2 = new FragmentData2();
        fl1 = new FragmentList1();
        fl2 = new FragmentList2();
        fi = new FragmentInfo();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.dataC,fc);
        transaction.detach(fc);
        transaction.add(R.id.kontener,fd1);
        transaction.detach(fd1);
        transaction.add(R.id.kontener,fd2);
        transaction.detach(fd2);
        transaction.add(R.id.kontener,fl1);
        transaction.detach(fl1);
        transaction.add(R.id.kontener,fl2);
        transaction.detach(fl2);
        transaction.add(R.id.kontener,fi);
        transaction.detach(fi);
        transaction.commit();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(actionBar.NAVIGATION_MODE_TABS);

        tab1 =  actionBar.newTab().setTabListener(this);
        tab1.setIcon(R.drawable.ic_tag_faces_black_24dp);
        tab1.setText(" info");
        actionBar.addTab(tab1);
        tab2 =  actionBar.newTab().setTabListener(this);
        tab2.setIcon(R.drawable.add);
        actionBar.addTab(tab2);
        tab3 =  actionBar.newTab().setTabListener(this);
        tab3.setIcon(R.drawable.house);
        actionBar.addTab(tab3);
        tab4 =  actionBar.newTab().setTabListener(this);
        tab4.setIcon(R.drawable.sky);
        actionBar.addTab(tab4);
        actionBar.show();
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        transaction = getSupportFragmentManager().beginTransaction();

        if(tab == tab1){
            transaction.attach(fi);
        }else {
            if(tab == tab2){
                transaction.attach(fc);
            }else {
                if(tab == tab3){
                    transaction.attach(fl1);
                }else {
                    transaction.attach(fl2);
                }
            }
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.detach(fd1);
        transaction.detach(fd2);
        transaction.detach(fc);
        transaction.detach(fl1);
        transaction.detach(fl2);
        transaction.detach(fi);
        transaction.commit();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onWyborOpcji(int opcja) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.detach(fd1);
        transaction.detach(fd2);
        switch (opcja){
            case 1:
                transaction.attach(fd1);
                break;
            case 2:
                transaction.attach(fd2);
                break;
        }
        transaction.commit();
    }

    public void saveD(View view){
        fd1.saveD();
    }

    public void saveS(View view){
        fd2.saveS();
    }
}
