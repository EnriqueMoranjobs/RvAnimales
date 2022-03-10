package com.example.recyclrerviewanimales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MiAdaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etAdd = findViewById(R.id.etAdd);
        Button bAdd = findViewById(R.id.btnAdd);

        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Caballo");
        animalNames.add("Vaca");
        animalNames.add("Cerdo");
        animalNames.add("Leon");
        animalNames.add("Aguila");
        animalNames.add("Mariposa");
        animalNames.add("Serpiente");

        RecyclerView recyclerView = findViewById(R.id.rvAnimales);
        LinearLayoutManager mLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);
        adapter = new MiAdaptador(this, animalNames);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                mLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = etAdd.getText().toString();
                int posicionInsercion = (adapter.getPos() >= 0) ? adapter.getPos() + 1 : 0;
                animalNames.add(posicionInsercion,item);
                adapter.notifyItemInserted(posicionInsercion);
                adapter.notifyItemChanged(0, animalNames.size());
            }
        });

        Button bRemove=findViewById(R.id.btnRemove);
        bRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = adapter.getPos();
                animalNames.remove(adapter.getPos());
                adapter.notifyItemRemoved(adapter.getPos());
                adapter.notifyItemRangeChanged(0,animalNames.size());
                adapter.decrementarPos();

            }
        });

    }
}