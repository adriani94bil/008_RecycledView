package com.recyclerview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.recyclerview.adapters.MiAdaptador;
import com.recyclerview.model.Pais;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MiAdaptador miadapter;
    List<Pais> list= new ArrayList<Pais>();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(new Pais("Haiti",R.drawable.haiti_flag_icon));
        list.add(new Pais("Vaticano",R.drawable.holy_see_flag_icon));
        list.add(new Pais("Honduras",R.drawable.honduras_flag_icon));
        list.add(new Pais("Italia",R.drawable.italy_flag_icon));
        list.add(new Pais("Japon",R.drawable.japan_flag_icon));
        list.add(new Pais("EEUU",R.drawable.jarvis_island_flag_icon));

        RecyclerView recyclerView=findViewById(R.id.listaRecyclerView);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        miadapter=new MiAdaptador(list);
        recyclerView.setAdapter(miadapter);
    }
    public void onAbrirNuevo(View view){
        Intent intent=new Intent(this,AltaNuevoPais.class);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String nombreNuevoPais=data.getStringExtra("nombre");
        Pais pNuevo= new Pais(nombreNuevoPais, R.drawable.haiti_flag_icon);

        miadapter.addPais(pNuevo);
    }
}