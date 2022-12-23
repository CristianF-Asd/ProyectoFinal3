package com.example.proyectofinal1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proyectofinal1.Model.PerfilClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    RecyclerView listaPerfil;
    private DBHelper dbHelper;
    PerfilClass pc;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "name";
    private static final String ARG_PARAM2 = "email";

    // TODO: Rename and change types of parameters
    private String name;
    private String email;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name Parameter 1.
     * @param email Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String name, String email) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, name);
        args.putString(ARG_PARAM2, email);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
            email = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((TextView)view.findViewById(R.id.name)).setText(name);
        ((TextView)view.findViewById(R.id.email)).setText(email);

        listaPerfil = view.findViewById(R.id.listaMetas);
        listaPerfil.setLayoutManager(new LinearLayoutManager(getContext()));

        dbHelper =new DBHelper(getContext());
        dbHelper.OpenDB();

        ArrayList <PerfilClass> perfilClass = new ArrayList<>();


        for(int i=0; i<1; i++){

            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, -i);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
            String formattedDate = df.format(c.getTime());
            //Log.i("Perreo",formattedDate );
            pc = dbHelper.RecolectarInfo(email,formattedDate);
            Log.i("PerfilFragment",pc.getTotal() );
            Log.i("PerfilFragment",pc.getMes() );
            Log.i("PerfilFragment",pc.getProgreso() );

            perfilClass.add(pc);
        }


        PerfilAdapter adapter = new PerfilAdapter(perfilClass);
        listaPerfil.setAdapter(adapter);






    }
}