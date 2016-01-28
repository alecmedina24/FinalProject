package com.xphonesoftware.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by alecmedina on 1/18/16.
 */
public class JokeDisplayMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_layout);
        Intent intent = getIntent();
        String joke = intent.getStringExtra("joke");
        TextView textView = (TextView) findViewById(R.id.joke_text_view);
        textView.setText(joke);
    }

}
