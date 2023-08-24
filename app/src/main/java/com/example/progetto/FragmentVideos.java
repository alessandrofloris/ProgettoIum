package com.example.progetto;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telephony.PreciseDataConnectionState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;


public class FragmentVideos extends Fragment implements View.OnClickListener{

    View view;
    VideoView videoView;
    TextView noVideoFoundMessage;

    ImageView playButton;
    TextView opacityLayer;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_videos, container, false);
        ArtistProfile activity = (ArtistProfile) getActivity();
        Artist artist = activity.getCurrentArtist();

        noVideoFoundMessage = view.findViewById(R.id.error_message);

        if(artist.getVideos()!= null) {
            videoView = (VideoView) view.findViewById(R.id.video_view);
            noVideoFoundMessage.setVisibility(View.GONE);
            RecyclerView recyclerView = view.findViewById(R.id.video_recycleview);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setAdapter(new VideoAdapter(view.getContext(), artist.getVideos()));
        }
        else {
            String message = artist.getNomeDarte()+ " non ha ancora caricato nessun video";
            noVideoFoundMessage.setText(message);
            noVideoFoundMessage.setVisibility(View.VISIBLE);

        }
        /*
        if(artist.getVideos()!=null) {
            Uri videoURI = Uri.parse(artist.getVideos().get(0).getvPath());
            videoView.setVideoURI(videoURI);

            playButton = view.findViewById(R.id.play_button);
            playButton.setImageResource(R.drawable.ic_baseline_play_arrow_24);
            opacityLayer = view.findViewById(R.id.opacity);


            videoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (videoView.isPlaying()) {
                        videoView.pause();
                        playButton.setVisibility(View.VISIBLE);
                        opacityLayer.setVisibility(View.VISIBLE);
                    } else {
                        videoView.start();
                        playButton.setVisibility(View.GONE);
                        opacityLayer.setVisibility(View.GONE);
                    }
                }
            });
        }
*/
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}