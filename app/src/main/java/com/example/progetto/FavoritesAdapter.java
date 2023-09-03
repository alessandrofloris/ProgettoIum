package com.example.progetto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class FavoritesAdapter  extends RecyclerView.Adapter<FavoritesAdapter.FavoritesHolder> {
    ImageView chatButton, removeButton, artistPic;
    TextView artistName;
    CardView artistCard;

    public static final String ARTIST_EXTRA ="com.example.progetto.Artist";


    public interface OnFavoriteClickListener {
        void onFavoriteClick(FavoritesHolder holder, int position, View view);
    }

    private final OnFavoriteClickListener listener;

    private Context context;
    List<Artist> artists;

    public FavoritesAdapter(Context context, List<Artist> artists, OnFavoriteClickListener listener) {
        this.context = context;
        this.artists = artists;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FavoritesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_row,parent,false);
        return new FavoritesHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.FavoritesHolder holder, final int pos) {
        holder.getArtistName().setText(artists.get(pos).getNomeDarte());
        holder.getArtistPic().setImageResource(artists.get(pos).getImgID());
        holder.artistID = artists.get(pos).getIdArtist();

        holder.getChatButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PrivateChat.class);
                intent.putExtra(ARTIST_EXTRA, ArtistRepository.getInstance().artistList.get(holder.artistID));
                context.startActivity(intent);
            }
        });

        holder.getRemoveButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!= null) {
                    int position = holder.getAdapterPosition();

                    if(position != RecyclerView.NO_POSITION){
                        listener.onFavoriteClick(holder, position, view);
                    }
                }
            }
        });

        holder.getArtistCard().setOnClickListener(new View.OnClickListener() {
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


    public class FavoritesHolder extends RecyclerView.ViewHolder {
        Integer artistID;
        FavoritesAdapter adapter;

        public FavoritesHolder(@NonNull View itemView) {
            super(itemView);
            chatButton =itemView.findViewById(R.id.chatButton);
            removeButton = itemView.findViewById(R.id.removeButton);
            artistPic = itemView.findViewById(R.id.artist_image);
            artistName = itemView.findViewById(R.id.artist_name);
            artistCard = itemView.findViewById(R.id.artist_row);
        }
        public FavoritesHolder linkAdapter(FavoritesAdapter adapter) {
            this.adapter = adapter;
            return this;
        }

        public ImageView getArtistPic() {
            return artistPic;
        }

        public TextView getArtistName() {
            return artistName;
        }

        public ImageView getChatButton() {
            return chatButton;
        }

        public CardView getArtistCard() {return  artistCard;}

        public Integer getArtistID() {
            return artistID;
        }

        public ImageView getRemoveButton() {
            return removeButton;
        }
    }

}
