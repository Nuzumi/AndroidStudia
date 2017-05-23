package com.example.micha.swimzad4;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentData1 extends Fragment {

    String[] spin = {"szeregowy","jednorodzinny","bliżniak"};
    String typ;
    View fView;
    String sklepy;

    public FragmentData1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_data1, container, false);
        sklepy = "pobliskie sklepy: ";
        Spinner spi = (Spinner)v.findViewById(R.id.spinnerD);
        if(spi!=null){
            spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    typ = spin[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, spin);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spi.setAdapter(adapter);
        }
        fView = v;
        return v;
    }

    public void onAttach(Context context){
        super.onAttach(context);
    }

    public void saveD(){
        String[] tmp = new String[4];
        tmp[0] = ((EditText)fView.findViewById(R.id.nazwaD)).getText().toString();
        Helper.listdomTitle.add(tmp[0]);
        Switch s = (Switch)fView.findViewById(R.id.tb);
        if(s.isChecked()){
            tmp[1] = "ma czerwony dach";
        }else {
            tmp[1] = "nie ma czerwonego dachu";
        }
        CheckBox cb = (CheckBox)fView.findViewById(R.id.checkLidl);
        if(cb.isChecked()){
            sklepy = "lidl, ";
        }
        cb = (CheckBox)fView.findViewById(R.id.biedronka);
        if(cb.isChecked()){
            sklepy +="biedronka ";
        }
        cb = (CheckBox)fView.findViewById(R.id.naRogu);
        if(cb.isChecked()){
            sklepy +="na rogu";
        }
        if(sklepy == "pobliskie sklepy: "){
            sklepy = "brak sklepow";
        }
        tmp[2] = sklepy;

        if(typ!=null){
            tmp[3] = typ;
        }else {
            tmp[3] = "szeregowy";
        }
        Helper.listDomContent.add(tmp);
        Toast.makeText(getContext(),"zapisano",Toast.LENGTH_SHORT).show();
    }

}
