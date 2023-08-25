package com.example.progetto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GenreTagAdapter extends RecyclerView.Adapter<GenreTagHolder> {

    Context context;
    List<Genres> genresList;

    public GenreTagAdapter(Context context, List<Genres> genresList) {
        this.context = context;
        this.genresList = genresList;
    }

    @NonNull
    @Override
    public GenreTagHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GenreTagHolder(LayoutInflater.from(context).inflate(R.layout.artist_genres_list,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull GenreTagHolder holder, int position) {
        holder.genreName.setText(genresList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return genresList.size();
    }
}
