package com.example.progetto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChipAdapter extends RecyclerView.Adapter<ChipAdapter.ViewHolder>{

    public interface OnChipClickListener {
        void onChipClick(String item);
    }

    private List<String> items;
    private final OnChipClickListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.chip_text);
        }

        public void bind(final String chip, final OnChipClickListener listener) {
            textView.setText(chip);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onChipClick(chip);
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public ChipAdapter(List<String> items, OnChipClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_chip_selector, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChipAdapter.ViewHolder holder, int position) {
        String item = this.items.get(position);
//        holder.getTextView().setText(item);
        holder.bind(item, listener);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }


}
