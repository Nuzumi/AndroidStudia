package com.example.micha.zad3swim;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;


public class Lista extends AppCompatActivity {
    public String[] Animals = {"?", "Ptabek", "Gekon", "Maniek" };
    private String[] lista1;
    private String[] lista2;
    private  String[] lista5;
    FileInputStream is;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillList1();
        setContentView(R.layout.activity_lista);
        myAdapter adapter = new myAdapter();
        ListView lista3 = (ListView) findViewById(R.id.listaa);
        lista3.setAdapter(adapter);
    }

    private void fillList1(){
        String file = null;
        try{
            is = openFileInput("dane");
            byte[] byff = new byte[1024];
            is.read(byff);
            file = new String(byff,"UTF-8");
        }catch (Exception e) {
            e.printStackTrace();
        }
        if(file!=null){
            lista1 = file.split("#");
            lista2 = new String[lista1.length-1];
            lista5 = new String[lista1.length-1];
            for(int i =0;i<lista2.length;i++){
                lista2[i] = lista1[i].split(";")[0];
                lista5[i] = lista1[i].split(";")[1];
            }
        }

    }

    public class myAdapter extends BaseAdapter {
        private LayoutInflater inflater = null;
        public ImageView img;
        public int getCount() {
            return lista2.length;
        }

        public Object getItem(int position) {
            return lista1[position];
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int poss, View cView, final ViewGroup parent) {
            View mV;
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(cView == null) {
                cView = inflater.inflate(R.layout.listowy, null);
            }
            mV = cView;
            img = (ImageView) mV.findViewById(R.id.row_image);
            if(Integer.parseInt(lista5[poss])==1){
                img.setImageResource(R.drawable.img1);
            }else {
                if(Integer.parseInt(lista5[poss])==2){
                    img.setImageResource(R.drawable.img2);
                }else {
                    img.setImageResource(R.drawable.img3);
                }
            }
            TextView tv1 = (TextView) mV.findViewById(R.id.row_tv1);
            tv1.setText(lista2[poss]);
            TextView tv2 = (TextView) mV.findViewById(R.id.row_tv2);
            tv2.setText(Animals[Integer.parseInt(lista5[poss])]);



            mV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String clickedObj = (String)getItem(poss);
                    pokazOkno(poss);
                }
            });

            return mV;
        }

    }

    public void pokazOkno(int id){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Keke");
        builder.setMessage(lista1[id]);
        builder.create();
        builder.show();
    }

    public String[] unpackString(String data){
        String unpacked[] = data.split(";");
        return unpacked;
    }
}
