package com.example.plantapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class PlantRecViewAdaptor extends RecyclerView.Adapter<PlantRecViewAdaptor.ViewHolder> {
    private ArrayList<Plant> plants = new ArrayList();
    private Context mContext;

    public PlantRecViewAdaptor(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_plant, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG,"onBindViewHolder: Called");
        viewHolder.plantName.setText(plants.get(position).getName());
        Glide.with(mContext).asBitmap()
                .load(plants.get(position).getImageUrl())
                .into(viewHolder.plantImage);
        viewHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                Toast.makeText(mContext, plants.get(position).getName(), Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView parent;
        private ImageView plantImage;
        private TextView plantName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            plantImage = itemView.findViewById(R.id.plantImage);
            plantName = itemView.findViewById(R.id.plantName);
        }
    }
}
