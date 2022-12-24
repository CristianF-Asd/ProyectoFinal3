package com.example.proyectofinal1.MenuPrincipal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal1.R;

import java.util.ArrayList;

public class PT_RecyclerViewAdapter extends RecyclerView.Adapter<PT_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    static ArrayList<PlasticModel> plasticModels;

    public PT_RecyclerViewAdapter(Context context, ArrayList<PlasticModel> plasticModels){
        this.context = context;
        this.plasticModels = plasticModels;
    }

    @NonNull
    @Override
    public PT_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Se despliega el layout
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item, parent,false);
        return new PT_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PT_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //Asigna los valores a la vista creada en list_item basado en la posicion del RecyclerView
        holder.tv_fullName.setText(plasticModels.get(position).getPlasticFullName());
        holder.tv_abrevName.setText(plasticModels.get(position).getPlasticAbbrName());
        holder.imageView.setImageResource(plasticModels.get(position).getImagen());
        holder.tv_description.setText(plasticModels.get(position).getDescription());
        holder.tv_example.setText(plasticModels.get(position).getExample());
        boolean isVisible = plasticModels.get(position).isVisibility();
        holder.constraintLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        //Cuantos items estarán desplegados
        return plasticModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //aprovechar las vistas del list_item (parecida al onCreated)

        ImageView imageView;
        TextView tv_fullName, tv_abrevName, tv_description, tv_example;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tv_fullName = itemView.findViewById(R.id.fullName);
            tv_abrevName = itemView.findViewById(R.id.abbrName);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_example = itemView.findViewById(R.id.tv_example);
            constraintLayout = itemView.findViewById(R.id.expanded_layout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PlasticModel pm = plasticModels.get(getAdapterPosition());
                    pm.setVisibility(!pm.isVisibility());
                    notifyItemChanged(getAdapterPosition());


                }
            });

        }
    }
}
