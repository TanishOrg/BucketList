package com.example.bucketlist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bucketlist.R;
import com.example.bucketlist.model.WallpaperModel;

import java.util.List;

public class RecyclerAdapterWallpaper extends RecyclerView.Adapter<WallpaperViewHolder> {

    private Context context;
    private List<WallpaperModel> wallpaperModelList;

    public RecyclerAdapterWallpaper(Context context, List<WallpaperModel> wallpaperModelList) {
        this.context = context;
        this.wallpaperModelList = wallpaperModelList;
    }

    @NonNull
    @Override
    public WallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wallpaper_item,parent,false);
        return new WallpaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperViewHolder holder, int position) {

        Glide.with(context).load(wallpaperModelList.get(position).getRawUrl()).into(holder.wallpaper);

    }

    @Override
    public int getItemCount() {
        return wallpaperModelList.size();
    }
}

class WallpaperViewHolder extends RecyclerView.ViewHolder{

    CardView wallpaperCard;
    ImageView wallpaper;
    public WallpaperViewHolder(@NonNull View itemView) {
        super(itemView);
        wallpaperCard = itemView.findViewById(R.id.wallpaperCard);
        wallpaper = itemView.findViewById(R.id.wallpaper);
    }
}