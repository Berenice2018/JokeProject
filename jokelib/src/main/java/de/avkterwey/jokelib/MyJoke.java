package de.avkterwey.jokelib;

import java.util.ArrayList;
import java.util.List;

public class MyJoke {

    private static MyJoke sMyJoke;
    private static List<String> sJokeList = new ArrayList<>();

    public static MyJoke getMyJokeInstance(){
        if(sMyJoke == null){
            sMyJoke = new MyJoke();

            // add jokes to the list
            sJokeList.add("joke 0");
            sJokeList.add("joke 1");
            sJokeList.add("joke 2");
            sJokeList.add("joke 3");
            sJokeList.add("joke 4");

            // TODO randomize

        }

        return sMyJoke;
    }



    public String getMyJokeString(){
        return "My first joke from the lib";
    }

    public String getMyJokeString(int position){
        return sJokeList.get(position);
    }


    public int getJokeListSize(){
        return sJokeList != null ?  sJokeList.size() : 0;
    }
}
