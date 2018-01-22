package com.giphy.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.giphy.Model.ModelTrending;
import com.giphy.R;

import java.util.ArrayList;

/**
 * Created by ND on 2018-01-19.
 */

public class AdapterFavGifs extends RecyclerView.Adapter<ViewHolderFavGifs> {

    Context context;
    ArrayList<ModelTrending> arrayModelTrending;
    ModelTrending model;

    public AdapterFavGifs(Context context, ArrayList<ModelTrending> arrayModelTrending) {
        this.context = context;
        this.arrayModelTrending = arrayModelTrending;
    }

    @Override
    public ViewHolderFavGifs onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fav_custom_fragment, parent, false);

        return new ViewHolderFavGifs(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolderFavGifs holder,int position) {

      //  tblTrendingGifs = new TblTrendingGifs(context);
        model = arrayModelTrending.get(position);
        final ImageView imageView = holder.imgGif;

        Glide.with(context)
                .load(model.getTrendingGifUrl())
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.nogif)
                .into(imageView);

            }
    @Override
    public int getItemCount() {
        return arrayModelTrending.size();
    }

}
