package com.example.androidshaper.movietrackbypaging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Configuration;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    MyAdapter myAdapter;
    RecyclerView recyclerViewMovie;
    private PagedList<ResultObject> pagedList;
    MainActivityViewModel mainActivityViewModel;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewMovie=findViewById(R.id.movieRecyclerView);
        swipeRefreshLayout=findViewById(R.id.swipeRefreshLayout);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                loadDataByJetpack();



                swipeRefreshLayout.setRefreshing(false);
            }
        });

        loadDataByJetpack();

    }

    private void loadDataByJetpack() {


        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);


        mainActivityViewModel.getPagedListLiveData().observe(this, new Observer<PagedList<ResultObject>>() {
            @Override
            public void onChanged(PagedList<ResultObject> resultObjects) {

                pagedList=resultObjects;
                RecyclerViewConfig();

            }
        });

    }

    private void RecyclerViewConfig() {
        myAdapter=new MyAdapter(this);
        myAdapter.submitList(pagedList);

        if (this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
        {
            GridLayoutManager gridLayoutManager= new GridLayoutManager(getApplicationContext(),2);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            recyclerViewMovie.setLayoutManager(gridLayoutManager);

        }
        else {
            GridLayoutManager gridLayoutManager= new GridLayoutManager(getApplicationContext(),4);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            recyclerViewMovie.setLayoutManager(gridLayoutManager);
        }
        recyclerViewMovie.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMovie.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();



    }


}