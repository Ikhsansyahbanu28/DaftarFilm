package com.example.ikhsannursyahbanu.myfilmapps.model;

public class Movie  {
    private String name;
    private String sinopsis;
    private String popularity;
    private String rating;
    private String image_url;

    public Movie(String name, String sinopsis, String popularity, String rating, String image_url) {
        this.name = name;
        this.sinopsis = sinopsis;
        this.popularity = popularity;
        this.rating = rating;
        this.image_url = image_url;
    }

    public Movie() {

    }

    //Getter
    public String getName() {
        return name;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getRating() {
        return rating;
    }

    public String getImage_url() {
        return image_url;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}