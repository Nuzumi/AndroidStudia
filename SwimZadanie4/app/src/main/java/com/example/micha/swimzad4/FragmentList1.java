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
public class FragmentList1 extends Fragment {


    ListView listDom;

    public FragmentList1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list1, container, false);
        listDom = (ListView)v.findViewById(R.id.listDom);
        listDom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] content = Helper.listDomContent.get(position);
                Toast.makeText(getContext(),"ilosc pokoi "+content[1]+", "+content[2]+", typ: "+content[3],Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> ad = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,Helper.listdomTitle);
        listDom.setAdapter(ad);
        return v;
    }



}
