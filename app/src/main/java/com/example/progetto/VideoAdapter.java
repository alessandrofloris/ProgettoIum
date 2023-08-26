package com.example.progetto;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoHolder> {

    Context context;
    List<Video> videos;

    public VideoAdapter(Context context, List<Video> videos) {
        this.context = context;
        this.videos = videos;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoHolder(LayoutInflater.from(context).inflate(R.layout.video_list_view, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        Uri videoURI = Uri.parse(videos.get(position).getvPath());
        holder.getVideoView().setVideoURI(videoURI);
        holder.getVideoLikes().setText(String.valueOf(videos.get(position).getnLikes()));
        holder.getVideoDate().setText(videos.get(position).getUploadDate());
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

}

