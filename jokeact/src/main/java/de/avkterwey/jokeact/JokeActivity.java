package de.avkterwey.jokeact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private final static String TAG = "JokeActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = getIntent().getStringExtra("Joke");
        //Log.d(TAG, "##### extra = "+joke);

        TextView jokeview = findViewById(R.id.joke_textview);
        jokeview.setText(joke);
    }
}
