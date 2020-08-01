package com.e.petagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    public PetAdapter (ArrayList<Pets> mascotas){
        this.mascotas = mascotas;
    }

    ArrayList<Pets> mascotas;

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pets, parent, false);

        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PetViewHolder holder, int position) {
        final Pets mascota = mascotas.get(position);
        holder.foto.setImageResource(mascota.getImagen());
        holder.nombre.setText(mascota.getNombre());
        holder.votos.setText(String.valueOf(mascota.getVotos()));
        holder.huesoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int i = mascota.getVotos();
               mascota.setVotos(++i);
               holder.votos.setText(String.valueOf(i));

            }
        });
    }

    @Override
    public int getItemCount() {
        try {
            return mascotas.size();
        }catch (Exception e){
            return 0;
        }
    }
    public static class PetViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto, huesoB, huesoA;
        private TextView nombre, votos;
        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.foto);
            huesoA = itemView.findViewById(R.id.huesoA);
            huesoB = itemView.findViewById(R.id.huesoB);
            nombre = itemView.findViewById(R.id.nombre);
            votos = itemView.findViewById(R.id.votos);
        }
    }

}
