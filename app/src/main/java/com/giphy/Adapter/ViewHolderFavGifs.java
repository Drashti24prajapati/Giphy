package com.giphy.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.giphy.R;

/**
 * Created by ND on 2018-01-19.
 */

public class ViewHolderFavGifs extends RecyclerView.ViewHolder{
    ImageView imgGif, imgDownload;

    ItemOnclickListener itemOnclickListener;

    public ViewHolderFavGifs(View itemView) {
        super(itemView);

        imgGif = (ImageView) itemView.findViewById(R.id.imgGifs);
    }
}
