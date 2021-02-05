package com.recyclerview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recyclerview.R;
import com.recyclerview.model.Pais;

import java.util.List;

//Adaptador recibe los datos de la BD
public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> {

    private List<Pais> listaPaises;

    public MiAdaptador(List<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }

    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        // la plantilla de cada item va a ser item_pais
        View view= inflater.inflate(R.layout.item_pais, parent, false);
        MiAdaptador.MiViewHolder miViewHolder=new MiAdaptador.MiViewHolder(view);
        return miViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {
        final Pais pais=listaPaises.get(position);
        holder.textView.setText(pais.getNombre());
        holder.imageView.setImageResource(pais.getBandera());
        holder.botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPaises.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,getItemCount());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listaPaises==null) {
            return 0;
        }else{
            return listaPaises.size();
        }
    }

    public class MiViewHolder extends RecyclerView.ViewHolder{

        //manda los datos al item_pais
        public TextView textView;
        public ImageView imageView;
        public Button botonBorrar;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.imageView);
            botonBorrar=itemView.findViewById(R.id.botonBorrar);
        }
        // Pasa los datos a la vista
    }
}
