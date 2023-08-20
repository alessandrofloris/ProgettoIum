package com.example.progetto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

        TextView nickname_view = view.findViewById(R.id.text_view_nickname);
        TextView name_view = view.findViewById(R.id.text_view_item_name);
        TextView surname_view = view.findViewById(R.id.text_view_item_surname);

        nickname_view.setText(currentArtist.getNomeDarte());
        name_view.setText(currentArtist.getNome());
        surname_view.setText(currentArtist.getCognome());

        return view;
    }
}
