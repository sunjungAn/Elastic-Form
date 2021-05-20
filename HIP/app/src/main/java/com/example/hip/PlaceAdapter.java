package com.example.hip;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>
        implements OnPlaceItemClickListener {
    ArrayList<Place> items = new ArrayList<Place>();
    OnPlaceItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.place_item, viewGroup, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Place item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Place item) {
        items.add(item);
    }

    public void setItems(ArrayList<Place> items) {
        this.items = items;
    }

    public Place getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Place item) {
        items.set(position, item);
    }

    public void setOnItemClickListener(OnPlaceItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView, final OnPlaceItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.place_name);
            textView2 = itemView.findViewById(R.id.place_content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Place item) {
            textView.setText(item.getName());
            textView2.setText(item.getContents());
        }
    }
}