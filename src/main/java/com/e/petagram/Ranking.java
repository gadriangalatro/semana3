package com.e.petagram;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {
Toolbar aBar;
RecyclerView rankRecycler;
PetAdapter adapter;
ArrayList<String> lista;
ArrayList<Integer> listaf, votos;

ArrayList<Pets> mascotasRank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        aBar = findViewById(R.id.aBar);
        setSupportActionBar(aBar);

        rankRecycler = findViewById(R.id.rankRecycler);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rankRecycler.setLayoutManager(llm);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lista = (ArrayList<String>) getIntent().getSerializableExtra("Lista");
        listaf = (ArrayList<Integer>) getIntent().getSerializableExtra("listaf");
        votos = (ArrayList<Integer>) getIntent().getSerializableExtra("votos");
        llenar();
        adaptador();

    }


    public void adaptador(){
        adapter = new PetAdapter(mascotasRank);
        rankRecycler.setAdapter(adapter);
    }
    public void llenar(){
        mascotasRank= new ArrayList<>();
        Pets pet;
        for (int i = 0; i < 5; i++) {
            String nombre = lista.get(i);
            int foto = listaf.get(i);
            int voto = votos.get(i);
            mascotasRank.add(new Pets(foto, nombre, voto ));

            
        }
    }
}