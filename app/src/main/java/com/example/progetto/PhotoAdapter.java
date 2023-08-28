package com.example.progetto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {

    public interface OnPhotoClickListener {
        void onPhotoClick(PhotoHolder photoHolder);
    }

    public OnPhotoClickListener listener;

    Context context;
    List<Photo> photos;

    public PhotoAdapter(Context context, List<Photo> photos, OnPhotoClickListener listener) {
        this.context = context;
        this.photos = photos;
        this.listener = listener;
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

        holder.getHeartButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!holder.isLiked) {
                    holder.isLiked = true;
                    holder.getHeartButton().setImageResource(R.drawable.like_heart);
                    Integer newNumber =photos.get(holder.getAdapterPosition()).getnLikes()+1;
                    holder.getPhotoLikes().setText(String.valueOf(newNumber));

                }
                else {
                    holder.isLiked = false;
                    holder.getHeartButton().setImageResource(R.drawable.heart_nolike);
                    Integer newNumber =photos.get(holder.getAdapterPosition()).getnLikes();
                    holder.getPhotoLikes().setText(String.valueOf(newNumber));
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}
