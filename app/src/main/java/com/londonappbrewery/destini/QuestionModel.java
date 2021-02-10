package com.londonappbrewery.destini;

/**
 * Created by Luis Zarazua on 2/9/2021.
 */

public class QuestionModel {
    public String strStory;
    public String strAnswerTop;
    public String strAnswerBottom;
    public int storyIndex;
    public int nextStoryIndex;

    public QuestionModel(String strStory, String strAnswerTop, String strAnswerBottom, int storyIndex, int nextStoryIndex) {
        this.strStory = strStory;
        this.strAnswerTop = strAnswerTop;
        this.strAnswerBottom = strAnswerBottom;
        this.storyIndex = storyIndex;
        this.nextStoryIndex = nextStoryIndex;
    }
}
