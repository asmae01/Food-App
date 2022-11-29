package com.example.appfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.R;
import com.example.appfood.RecycleViewOnItemClick;
import com.example.appfood.model.Recettes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecettesAdapter extends RecyclerView.Adapter<RecettesAdapter.MyviewHoder> {

    Context context;
//    List<Users> list;

    List<Recettes> recettes;
    LayoutInflater inflater;
    private ArrayList<Recettes> arraylist;
    TextView name;
    TextView tvType;
    ImageView myImage;
    ToggleButton toggleButton;

    private RecycleViewOnItemClick recycleViewOnItemClick;

    public RecettesAdapter(Context context, List<Recettes> recettes, RecycleViewOnItemClick recycleViewOnItemClick) {
        this.context = context;
        this.recettes = recettes;
        this.recycleViewOnItemClick = recycleViewOnItemClick;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<Recettes>();
        this.arraylist.addAll(recettes);
    }

    @NonNull
    @Override
    public MyviewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recettes,parent,false);

        return new MyviewHoder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull MyviewHoder holder, int position) {

//        holder.profileImage.setImageResource(list.get(position).getImageProfile());
//        holder.username.setText(list.get(position).getUsername());
//        holder.userDesc.setText(list.get(position).getUserDesc());

        holder.recetteImage.setImageResource(recettes.get(position).getImage());
        holder.type.setText(recettes.get(position).getType());
        holder.name.setText(recettes.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return recettes.size();
    }

    public class MyviewHoder extends RecyclerView.ViewHolder {

        //        CircleImageView profileImage;
//        TextView username,userDesc;
        CircleImageView recetteImage;
        TextView type,name;

        public MyviewHoder(@NonNull View itemView) {
            super(itemView);
//            profileImage=itemView.findViewById(R.id.profileImage);
//            userDesc=itemView.findViewById(R.id.textDesc);
//            username=itemView.findViewById(R.id.username);

            recetteImage=itemView.findViewById(R.id.profileImage);
            name=itemView.findViewById(R.id.nameRecettes);
            type=itemView.findViewById(R.id.type);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recycleViewOnItemClick.onItemClick(getAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    recycleViewOnItemClick.onLongItemClick(getAdapterPosition());
                    return false;
                }
            });


        }
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        recettes.clear();
        if (charText.length() == 0) {
            recettes.addAll(arraylist);
        } else {
            for (Recettes wp : arraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    recettes.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
