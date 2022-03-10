package com.example.recyclrerviewanimales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {

    private ArrayList<String> mData;
    private LayoutInflater mInflater;

    //Constructor pasamos datos

    MiAdaptador(Context context, ArrayList<String> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
    }

    @NonNull
    @Override
    // crea los elementos necesaios que va a tener el recyclrer para esto le lo inflamos con la vista del row
    public MiAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //Recupera la posicion del array en el que estamos y asigna en el textview el nombre del animal
    public void onBindViewHolder(@NonNull MiAdaptador.ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.myTextView.setText(animal);
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvAnimales);
        }

    }
}
