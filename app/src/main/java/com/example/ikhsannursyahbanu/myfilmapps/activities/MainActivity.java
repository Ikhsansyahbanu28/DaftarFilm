package com.example.ikhsannursyahbanu.myfilmapps.activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.example.ikhsannursyahbanu.myfilmapps.adapters.RecyclerViewAdapter;
import com.example.ikhsannursyahbanu.myfilmapps.model.Movie;
import com.example.ikhsannursyahbanu.myfilmapps.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    final String JSON_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=7c7c81a2c6f615c204eab26f0022c35a";
    final String IMG_URL = "http://image.tmdb.org/t/p/w185";
    JsonArrayRequest request;
    private RecyclerView recyclerView;
    RequestQueue Queue;
    private ArrayList<Movie> lstMovie = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstMovie = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewId);
        jsonrequest();
    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Movie movie = new Movie();
                        movie.setName(jsonObject.getString("title"));
                        movie.setPopularity(jsonObject.getString("popularity"));
                        movie.setRating(jsonObject.getString("vote_average"));
                        movie.setSinopsis(jsonObject.getString("overview"));
                        movie.setImage_url(jsonObject.getString(IMG_URL+"poster_path"));
                        lstMovie.add(movie);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Toast.makeText(MainActivity.this, "Size of LISTE" + String.valueOf(lstMovie.size()), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, lstMovie.get(1).toString(), Toast.LENGTH_SHORT).show();

                setuprecyclerview(lstMovie);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Queue = Volley.newRequestQueue(MainActivity.this);
        Queue.add(request);
    }

    public void setuprecyclerview(ArrayList<Movie> lstMovie) {
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstMovie);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
