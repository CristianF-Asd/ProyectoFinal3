package com.example.proyectofinal1;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class PlasticTypesFragment extends Fragment{
    ArrayList<PlasticModel> plasticModels = new ArrayList<>();
    int[] plasticImg = {R.drawable.icon1_pete, R.drawable.icon2_hdpe, R.drawable.icon3_pvc,
            R.drawable.icon4_ldpe, R.drawable.icon5_pp, R.drawable.icon6_ps, R.drawable.icon7_otro};

    private void setUpPlasticModels(){
        Resources res = getResources();
        String[] plasticNames = res.getStringArray(R.array.full_name_plastic);
        String[] plasticAbbrev = res.getStringArray(R.array.abbreviation_name_plastic);
        String[] plasticDescrip = res.getStringArray(R.array.description);
        String[] plasticExample = res.getStringArray(R.array.examples);

        for (int i = 0; i < plasticNames.length; i++){
            plasticModels.add(new PlasticModel(plasticNames[i],
                    plasticAbbrev[i],
                    plasticImg[i],
                    plasticDescrip[i],
                    plasticExample[i]));
        }
    }

    public PlasticTypesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plastic_types, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.plasticType_recyclerView);
        setUpPlasticModels();
        PT_RecyclerViewAdapter adapter = new PT_RecyclerViewAdapter(getContext(), plasticModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}