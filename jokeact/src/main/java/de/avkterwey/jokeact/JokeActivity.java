package de.avkterwey.jokeact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class JokeActivity extends AppCompatActivity {

    private final static String TAG = "JokeActivity";
    public static final String EXTRA_KEY_JOKE ="joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        if(getIntent()!=null){
            String joke = getIntent().getStringExtra(EXTRA_KEY_JOKE);

            TextView jokeview = findViewById(R.id.joke_textview);
            jokeview.setText(joke);
        }
        
    }

}
