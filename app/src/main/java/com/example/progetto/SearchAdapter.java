package com.example.progetto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends BaseAdapter {

    private Context context;
    List<Artist> artists;


    public SearchAdapter(Context context, List<Artist> artists) {
        this.context = context;
        this.artists = artists;
    }

    @Override
    public int getCount() {
        return artists.size();
    }

    @Override
    public Object getItem(int i) {
        return artists.get(i);
    }

    @Override
    public long getItemId(int i) {
        // todo sostituire getImageID con getId
        Artist a = (Artist) this.getItem(i);
        return a.getImgID() == 0 ? a.getImgID() : 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.search_result_list, viewGroup, false);
        }

        Artist currentArtist = (Artist) getItem(i);

        ImageView artist_image_view = view.findViewById(R.id.artist_image);
        TextView nickname_view = view.findViewById(R.id.text_view_nickname);

        // todo aggiungere controllo quando l'artista non ha l'immagine
        artist_image_view.setImageResource(currentArtist.getImgID());
        nickname_view.setText(currentArtist.getNomeDarte());

        return view;
    }
}
