package com.example.progetto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.MyHolder> {

    public interface OnArtistClickListener {
        void onArtistClick(MyHolder artist);
    }

    private final ArtistListAdapter.OnArtistClickListener listener;
    ArrayList<Artist> artists;
    Context context;


    public ArtistListAdapter(Context context, ArrayList<Artist> artists, OnArtistClickListener listener) {
        this.context = context;
        this.artists =artists;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_artist_card, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.artistName.setText(artists.get(position).getNomeDarte());
        holder.artistPhoto.setImageResource(artists.get(position).getImgID());
        holder.artist = ArtistService.getInstance().getById(position);
        holder.bind(holder, listener);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView artistName;
        ImageView artistPhoto;
        CardView artistCard;
        Artist artist = new Artist();

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            artistCard = itemView.findViewById(R.id.artist_card);
            artistName = itemView.findViewById(R.id.artist_name);
            artistPhoto = itemView.findViewById(R.id.artist_photo);
        }

        public void bind(MyHolder holder, OnArtistClickListener listener) {
            holder.artistCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onArtistClick(holder);

                }
            });
        }

    }
}
