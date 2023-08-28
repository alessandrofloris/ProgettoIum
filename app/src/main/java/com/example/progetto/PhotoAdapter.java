package com.example.progetto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {


    Context context;
    List<Photo> photos;

    public PhotoAdapter(Context context, List<Photo> photos) {
        this.context = context;
        this.photos = photos;
    }


    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhotoHolder(LayoutInflater.from(context).inflate(R.layout.photo_list_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
        holder.getPhotoView().setImageResource(photos.get(position).getIdPhoto());
        holder.getPhotoDate().setText(photos.get(position).getUploadDate());
        holder.getPhotoLikes().setText(String.valueOf(photos.get(position).getnLikes()));
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}
