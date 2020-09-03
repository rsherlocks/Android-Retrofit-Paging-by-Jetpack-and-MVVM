package com.example.androidshaper.movietrackbypaging;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class ResultObject {

    private String adult;
    private String backdrop_path;
    private Integer id;
    private String original_language;
    private String title;
    private String overview;
    private String release_date;
    private String video;
    private Integer vote_count;
    private Double vote_average;
    private String poster_path;

    public ResultObject() {
    }

    public ResultObject(String adult, String backdrop_path, Integer id, String original_language, String title, String overview, String release_date, String video, Integer vote_count, Double vote_average, String poster_path) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.id = id;
        this.original_language = original_language;
        this.title = title;
        this.overview = overview;
        this.release_date = release_date;
        this.video = video;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.poster_path = poster_path;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public static final DiffUtil.ItemCallback<ResultObject> CALLBACK= new DiffUtil.ItemCallback<ResultObject>() {
        @Override
        public boolean areItemsTheSame(@NonNull ResultObject oldItem, @NonNull ResultObject newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ResultObject oldItem, @NonNull ResultObject newItem) {
            return true;
        }
    };
}
