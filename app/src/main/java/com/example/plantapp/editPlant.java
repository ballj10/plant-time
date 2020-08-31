package com.example.plantapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class editPlant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plant);

        final Button button = findViewById(R.id.editDone);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_plant_info);
                EditText name = findViewById(R.id.editPlantName);
                EditText species = findViewById(R.id.editPlantSpecies);
                EditText date = findViewById(R.id.birthday);
                System.out.println(date.getText().toString());
                //MainActivity.getAllPlants().add(new Plant(name.getText().toString(), species.getText().toString(), date, "cactus" ));
            }
        });

        SharedPreferences sharedPref = getSharedPreferences("database", MODE_PRIVATE);

        SharedPreferences.Editor edit = sharedPref.edit();

    }
}
