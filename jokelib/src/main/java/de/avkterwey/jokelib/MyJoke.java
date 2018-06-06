package de.avkterwey.jokelib;

import java.util.ArrayList;
import java.util.List;

public class MyJoke {

    private static MyJoke sMyJoke;
    private  List<String> mJokeList = new ArrayList<>();

    public static MyJoke getMyJokeInstance(){
        if(sMyJoke == null){
            sMyJoke = new MyJoke();
            sMyJoke.addJokes();
        }

        return sMyJoke;
    }


    private void addJokes(){

        // add jokes to the list
        mJokeList.add("Dude 1: We should make a game.\n\nDude 2: But, I only know one data structure.");
        mJokeList.add("A UI is like a joke. If you have to explain it, it is not that good.");
        mJokeList.add("In C++ we do not say \"Missing asterisk\", but\n" +
                        "error C2664: 'void std::vector<block,std::allocator<_Ty>>::push_back(const block &)': " +
                "cannot convert argument 1 from 'std::_Vector_iterator<std::_Vector_val<std::_Simple_types<block>>>' to 'block &&'");
        mJokeList.add("Why do Java programmers have to wear glasses? \n\nBecause they don't C#");
        mJokeList.add("How many programmers does it take to change a light bulb?\n\n" +
                "None – It’s a hardware problem.");

        mJokeList = Randomizer.shuffleList(mJokeList);
    }



    public String getMyJokeString(int position){
        return mJokeList.get(position);
    }


    public int getJokeListSize(){
        return mJokeList != null ?  mJokeList.size() : 0;
    }

    public List<String> getJokesList(){
        return mJokeList;
    }
}
