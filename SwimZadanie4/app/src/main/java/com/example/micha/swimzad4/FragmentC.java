package com.example.micha.swimzad4;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentC extends Fragment implements RadioGroup.OnCheckedChangeListener{

    AppCompatActivity A1;
    onWybor s1;

    public FragmentC() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState ){
        super.onActivityCreated(savedInstanceState);
        ((RadioGroup)getActivity().findViewById(R.id.radioGroup)).setOnCheckedChangeListener(this);
    }

    public void onAttach(Context context){
        super.onAttach(context);
        try {
            A1 = (AppCompatActivity)context;
            s1 = (onWybor)context;
        }catch (ClassCastException e){
            Toast.makeText(context,"nie dziala",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.filmy:
                s1.onWyborOpcji(1);
                break;
            case R.id.ksiazki:;
                s1.onWyborOpcji(2);
                break;
            default:
                Toast.makeText(getContext(),"nieee",Toast.LENGTH_SHORT).show();
        }
    }

    public interface onWybor{
        public void onWyborOpcji(int opcja);
    }
}
