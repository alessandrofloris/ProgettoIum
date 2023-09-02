package com.example.progetto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter  extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {
    ImageView artistPic;
    TextView artistName;
    LinearLayout artistLayout;
    public static final String ARTIST_EXTRA ="com.example.progetto.Artist";

    private Context context;
    List<Artist> artists;

    public ChatAdapter(Context context, List<Artist> artists) {
        this.context = context;
        this.artists = artists;
    }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_row,parent,false);
        return new ChatHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ChatHolder holder, final int pos) {
        holder.getArtistName().setText(artists.get(pos).getNomeDarte());
        holder.getArtistPic().setImageResource(artists.get(pos).getImgID());
        holder.artistID = artists.get(pos).getIdArtist();
        holder.getArtistLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PrivateChat.class);
                intent.putExtra(ARTIST_EXTRA, ArtistRepository.getInstance().artistList.get(holder.artistID));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return artists.size();
    }


    public class ChatHolder extends RecyclerView.ViewHolder {
        Integer artistID;
        ChatAdapter adapter;

        public ChatHolder(@NonNull View itemView) {
            super(itemView);
            artistPic = itemView.findViewById(R.id.artist_image);
            artistName = itemView.findViewById(R.id.artist_name);
            artistLayout = itemView.findViewById(R.id.artist_layout);
        }
        public ChatHolder linkAdapter(ChatAdapter adapter) {
            this.adapter = adapter;
            return this;
        }

        public LinearLayout getArtistLayout() {return artistLayout;}

        public ImageView getArtistPic() {
            return artistPic;
        }

        public TextView getArtistName() {
            return artistName;
        }

        public Integer getArtistID() {
            return artistID;
        }

    }

}
