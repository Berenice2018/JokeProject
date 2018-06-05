package de.avkterwey.jokelib;

public class MyJoke {

    private static MyJoke sMyJoke;

    public static MyJoke getMyJokeInstance(){
        if(sMyJoke == null){
            sMyJoke = new MyJoke();
        }

        return sMyJoke;
    }



    public String getMyJokeString(){
        return "My first joke from the lib";
    }
}
