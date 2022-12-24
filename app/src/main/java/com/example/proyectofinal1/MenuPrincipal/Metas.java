package com.example.proyectofinal1.MenuPrincipal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.proyectofinal1.BasedeDatos.DBHelper;
import com.example.proyectofinal1.Model.CantRec;
import com.example.proyectofinal1.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Metas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Metas extends Fragment {

    EditText  cant0, cant1, cant2, cant3, cant4;

    private DBHelper dbHelper;

    Button but_mostDatos;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "email";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String email;
    private String mParam2;


    public Metas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Metas.
     */
    // TODO: Rename and change types and number of parameters
    public static Metas newInstance(String email, String param2) {
        Metas fragment = new Metas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, email);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            email = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_metas,container,false);

        dbHelper= new DBHelper(getContext());
        dbHelper.OpenDB();



        cant0 = (EditText) view.findViewById(R.id.met_0);
        cant1 = (EditText) view.findViewById(R.id.met_1);
        cant2 = (EditText) view.findViewById(R.id.met_2);
        cant3 = (EditText) view.findViewById(R.id.met_3);
        cant4 = (EditText) view.findViewById(R.id.met_4);

        but_mostDatos = view.findViewById(R.id.btnIngrDatos);

        but_mostDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int c0 = Integer.parseInt(cant0.getText().toString());
                int c1 = Integer.parseInt(cant1.getText().toString());
                int c2 = Integer.parseInt(cant2.getText().toString());
                int c3 = Integer.parseInt(cant3.getText().toString());
                int c4 = Integer.parseInt(cant4.getText().toString());



                Calendar c = Calendar.getInstance();
                System.out.println("Current time => " + c.getTime());
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c.getTime());
                String asd = "Cristian@gmail.com";

                CantRec cant = new CantRec(c0, c1, c2, c3, c4, formattedDate, email);

                if(dbHelper.RegistrarCantidades(cant)){

                    HomeFragment fragment1 = new HomeFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment1).commit();
                    Toast.makeText(getActivity().getApplicationContext(), "Datos Registrados", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Registro fallido", Toast.LENGTH_SHORT).show();
                }



            }



        });

        return  view;


    }
}