package com.example.recycleview1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HeroRecycleViewAdapter extends RecyclerView.Adapter<HeroRecycleViewAdapter.HeroViewHolder> {
    private final OnItemClickListener onItemClickListener;
    private final Context context;
    private final ArrayList<Hero> heroes;

    public HeroRecycleViewAdapter(Context context, ArrayList<Hero> heroes, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.heroes = heroes;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public HeroRecycleViewAdapter.HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.hero_row_rv, parent, false);
        return new HeroRecycleViewAdapter.HeroViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroRecycleViewAdapter.HeroViewHolder holder, int position) {
        holder.tvName.setText(heroes.get(position).getName());
        holder.tvDesc.setText(heroes.get(position).getDescription());
        holder.ivHero.setImageResource(heroes.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public static class HeroViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivHero;
        private final TextView tvName;
        private final TextView tvDesc;

        public HeroViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);

            ivHero = itemView.findViewById(R.id.ivHero);
            tvName = itemView.findViewById(R.id.tvName);
            tvDesc = itemView.findViewById(R.id.tvDesc);

            itemView.setOnClickListener(view -> {
                if(onItemClickListener != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        onItemClickListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
