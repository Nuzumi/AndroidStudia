package com.example.micha.swimzad4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentList2 extends Fragment {

    ListView listSky;

    public FragmentList2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list2, container, false);
        listSky = (ListView)v.findViewById(R.id.listSky);
        listSky.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] content = Helper.listSkyContent.get(position);
                Toast.makeText(getContext(),"ilosc pięter "+content[1]+", "+content[2]+", deweloper: "+content[3],Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> ad = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,Helper.listSkyTitle);
        listSky.setAdapter(ad);
        return v;
    }

}
