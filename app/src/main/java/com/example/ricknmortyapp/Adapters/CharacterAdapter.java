package com.example.ricknmortyapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ricknmortyapp.Models.CharModel;
import com.example.ricknmortyapp.R;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder>{

    Context context;
    List <CharModel> characters;

    public CharacterAdapter(Context context, List<CharModel> characters) {
        this.context = context;
        this.characters = characters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_character, parent, false);
        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CharModel character = characters.get(position);
        holder.bind(character);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvStatus;
        TextView tvSpecies;
        TextView tvGender;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvSpecies = itemView.findViewById(R.id.tvSpecies);
            tvGender = itemView.findViewById(R.id.tvGender);
            ivImage = itemView.findViewById(R.id.ivImage);
        }

        public void bind(CharModel character) {

            tvName.setText(character.getName());
            tvStatus.setText(character.getStatus());
            tvSpecies.setText(character.getSpecies());
            tvGender.setText(character.getGender());
            Glide.with(context).load(character.getImage()).into(ivImage);
        }
    }

}
