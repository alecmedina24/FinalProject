package com.udacity.gradle.builditbigger;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alecmedina on 1/20/16.
 */
public interface JokeApi {
    @GET("myApi/v1/jokes")
    Call<Joke> fetch();
}
