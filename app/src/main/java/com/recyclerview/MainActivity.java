package com.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.recyclerview.adapters.MiAdaptador;
import com.recyclerview.model.Pais;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Pais> list= new ArrayList<Pais>();
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

        MiAdaptador miadapter=new MiAdaptador(list);
        recyclerView.setAdapter(miadapter);
    }
}