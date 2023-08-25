package com.example.progetto;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.concurrent.TimeUnit;

public class AudioHolder extends RecyclerView.ViewHolder {

    ImageView startButton;
    TextView startTime, songTime, titleSong;
    Integer idAudio;
    MediaPlayer mediaPlayer;
    SeekBar songProg;

    public AudioHolder(@NonNull View itemView) {
        super(itemView);
        startButton = itemView.findViewById(R.id.btnPlay);
        startTime = itemView.findViewById(R.id.txtStartTime);
        songTime = itemView.findViewById(R.id.txtSongTime);
        titleSong = itemView.findViewById(R.id.audio_title);
        songProg = itemView.findViewById(R.id.sBar);
    }

    public void bind(final AudioHolder audioHolder, final Integer idAudio, final AudioAdapter.OnAudioClickListener listener) {

        audioHolder.getStartButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onAudioClick(audioHolder);

            }
        });
    }



    public Integer getIdAudio() {
        return idAudio;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public SeekBar getSongProg() {
        return songProg;
    }

    public ImageView getStartButton() {
        return startButton;
    }

    public TextView getStartTime() {
        return startTime;
    }

    public TextView getSongTime() {
        return songTime;
    }

    public TextView getTitleSong() {
        return titleSong;
    }
}
