package com.example.plantapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Plant> allPlants = new ArrayList<>();
    private RecyclerView plantRecView;
    private PlantRecViewAdaptor adaptor;

    public static ArrayList<Plant> getAllPlants() {
        return allPlants;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plantRecView = findViewById(R.id.plantRecyclerView);
        adaptor = new PlantRecViewAdaptor(this);
        plantRecView.setAdapter(adaptor);
        plantRecView.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList<Plant> test = new ArrayList<>();
        test.add(new Plant("george", "cactus", new Date(), "cactus", "https://tse1.mm.bing.net/th?id=OIP.E9CdEBE9qR6VgHseq2RvgAHaGq&pid=Api"));
        adaptor.setPlants(test);
        final Button button = findViewById(R.id.plant1Button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_plant_info);
            }
        });



        SharedPreferences sharedPref = getSharedPreferences("database", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        //gson.toJson();
    }
}
