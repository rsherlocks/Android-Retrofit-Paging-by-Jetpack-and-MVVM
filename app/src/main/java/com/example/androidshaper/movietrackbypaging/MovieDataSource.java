package com.example.androidshaper.movietrackbypaging;

import android.media.Session2Command;
import android.util.Log;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDataSource extends PageKeyedDataSource<Long,ResultObject> {

    private OurRetrofitClient ourRetrofitClient;

    public MovieDataSource(OurRetrofitClient ourRetrofitClient) {
        this.ourRetrofitClient = ourRetrofitClient;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull final LoadInitialCallback<Long, ResultObject> callback) {

        ourRetrofitClient=RetrofitInstance.getService();

        Call<MainObject> call=ourRetrofitClient.getObjectWithPaging("38f781893cc431e2b2c21a872925a0ab",1);

        call.enqueue(new Callback<MainObject>() {
            @Override
            public void onResponse(Call<MainObject> call, Response<MainObject> response) {
                if (response.isSuccessful())
                {
                    Log.d("Page", "onResponse: "+String.valueOf(response.body().getPage()));
                    Log.d("TotalPage", "onResponse: "+String.valueOf(response.body().getTotal_pages()));
                    Log.d("TotalResult", "onResponse: "+String.valueOf(response.body().getTotal_results()));
                    MainObject mainObject=response.body();
                    if(mainObject!=null && mainObject.getResults()!=null)
                    {
                        ArrayList<ResultObject> resultObjectArrayList=new ArrayList<>();
                        resultObjectArrayList=(ArrayList<ResultObject>) mainObject.getResults();
                        callback.onResult(resultObjectArrayList,null, (long) 2);
                    }



                }

            }

            @Override
            public void onFailure(Call<MainObject> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, ResultObject> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Long> params, @NonNull final LoadCallback<Long, ResultObject> callback) {

        ourRetrofitClient=RetrofitInstance.getService();

        Call<MainObject> call=ourRetrofitClient.getObjectWithPaging("38f781893cc431e2b2c21a872925a0ab",params.key);

        call.enqueue(new Callback<MainObject>() {
            @Override
            public void onResponse(Call<MainObject> call, Response<MainObject> response) {
                if (response.isSuccessful())
                {
                    Log.d("Page", "onResponse: "+String.valueOf(response.body().getPage()));
                    Log.d("TotalPage", "onResponse: "+String.valueOf(response.body().getTotal_pages()));
                    Log.d("TotalResult", "onResponse: "+String.valueOf(response.body().getTotal_results()));
                    MainObject mainObject=response.body();
                    if(mainObject!=null && mainObject.getResults()!=null)
                    {
                        ArrayList<ResultObject> resultObjectArrayList=new ArrayList<>();
                        resultObjectArrayList=(ArrayList<ResultObject>) mainObject.getResults();
                      callback.onResult(resultObjectArrayList,params.key+1);
                    }



                }

            }

            @Override
            public void onFailure(Call<MainObject> call, Throwable t) {

            }
        });

    }
}
