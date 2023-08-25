package com.example.progetto;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PhotoHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView date, likes;


    public PhotoHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.photo_view);
        date = itemView.findViewById(R.id.upload_photo_date);
        likes =itemView.findViewById((R.id.photo_likes_number));
    }

    public ImageView getPhotoView() { return imageView;}
    public TextView getPhotoDate() {return date;}
    public TextView getPhotoLikes() {return likes;}
}
