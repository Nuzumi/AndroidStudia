package com.example.micha.swimzad4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentData2 extends Fragment {

    View fView;
    String[] spin = {"DachBud","PWR","Microsoft"};
    String typ;

    public FragmentData2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_data2, container, false);
        Spinner spi = (Spinner)v.findViewById(R.id.spinnerS);
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

    public void saveS(){
        String[] tmp = new String[4];
        tmp[0] = ((EditText)fView.findViewById(R.id.nazwaS)).getText().toString();
        Helper.listSkyTitle.add(tmp[0]);
        tmp[1] = ((EditText)fView.findViewById(R.id.iloscPieter)).getText().toString();
        RadioButton rb = (RadioButton)fView.findViewById(R.id.windaNie);
        if(rb.isChecked()){
            tmp[2] = "brak windy";
        }else {
            tmp[2] = "jest winda";
        }
        if(typ!=null){
            tmp[3] = typ;
        }else {
            tmp[3] = "DachBud";
        }
        Helper.listSkyContent.add(tmp);
        Toast.makeText(getContext(),"zapisano",Toast.LENGTH_SHORT).show();
    }

}
