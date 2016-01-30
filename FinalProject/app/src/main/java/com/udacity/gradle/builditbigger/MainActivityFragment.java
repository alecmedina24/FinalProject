package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xphonesoftware.mainactivity.JokeDisplayMain;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokeService.CallBack {

    private JokeService jokeService;
    private String[] jokes;
    private int i;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        setUp(root);

        jokeService = new JokeService(this);
        jokeService.getJokes();

        i = 0;
        Button tellJokeButton = (Button) root.findViewById(R.id.tell_joke);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jokes != null) {
                    Intent intent = new Intent(getContext(), JokeDisplayMain.class);
                    intent.putExtra("joke", jokes[i]);
                    i++;
                    if (i > jokes.length - 1) {
                        i = 0;
                    }
                    startActivity(intent);
                }
            }
        });

        return root;
    }

    public void setJokes(String[] j) {
        jokes = j;
    }

    public void setUp(View view){}
}
