package com.example.progetto;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GenreTagHolder extends RecyclerView.ViewHolder {
    TextView genreName;

    public GenreTagHolder(@NonNull View itemView) {
        super(itemView);
        genreName = itemView.findViewById(R.id.genere);
    }


    public TextView getGenreName() {
        return genreName;
    }
}
