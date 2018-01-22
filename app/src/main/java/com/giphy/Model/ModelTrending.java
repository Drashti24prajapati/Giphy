package com.giphy.Model;

/**
 * Created by ND on 2018-01-19.
 */

public class ModelTrending{

    int trendingId,trendingMasterID,trendingFavStatus;
    String trendingGifUrl, trendingCat;



    public int getTrendingId() {
        return trendingId;
    }

    public void setTrendingId(int trendingId) {
        this.trendingId = trendingId;
    }

    public int getTrendingMasterID() {
        return trendingMasterID;
    }

    public void setTrendingMasterID(int trendingMasterID) {
        this.trendingMasterID = trendingMasterID;
    }

    public int getTrendingFavStatus() {
        return trendingFavStatus;
    }

    public void setTrendingFavStatus(int trendingFavStatus) {
        this.trendingFavStatus = trendingFavStatus;
    }

    public String getTrendingGifUrl() {
        return trendingGifUrl;
    }

    public void setTrendingGifUrl(String trendingGifUrl) {
        this.trendingGifUrl = trendingGifUrl;
    }

    public String getTrendingCat() {
        return trendingCat;
    }

    public void setTrendingCat(String trendingCat) {
        this.trendingCat = trendingCat;
    }
}
