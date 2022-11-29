package com.example.appfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.R;
import com.example.appfood.model.BestForYou;

import java.util.List;

public class BestForYouAdapter extends RecyclerView.Adapter<BestForYouAdapter.BestForYouViewHolder> {
    Context context;
    List<BestForYou> bestForYouList;

    public BestForYouAdapter(Context context, List<BestForYou> bestForYouList) {
        this.context = context;
        this.bestForYouList = bestForYouList;
    }

    @NonNull
    @Override
    public BestForYouViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BestForYouViewHolder(LayoutInflater.from(context).inflate(R.layout.best_for_you_row_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BestForYouViewHolder holder, int position) {
        holder.itemImage.setImageResource(bestForYouList.get(position).getImageUrl());
        holder.itemName.setText(bestForYouList.get(position).getName());
        holder.itemTime.setText(bestForYouList.get(position).getTime());
        holder.itemText.setText(bestForYouList.get(position).getText());
        holder.itemRating.setRating(bestForYouList.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return bestForYouList.size();
    }


    public static final class BestForYouViewHolder extends RecyclerView.ViewHolder{
        ImageView  itemImage,itemHorloge;
        TextView itemName,itemText,itemTime;
        Button itemButton;
        RatingBar itemRating;

        public BestForYouViewHolder(@NonNull View itemView) {

            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemImage = itemView.findViewById(R.id.item_horloge);
            itemText= itemView.findViewById(R.id.item_name);
            itemText= itemView.findViewById(R.id.item_button);
            itemRating= itemView.findViewById(R.id.item_rating);
        }

    }


}
