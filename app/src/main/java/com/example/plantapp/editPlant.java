package com.example.plantapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class editPlant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plant);

        final Button button = findViewById(R.id.editDone);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_plant_info);
            }
        });

        SharedPreferences sharedPref = getSharedPreferences("database", MODE_PRIVATE);

        SharedPreferences.Editor edit = sharedPref.edit();

        EditText name = findViewById(R.id.editPlantName);
        EditText species = findViewById(R.id.editPlantSpecies);
        edit.putString("name", name.getText().toString());
        edit.putString("species", name.getText().toString());
        edit.apply();
    }
}
