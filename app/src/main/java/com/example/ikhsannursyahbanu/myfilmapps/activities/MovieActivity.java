package com.example.ikhsannursyahbanu.myfilmapps.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ikhsannursyahbanu.myfilmapps.R;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        // hide the default actionbar
        if (getActionBar()!=null){
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Recieve data
        String name  = getIntent().getExtras().getString("movie_name");
        String popularity = getIntent().getExtras().getString("movie_popularity");
        String sinopsis = getIntent().getExtras().getString("movie_sinopsis") ;
        String rating = getIntent().getExtras().getString("movie_rating") ;
        String image_url = getIntent().getExtras().getString("movie_img") ;

        // ini views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);
        TextView tv_name = findViewById(R.id.aa_movie_name);
        TextView tv_popularity = findViewById(R.id.aa_movie_popularity);
        TextView tv_sinopsis = findViewById(R.id.aa_movie_sinopsis);
        TextView tv_rating  = findViewById(R.id.aa_movie_rating) ;
        ImageView img_url = findViewById(R.id.aa_thumbnail);

        // setting values to each view
        tv_name.setText(name);
        tv_popularity.setText(popularity);
        tv_sinopsis.setText(sinopsis);
        tv_rating.setText(rating);
        collapsingToolbarLayout.setTitle(name);
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img_url);
    }
}
