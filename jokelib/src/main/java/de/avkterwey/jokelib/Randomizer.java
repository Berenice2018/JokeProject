package de.avkterwey.jokelib;

import java.util.List;

public class Randomizer {

    public static List<String> shuffleList(List<String> list){
        List<String> myList = list;
        String temp;

        for(int i=0; i< myList.size(); ++i){
            int random = (int) (Math.random() * (myList.size() - i)) + i;
            temp = myList.get(i);
            myList.set(i, myList.get(random));
            myList.set(random, temp);
        }

        return myList;
    }

}
