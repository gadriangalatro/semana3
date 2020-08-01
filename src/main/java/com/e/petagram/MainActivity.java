package com.e.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity  {
    Toolbar aBar;
    ArrayList<Pets> mascotas;
    RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aBar = findViewById(R.id.aBar);
        setSupportActionBar(aBar);



        recycler = findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(llm);
        llenarRecycler();
        iniciarAdapter();




    }

    public void iniciarAdapter(){
        PetAdapter adaptador = new PetAdapter(mascotas);
        recycler.setAdapter(adaptador);
    }

    public void llenarRecycler(){
        mascotas = new ArrayList<>();

        mascotas.add(new Pets(R.mipmap.perro1, "Simón") );
        mascotas.add(new Pets(R.mipmap.perro2,"Lucas"));
        mascotas.add(new Pets(R.mipmap.perro3, "Chico"));
        mascotas.add(new Pets(R.mipmap.perro4, "Pirulo"));
        mascotas.add(new Pets(R.mipmap.perro5, "Cachin"));
        mascotas.add(new Pets(R.mipmap.perro6, "RunRun"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        MenuItem getItem = findViewById(R.id.star);

        if (getItem != null) {
            AppCompatButton button = (AppCompatButton) getItem.getActionView();


        }

        return super.onCreateOptionsMenu(menu);
    }

    public void onClick(MenuItem item) {
    ArrayList<Pets> lista = new ArrayList<Pets>();
        ArrayList<String>nombres = new ArrayList<>();
        ArrayList<Integer>fotos = new ArrayList<>();
        ArrayList<Integer>votos = new ArrayList<>();
    Intent torank = new Intent(MainActivity.this, Ranking.class);
   Collections.sort(mascotas, new Comparator<Pets>() {
        @Override
        public int compare(Pets o1, Pets o2) {
            return new Integer(o2.getVotos()).compareTo(new Integer(o1.getVotos()));
        }
    });

   for(int i=0; i<mascotas.size(); i++){
       nombres.add(mascotas.get(i).getNombre());
       fotos.add(mascotas.get(i).getImagen());
       votos.add(mascotas.get(i).getVotos());
   }

        torank.putExtra("Lista", nombres);
        torank.putExtra("listaf", fotos);
        torank.putExtra("votos", votos);
    startActivity(torank);

    }
}