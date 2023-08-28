package com.example.progetto;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AudioAdapter extends RecyclerView.Adapter<AudioHolder> {

    public interface OnAudioClickListener {
        void onAudioClick(AudioHolder audioHolder);
    }

    private final OnAudioClickListener listener;

    Context context;
    List<Audio> audios;

    private static int oTime =0, sTime =0, eTime =0, fTime = 5000, bTime = 5000;


    public AudioAdapter( Context context, List<Audio> audios, OnAudioClickListener listener) {
        this.context = context;
        this.audios = audios;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AudioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AudioHolder(LayoutInflater.from(context).inflate(R.layout.audio_list_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AudioHolder holder, int position) {

        holder.idAudio = audios.get(position).getIdAudio();
        holder.getTitleSong().setText(audios.get(position).getSongTitle());
        holder.mediaPlayer = MediaPlayer.create(context, audios.get(position).getIdAudio());
        holder.getSongProg().setClickable(false);
        eTime = holder.mediaPlayer.getDuration();
        sTime = holder.mediaPlayer.getCurrentPosition();
        if(oTime == 0){
            holder.songProg.setMax(eTime);
            oTime =1;
        }
        holder.getSongTime().setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(eTime),
                TimeUnit.MILLISECONDS.toSeconds(eTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS. toMinutes(eTime))) );

        holder.getStartTime().setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(sTime),
                TimeUnit.MILLISECONDS.toSeconds(sTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS. toMinutes(sTime))) );

        oTime =0;
        holder.bind(holder, position, listener);
    }

    @Override
    public int getItemCount() {
        return audios.size();
    }
}
