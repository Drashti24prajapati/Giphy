package com.giphy.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.giphy.R;

/**
 * Created by ND on 2018-01-19.
 */

public class ViewHolderTrendingGifs extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imgGif, imgFavUnfav;

    ItemOnclickListener itemOnclickListener;

    public ViewHolderTrendingGifs(View itemView) {
        super(itemView);

        imgGif = (ImageView) itemView.findViewById(R.id.imgGifs);
        imgFavUnfav = (ImageView) itemView.findViewById(R.id.imgFavUnfav);
        itemView.setOnClickListener(this);
    }

    public void setItemOnclickListener(ItemOnclickListener ic) {
        this.itemOnclickListener = ic;

    }

    @Override
    public void onClick(View v) {
        this.itemOnclickListener.onItemClick(v,getLayoutPosition());

    }
}
