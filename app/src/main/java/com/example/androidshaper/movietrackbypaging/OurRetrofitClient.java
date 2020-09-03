package com.example.androidshaper.movietrackbypaging;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OurRetrofitClient {

    @GET("popular")
    Call<MainObject> getObject(@Query("api_key") String api_key);

    @GET("popular")
    Call<MainObject> getObjectWithPaging(@Query("api_key") String api_key,@Query("page")long page);
}
