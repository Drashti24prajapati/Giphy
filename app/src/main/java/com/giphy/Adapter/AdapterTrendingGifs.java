package com.giphy.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.giphy.Controller.DownloadGif;
import com.giphy.Database.GifsDB;
import com.giphy.Database.TblTrendingGifs;
import com.giphy.Model.ModelTrending;
import com.giphy.R;

import java.util.ArrayList;

/**
 * Created by ND on 2018-01-19.
 */

public class AdapterTrendingGifs extends RecyclerView.Adapter<ViewHolderTrendingGifs> {

    Context context;
    public ArrayList<ModelTrending> arrayModelTrending;
    TblTrendingGifs tblTrendingGifs;


    public AdapterTrendingGifs(Context context, ArrayList<ModelTrending> arrayModelTrending) {
        this.context = context;
        this.arrayModelTrending = arrayModelTrending;
    }

    @Override
    public ViewHolderTrendingGifs onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trending_custom_fragment, parent, false);
        tblTrendingGifs = new TblTrendingGifs(context, GifsDB.DBname, null, GifsDB.db_versionname);
        return new ViewHolderTrendingGifs(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolderTrendingGifs holder, final int position) {
        final ModelTrending model = arrayModelTrending.get(position);
        final ImageView imageView = holder.imgGif;

        Glide.with(context)
                .load(model.getTrendingGifUrl())
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.nogif)
                .into(imageView);

        if (tblTrendingGifs.Isstatus(model.getTrendingId()) == 0) {
            //setunfav =0
            holder.imgFavUnfav.setImageResource(context.getResources().getIdentifier("unfavourite", "drawable", context.getPackageName()));
        } else {
            //setfav= 1
            holder.imgFavUnfav.setImageResource(context.getResources().getIdentifier("fav", "drawable", context.getPackageName()));
        }

        holder.setItemOnclickListener(new ItemOnclickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                int status = tblTrendingGifs.IsFav(model.getTrendingId());
                if (status == 0) {
                    //make fav
                    holder.imgFavUnfav.setImageResource(context.getResources().getIdentifier("unfavourite", "drawable", context.getPackageName()));
                    notifyDataSetChanged();
                } else {
                    holder.imgFavUnfav.setImageResource(context.getResources().getIdentifier("fav", "drawable", context.getPackageName()));
                    new DownloadGif(context).execute(model.getTrendingGifUrl());
                    notifyDataSetChanged();
                    // make unfav
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayModelTrending.size();
    }

}
