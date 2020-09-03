package com.example.androidshaper.movietrackbypaging;


import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class MovieDataSourceFactory extends DataSource.Factory {
    private MovieDataSource movieDataSource;
    private OurRetrofitClient ourRetrofitClient;
    private Application application;
    private MutableLiveData<MovieDataSource> movieDataSourceMutableLiveData;

    public MovieDataSourceFactory(OurRetrofitClient ourRetrofitClient, Application application) {
        this.ourRetrofitClient = ourRetrofitClient;
        this.application = application;
        movieDataSourceMutableLiveData=new MutableLiveData<>();
    }

    @Override
    public DataSource create() {
        movieDataSource=new MovieDataSource(ourRetrofitClient);
        movieDataSourceMutableLiveData.postValue(movieDataSource);
        return movieDataSource;
    }

    public MutableLiveData<MovieDataSource> getMovieDataSourceMutableLiveData() {
        return movieDataSourceMutableLiveData;
    }
}
