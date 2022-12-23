package com.example.proyectofinal1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal1.Model.PerfilClass;

import java.util.ArrayList;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder> {


    ArrayList<PerfilClass> ClasePrefil;
    public PerfilAdapter(ArrayList<PerfilClass> ClasePrefil){
        this.ClasePrefil = ClasePrefil;
    }
    @NonNull
    @Override
    public PerfilAdapter.PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_meta, null, false);
        return new PerfilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilAdapter.PerfilViewHolder holder, int position) {
        holder.txFecha.setText(ClasePrefil.get(position).getMes());
        holder.txReciclaje.setText(ClasePrefil.get(position).getTotal());
        holder.txFecha.setText(ClasePrefil.get(position).getProgreso());



    }

    @Override
    public int getItemCount() {
        return ClasePrefil.size();
    }

    public class PerfilViewHolder extends  RecyclerView.ViewHolder{

        TextView txFecha,txReciclaje, txTotal;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            txFecha = itemView.findViewById(R.id.txFecha);
            txReciclaje = itemView.findViewById(R.id.txReciclaje);
            txTotal = itemView.findViewById(R.id.txTotal);

        }
    }

}
