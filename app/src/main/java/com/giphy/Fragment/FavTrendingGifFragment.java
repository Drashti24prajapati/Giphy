package com.giphy.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.giphy.Database.GifsDB;
import com.giphy.Database.TblTrendingGifs;
import com.giphy.R;
import com.giphy.Adapter.AdapterFavGifs;

/**
 * Created by ND on 2018-01-19.
 */

public class FavTrendingGifFragment extends Fragment{
    TblTrendingGifs tblTrendingGifs;
    RecyclerView rv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fav_fragment, null);
        tblTrendingGifs = new TblTrendingGifs(this.getActivity(), GifsDB.DBname, null, GifsDB.db_versionname);
        //Recyclerview
        rv = (RecyclerView) v.findViewById(R.id.favRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv.setAdapter(new AdapterFavGifs(this.getActivity(), tblTrendingGifs.getFavTrendingGifs()));
        return v;
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    //set title for fragment
    @Override
    public String toString() {
        return "Favourite Gifs";
    }
}