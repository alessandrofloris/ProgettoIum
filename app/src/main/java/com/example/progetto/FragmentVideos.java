package com.example.progetto;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;


public class FragmentVideos extends Fragment implements View.OnClickListener{

    View view;
    TextView noVideoFoundMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_videos, container, false);
        ArtistProfile activity = (ArtistProfile) getActivity();
        Artist artist = activity.getCurrentArtist();

        noVideoFoundMessage = view.findViewById(R.id.error_message_video);

        if (artist.getVideos() != null) {
            noVideoFoundMessage.setVisibility(View.GONE);
            RecyclerView recyclerView = view.findViewById(R.id.video_recycleview);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setAdapter(new VideoAdapter(view.getContext(), artist.getVideos(), new VideoAdapter.OnVideoClickListener() {
                @Override
                public void onVideoClick(VideoHolder videoHolder) {

                }
            }));

        } else {
            String message = artist.getNomeDarte() + " non ha ancora caricato nessun video";
            noVideoFoundMessage.setText(message);
            noVideoFoundMessage.setVisibility(View.VISIBLE);

        }

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}