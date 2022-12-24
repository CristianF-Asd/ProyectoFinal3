package com.example.proyectofinal1.RegistroyLogin;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectofinal1.BasedeDatos.DBHelper;
import com.example.proyectofinal1.Model.User;
import com.example.proyectofinal1.MenuPrincipal.NavigationDrawer;
import com.example.proyectofinal1.R;
import com.example.proyectofinal1.View.CallFragment;

import java.util.ArrayList;


public class LoginFragment extends Fragment {
    
    Button btnLogin,btnRegistro;
    EditText etUserName, etPassword;
    CallFragment callFragment;
    private DBHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        etUserName = view.findViewById(R.id.et_username);
        etPassword = view.findViewById(R.id.etpassword);

        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnRegistro = (Button) view.findViewById(R.id.btnRegistro);

        dbHelper =new DBHelper(getContext());
        dbHelper.OpenDB();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(validateEmail() && validatePassword()){
                    ArrayList<User> users = dbHelper.LoginUser(etUserName.getText().toString(), etPassword.getText().toString());
                    if(users.size()!= 0 ){
                        User uses1 = users.get(0);
                        Intent intent = new Intent(LoginFragment.this.getContext(), NavigationDrawer.class);
                        intent.putExtra("name",uses1.getUserName());
                        intent.putExtra("email",uses1.getCorreo());
                        startActivity(intent);

                        Toast.makeText(getActivity().getApplicationContext(), "Usuario Valido", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(getActivity().getApplicationContext(), "Usuario No Valido", Toast.LENGTH_SHORT).show();
                    }

                }


                    return;
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callFragment!=null){
                    callFragment.changeFragment();
                }
            }
        });


        return  view;
    }
    public void setCallFragment (CallFragment callFragment){
        this.callFragment = callFragment;
    }

    public Boolean validateEmail(){
        String value = etUserName.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(value.isEmpty()){
            etUserName.setError("Rellene el campo vacio");
            return false;
        }else if(!value.matches(emailPattern)) {
            etUserName.setError("Correo electronico invalido");
            return false;
        }else{
            etUserName.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String value = etPassword.getText().toString();
        String passwordPattern = "^"+
                "(?=.*[a-zA-Z0-9])" +   //cualquier caracter
                "(?=\\s+$)" +           //sin espacios en blanco
                ".{4,}" +               //mas de 4 caracteres
                "$";

        if(value.isEmpty()){
            etPassword.setError("Rellene el campo vacio");
            return false;
        }
        //else if(!value.matches(passwordPattern)) {
          //  etPassword.setError("contraseña invalido");
            //etPassword.requestFocus();
            //return false;
        //}
        else{
            etPassword.setError(null);
            return true;
        }
    }

}