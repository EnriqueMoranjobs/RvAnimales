package com.example.recyclrerviewanimales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MiAdaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
}