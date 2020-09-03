package com.example.androidshaper.movietrackbypaging;

import android.app.Application;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class MainActivityViewModel extends AndroidViewModel {


    LiveData<MovieDataSource> movieDataSourceLiveData;

    private Executor executor;
    private  LiveData<PagedList<ResultObject>> pagedListLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);


        //
        OurRetrofitClient ourRetrofitClient=RetrofitInstance.getService();
        MovieDataSourceFactory movieDataSourceFactory=new MovieDataSourceFactory(ourRetrofitClient,application);
        movieDataSourceLiveData=movieDataSourceFactory.getMovieDataSourceMutableLiveData();
        PagedList.Config config=(new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(5)
                .setPageSize(10)
                .setPrefetchDistance(4)
                .build();

        executor= Executors.newFixedThreadPool(5);
        pagedListLiveData=(new LivePagedListBuilder<Long,ResultObject>(movieDataSourceFactory,config))
                .setFetchExecutor(executor)
                .build();



    }


    public LiveData<PagedList<ResultObject>> getPagedListLiveData() {
        return pagedListLiveData;
    }
}
