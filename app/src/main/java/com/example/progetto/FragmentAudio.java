package com.example.progetto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentAudio extends Fragment {

    View view;
    TextView provaView;
    TextView noVideoFoundMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_audio, container, false);

        ArtistProfile activity = (ArtistProfile) getActivity();
        Artist artist = activity.getCurrentArtist();

        noVideoFoundMessage = view.findViewById(R.id.error_message);

        if (artist.getAudios() != null) {
            provaView = (TextView) view.findViewById(R.id.audioprova);
            provaView.setText("immaginati un audio");
            noVideoFoundMessage.setVisibility(View.GONE);

        }
        else {
            String message = artist.getNomeDarte() + " non ha ancora caricato nessun audio";
            noVideoFoundMessage.setText(message);
            noVideoFoundMessage.setVisibility(View.VISIBLE);
        }


        return view;
    }
}
