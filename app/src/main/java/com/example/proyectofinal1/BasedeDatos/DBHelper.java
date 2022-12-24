package com.example.proyectofinal1.BasedeDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.proyectofinal1.Model.CantRec;
import com.example.proyectofinal1.Model.PerfilClass;
import com.example.proyectofinal1.Model.User;

import java.util.ArrayList;

public class DBHelper {

    private Context con;
    private SQLiteDatabase db;


    public DBHelper(Context con){
        this.con = con;
    }

    public DBHelper OpenDB(){
        DBConnector dbCon = new DBConnector(con);
        db = dbCon.getWritableDatabase();
        return  this;

    }
    public boolean RegistrarUser(User user){
        try{
            ContentValues cv = new ContentValues();
            cv.put("UserName", user.getUserName());
            cv.put("Email", user.getCorreo());
            cv.put("Password", user.getPassword());

            db.insert("userInfo",null,cv);
            return true;
        }catch(Exception e){
            Toast.makeText(con, e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    public ArrayList<User> LoginUser (String Email, String Password){
        ArrayList<User> userList = new ArrayList<User>();
        try{
            Cursor cursor = db.rawQuery("Select * from userInfo where Email='"+Email+"' and Password='"+Password+"'",null);
            if(cursor.moveToFirst()){
                do{
                    User user =new User();
                    user.setUserName(cursor.getString(0));
                    user.setCorreo(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    userList.add(user);
                }
                while(cursor.moveToNext());
            }
        }catch (Exception e){
            Toast.makeText(con, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return userList;
    }

    public boolean RegistrarCantidades(CantRec cant){
        try{
            ContentValues cv = new ContentValues();

            cv.put("Cant0", cant.getProd0());
            cv.put("Cant1", cant.getProd1());
            cv.put("Cant2", cant.getProd2());
            cv.put("Cant3", cant.getProd3());
            cv.put("Cant4", cant.getProd4());
            cv.put("Email", cant.getEmail());
            db.insert("reciInfo",null,cv);
            return true;
        }catch(Exception e){
            Toast.makeText(con, e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public PerfilClass RecolectarInfo (String Email, String Mes ){
        PerfilClass perfilClass = new PerfilClass();
        try{
            Cursor cursor = db.rawQuery("Select sum(Cant0) + sum(Cant1) + sum(Cant2) + sum(Cant3) + sum(Cant4) as [Total] from reciInfo as V where V.Fecha >= '"+Mes+"-01"+"' AND V.Fecha < '"+Mes+"-30"+"' AND V.Email='"+Email+"'",null);
            if(cursor.moveToFirst()){
                do{
                    perfilClass.setTotal(cursor.getString(0));
                    Log.i("DbHelper",perfilClass.getTotal() );
                    perfilClass.setMes(Mes);
                    int Total = Integer.parseInt(perfilClass.getTotal());
                    int porcentaje = (Total*100)/150;
                    String progreso;

                    if(porcentaje>100){
                         progreso = "100";
                    }else{
                        progreso = String.valueOf(porcentaje);
                    }


                    perfilClass.setProgreso(progreso);
                }
                while(cursor.moveToNext());
            }
        }catch (Exception e){
            Toast.makeText(con, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return perfilClass;
    }


}
