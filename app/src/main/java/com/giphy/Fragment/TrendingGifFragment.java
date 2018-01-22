package com.giphy.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.giphy.Database.GifsDB;
import com.giphy.Database.TblTrendingGifs;
import com.giphy.Model.ModelTrending;
import com.giphy.R;
import com.giphy.Adapter.AdapterTrendingGifs;

import java.util.ArrayList;

/**
 * Created by ND on 2018-01-19.
 */

public class TrendingGifFragment extends Fragment implements SearchView.OnQueryTextListener {
    TblTrendingGifs tblTrendingGifs;
    RecyclerView rv;
    SearchView searchView;
    ArrayList<ModelTrending> newArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.trending_fragment, null);


        tblTrendingGifs = new TblTrendingGifs(this.getActivity(), GifsDB.DBname, null, GifsDB.db_versionname);
//searchview
        searchView = (SearchView) v.findViewById(R.id.gifSearchView);
        searchView.setOnQueryTextListener(this);
        //Recyclerview
        rv = (RecyclerView) v.findViewById(R.id.trandingRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv.setAdapter(new AdapterTrendingGifs(this.getActivity(), tblTrendingGifs.getTrendingGifs()));
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        tblTrendingGifs.close();

    }

    //set title for fragment
    @Override
    public String toString() {
        return "Trending Gifs";
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newArrayList=new ArrayList<>();
        newText = newText.toLowerCase();
                newArrayList= tblTrendingGifs.getFilterGIF(newText);
        rv.setAdapter(new AdapterTrendingGifs(this.getActivity(), newArrayList));

//        new AdapterTrendingGifs(this.getActivity(),);
        return true;
    }
}


