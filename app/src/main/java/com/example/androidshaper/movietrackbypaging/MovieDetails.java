package com.example.androidshaper.movietrackbypaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {

    ImageView imageViewBanner;
    TextView textViewTitle,textViewDescription,textViewLanguage,textViewVote,textViewAdult,textViewVideo,textViewRating,textViewDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        textViewTitle=findViewById(R.id.movieTitleTextView);
        imageViewBanner=findViewById(R.id.imageViewBanner);
        textViewAdult=findViewById(R.id.textViewAdult);
        textViewRating=findViewById(R.id.textViewRating);
        textViewLanguage=findViewById(R.id.textViewLanguage);
        textViewDate=findViewById(R.id.movieDateTextView);
        textViewDescription=findViewById(R.id.textViewDescription);
        textViewVote=findViewById(R.id.textViewTotalVote);
        textViewVideo=findViewById(R.id.textViewVideo);
        Intent intent = getIntent();

        String movieTitle=intent.getExtras().getString("MovieTitle");
        String bannerUrl=intent.getExtras().getString("MovieImage");
        String movieDate=intent.getExtras().getString("MovieDate");

        textViewTitle.setText(movieTitle);
        textViewDescription.setText( intent.getExtras().getString("MovieDescription"));
        textViewDate.setText("Publish date: "+movieDate);
        textViewVideo.setText("Video: "+intent.getExtras().getString("MovieVideo"));
        textViewAdult.setText("Adult: "+intent.getExtras().getString("MovieAdult"));
        textViewRating.setText(intent.getExtras().getString("MovieRating"));
        textViewLanguage.setText("Language: "+intent.getExtras().getString("MovieLanguage"));
        textViewVote.setText("Vote: "+intent.getExtras().getString("MovieVote"));

        Picasso.get().load(bannerUrl).into(imageViewBanner);
    }
}