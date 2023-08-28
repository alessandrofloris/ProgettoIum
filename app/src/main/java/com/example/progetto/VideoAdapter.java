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

    public interface OnVideoClickListener {
        void onVideoClick(VideoHolder videoHolder);
    }

    public final OnVideoClickListener listener;

    Context context;
    List<Video> videos;

    public VideoAdapter(Context context, List<Video> videos, OnVideoClickListener listener) {
        this.context = context;
        this.videos = videos;
        this.listener = listener;
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

        holder.getPlayButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!holder.getVideoView().isPlaying()) {
                    holder.getVideoView().start();
                    holder.getPlayButton().setVisibility(View.GONE);
                }
            }
        });

        holder.getVideoView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.getVideoView().isPlaying()) {
                    holder.getVideoView().pause();
                    holder.getPlayButton().setVisibility(View.VISIBLE);
                }
            }
        });

        holder.getHeartButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!holder.isLiked) {
                    holder.isLiked = true;
                    holder.getHeartButton().setImageResource(R.drawable.like_heart);
                    Integer newNumber =videos.get(holder.getAdapterPosition()).getnLikes()+1;
                    holder.getVideoLikes().setText(String.valueOf(newNumber));

                }
                else {
                    holder.isLiked = false;
                    holder.getHeartButton().setImageResource(R.drawable.heart_nolike);
                    Integer newNumber =videos.get(holder.getAdapterPosition()).getnLikes();
                    holder.getVideoLikes().setText(String.valueOf(newNumber));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

}

