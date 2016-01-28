package com.udacity.gradle.builditbigger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by alecmedina on 1/25/16.
 */
public class JokeService {
    private CallBack callBack;

    public interface CallBack{
        void setJokes(String[] jokes);
    }

    public JokeService(CallBack callBack) {
        this.callBack = callBack;
    }

    public void getJokes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://finalproject-1197.appspot.com/_ah/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final JokeApi jokeApi = retrofit.create(JokeApi.class);
        Call<Joke> call = jokeApi.fetch();
        call.enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Response<Joke> response) {
                callBack.setJokes(response.body().getData());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

}
