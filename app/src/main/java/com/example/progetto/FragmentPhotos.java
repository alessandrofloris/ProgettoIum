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


public class FragmentPhotos extends Fragment {

    View view;
    ImageView imageView;
    TextView noVideoFoundMessage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_photos, container, false);
        ArtistProfile activity = (ArtistProfile) getActivity();
        Artist artist = activity.getCurrentArtist();

        noVideoFoundMessage = view.findViewById(R.id.error_message);

        if (artist.getPhotos() != null) {
            imageView = (ImageView) view.findViewById(R.id.photo_artist);
            imageView.setImageResource(artist.getPhotos().get(0).getIdPhoto());
            noVideoFoundMessage.setVisibility(View.GONE);

        }
        else {
            String message = artist.getNomeDarte() + " non ha ancora caricato nessuna foto";
            noVideoFoundMessage.setText(message);
            noVideoFoundMessage.setVisibility(View.VISIBLE);
        }


            return view;
    }

}