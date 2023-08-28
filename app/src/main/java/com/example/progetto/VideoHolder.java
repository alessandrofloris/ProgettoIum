package com.example.progetto;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoHolder extends RecyclerView.ViewHolder {

    VideoView videoView;
    TextView date, likes;


    public VideoHolder(@NonNull View itemView) {
        super(itemView);
        videoView = itemView.findViewById(R.id.video_view);
        date = itemView.findViewById(R.id.upload_video_date);
        likes = itemView.findViewById(R.id.video_likes_number);
    }

    public VideoView getVideoView(){
        return videoView;
    }
    public TextView getVideoDate(){
        return date;
    }
    public TextView getVideoLikes() {
        return likes;
    }
}
