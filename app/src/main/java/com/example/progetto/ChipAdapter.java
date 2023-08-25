package com.example.progetto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.List;

public class ChipAdapter extends RecyclerView.Adapter<ChipAdapter.ViewHolder>{

    public interface OnChipClickListener {
        void onChipClick(Chip item_id);
    }

    private List<String> items;
    private List<FiltersInterface> items_id;
    private final OnChipClickListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final Chip chipView;

        public ViewHolder(View view) {
            super(view);

            chipView = (Chip) view.findViewById(R.id.chip);
        }

        public void bind(final String chip, final FiltersInterface item_id, final OnChipClickListener listener) {
            chipView.setText(chip);
            chipView.setTag(item_id);
            chipView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onChipClick(chipView);
                }
            });
        }

        public Chip getChipView() {
            return chipView;
        }
    }

    public ChipAdapter(List<String> items, List<FiltersInterface> items_id, OnChipClickListener listener) {
        this.items = items;
        this.items_id = items_id;
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
        FiltersInterface item_id = this.items_id.get(position);
        holder.bind(item, item_id, listener);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
}
