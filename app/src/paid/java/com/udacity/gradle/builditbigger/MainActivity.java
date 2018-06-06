package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import de.avkterwey.jokeact.JokeActivity;
import de.avkterwey.jokelib.MyJoke;

import static com.udacity.gradle.builditbigger.MyConstants.EXTRA_JOKE;


public class MainActivity extends AppCompatActivity implements IAsyncResponse {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String KEY_COUNTER = "key_counter";
    private EndpointsAsyncTask mAsyncTask ;
    private ProgressBar mProgressbar;
    private int mNumberOfJokes;
    private int mCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumberOfJokes = MyJoke.getMyJokeInstance().getJokeListSize();
        mProgressbar = findViewById(R.id.progressBar);
        mProgressbar.setVisibility(View.INVISIBLE);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_COUNTER, mCounter);
    }

    @Override
    public void onRestoreInstanceState(Bundle state){
        super.onRestoreInstanceState(state);
        mCounter = state.getInt(KEY_COUNTER);
    }



    public void tellJoke(View view) {
        mProgressbar.setVisibility(View.VISIBLE);

        if(mCounter < (mNumberOfJokes-1)){
            mCounter++;
        }
        else{
            mCounter = 0;
        }

        getJokeFromBackend();

    }


    @Override
    public void processTerminated(String out) {
        mProgressbar.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(EXTRA_JOKE, out );
        startActivity(intent);
    }


    private void getJokeFromBackend(){
        mAsyncTask= new EndpointsAsyncTask();
        mAsyncTask.setDelegate(this);
        mAsyncTask.execute(mCounter);
    }


}
