package com.example.progetto;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class FragmentAudio extends Fragment {

    View view;
    TextView noVideoFoundMessage;
    AudioAdapter adapter;
    AudioHolder holder;
    private Handler hdlr = new Handler();
    private static int oTime =0, sTime =0, eTime =0, fTime = 5000, bTime = 5000;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_audio, container, false);

        ArtistProfile activity = (ArtistProfile) getActivity();
        Artist artist = activity.getCurrentArtist();

        noVideoFoundMessage = view.findViewById(R.id.error_message);

        if (artist.getAudios() != null) {
            noVideoFoundMessage.setVisibility(View.GONE);
            RecyclerView recyclerView = view.findViewById(R.id.audio_recycleview);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            adapter = new AudioAdapter(view.getContext(), artist.getAudios(), new AudioAdapter.OnAudioClickListener() {


                @Override
                public void onAudioClick(AudioHolder audioHolder) {

                    holder = audioHolder;

                    if(!holder.mediaPlayer.isPlaying()) {
                        holder.mediaPlayer.start();
                        holder.getStartButton().setImageResource(R.drawable.pauseaudio_button);



                        holder.songProg.setProgress(sTime);
                        hdlr.postDelayed(UpdateSongTime, 100);
                    }
                    else {
                        holder.mediaPlayer.pause();
                        holder.getStartButton().setImageResource(R.drawable.playaudio_button);
                    }
                }
            });
            recyclerView.setAdapter(adapter);


        }
        else {
            String message = artist.getNomeDarte() + " non ha ancora caricato nessun audio";
            noVideoFoundMessage.setText(message);
        }

        return view;
    }
    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            sTime = holder.mediaPlayer.getCurrentPosition();
            holder.getStartTime().setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(sTime),
                    TimeUnit.MILLISECONDS.toSeconds(sTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(sTime))) );
            holder.getSongProg().setProgress(sTime);
            hdlr.postDelayed(this, 100);
        }
    };

}
