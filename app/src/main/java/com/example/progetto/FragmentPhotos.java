package com.example.progetto;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;


public class FragmentPhotos extends Fragment implements View.OnClickListener{

    View view;
    ImageView imageView;
    TextView noVideoFoundMessage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_photos, container, false);
        ArtistProfile activity = (ArtistProfile) getActivity();
        Artist artist = activity.getCurrentArtist();

       noVideoFoundMessage = view.findViewById(R.id.error_message_photos);

        if (artist.getPhotos() != null) {
            imageView = (ImageView) view.findViewById(R.id.photo_view);
            noVideoFoundMessage.setVisibility(View.GONE);
            RecyclerView recyclerView = view.findViewById(R.id.photo_recycleview);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setAdapter(new PhotoAdapter(view.getContext(), artist.getPhotos(), new PhotoAdapter.OnPhotoClickListener() {
                @Override
                public void onPhotoClick(PhotoHolder photoHolder) {

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