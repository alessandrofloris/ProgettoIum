package com.example.progetto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {

    private Context context;
    List<Artist> artists;

    ImageView  artistPic;
    TextView artistName;
    LinearLayout artistLayout;

    public static final String ARTIST_EXTRA ="com.example.progetto.Artist";

    public SearchAdapter(Context context, List<Artist> artists) {
        this.context = context;
        this.artists = artists;
    }

    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_row,parent,false);
        return new SearchAdapter.SearchHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchHolder holder, int pos) {
        holder.getArtistName().setText(artists.get(pos).getNomeDarte());
        holder.getArtistPic().setImageResource(artists.get(pos).getImgID());
        holder.artistID = artists.get(pos).getIdArtist();
        holder.getArtistLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ArtistProfile.class);
                intent.putExtra(ARTIST_EXTRA, ArtistRepository.getInstance().artistList.get(holder.artistID));
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return artists.size();
    }




    public class SearchHolder extends RecyclerView.ViewHolder {
        Integer artistID;
        SearchAdapter adapter;

        public SearchHolder(@NonNull View itemView) {
            super(itemView);
            artistPic = itemView.findViewById(R.id.artist_image);
            artistName = itemView.findViewById(R.id.artist_name);
            artistLayout = itemView.findViewById(R.id.artist_layout);
        }
        public SearchAdapter.SearchHolder linkAdapter(SearchAdapter adapter) {
            this.adapter = adapter;
            return this;
        }

        public ImageView getArtistPic() {
            return artistPic;
        }

        public TextView getArtistName() {
            return artistName;
        }

        public LinearLayout getArtistLayout() {return  artistLayout;}

        public Integer getArtistID() {
            return artistID;
        }


    }


}
