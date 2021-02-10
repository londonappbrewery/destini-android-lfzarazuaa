package com.londonappbrewery.destini;

import android.app.Activity;
import android.util.Log;
import android.view.View;

/**
 * Created by Luis Zarazua on 2/9/2021.
 */

public class StoryOptionsStateMachine{

    public static int getNextStoryIndex(int storyIndex, boolean OptionSelected){
        switch (storyIndex){
            case 1:
                storyIndex = OptionSelected ? 3 : 2;
                break;
            case 2:
                storyIndex = OptionSelected ? 3 : 4;
                break;
            case 3:
                storyIndex = OptionSelected ? 6 : 5;
                break;
            default:
                storyIndex = 1;
        }
        return storyIndex;
    }

}
