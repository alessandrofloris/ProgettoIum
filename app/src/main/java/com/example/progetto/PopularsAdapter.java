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

public class PopularsAdapter extends RecyclerView.Adapter<PopularsAdapter.MyHolderP> {

        public interface OnPopularsClickListener {
            void onPopularsClick(MyHolderP artist);
        }

        private final PopularsAdapter.OnPopularsClickListener listener;
        ArrayList<Artist> artists;
        Context context;


        public PopularsAdapter(Context context, ArrayList<Artist> artists, PopularsAdapter.OnPopularsClickListener listener) {
            this.context = context;
            this.artists =artists;
            this.listener = listener;
        }


        @NonNull
        @Override
        public MyHolderP onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.single_popular_artist_card, parent, false);
            return new MyHolderP(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolderP holderP, int position) {
            holderP.artistName.setText(artists.get(position).getNomeDarte());
            holderP.artistPhoto.setImageResource(artists.get(position).getImgID());
            holderP.artist = ArtistService.getInstance().getById(position);
            holderP.bindP(holderP, listener);
        }

        @Override
        public int getItemCount() {
            return artists.size();
        }

        public static class MyHolderP extends RecyclerView.ViewHolder {
            TextView artistName;
            ImageView artistPhoto;
            CardView artistCard;
            Artist artist = new Artist();

            public MyHolderP(@NonNull View itemView) {
                super(itemView);
                artistCard = itemView.findViewById(R.id.popularartist_card);
                artistName = itemView.findViewById(R.id.artist_name);
                artistPhoto = itemView.findViewById(R.id.artist_photo);
            }

            public void bindP(MyHolderP holderP, OnPopularsClickListener listener) {
                holderP.artistCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onPopularsClick(holderP);

                    }
                });
            }
        }
}

