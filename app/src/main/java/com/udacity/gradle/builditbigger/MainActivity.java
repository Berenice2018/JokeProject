package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import de.avkterwey.jokeact.JokeActivity;
import de.avkterwey.jokelib.MyJoke;

import static com.udacity.gradle.builditbigger.MyConstants.EXTRA_JOKE;


public class MainActivity extends AppCompatActivity implements IAsyncResponse {

    EndpointsAsyncTask mAsyncTask ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAsyncTask =  new EndpointsAsyncTask();
        mAsyncTask.setDelegate(this);
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

    public void tellJoke(View view) {

        // get joke from backend
        mAsyncTask.execute(this);
        // TODO show progressbar
    }


    @Override
    public void processTerminated(String out) {
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(EXTRA_JOKE, out );
        startActivity(intent);
    }
}
