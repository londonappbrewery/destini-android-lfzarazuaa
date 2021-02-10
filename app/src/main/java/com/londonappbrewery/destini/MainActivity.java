package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mStoryIndex = 1;
    private int[] mStoriesId = {R.string.T1_Story,
                            R.string.T2_Story,
                            R.string.T3_Story,
                            R.string.T4_End,
                            R.string.T5_End,
                            R.string.T6_End};
    private int[] mAnswersTopId = {R.string.T1_Ans1, R.string.T2_Ans1, R.string.T3_Ans1};
    private int[] mAnswersBottomId = {R.string.T1_Ans2, R.string.T2_Ans2, R.string.T3_Ans2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Destini", "Top button clicked.");
                updateElements(true);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Destini", "Bottom button clicked.");
                updateElements(false);
            }
        });

    }

    private void updateElements(boolean optionSelected) {
        int nextStoryIndex = StoryOptionsStateMachine.getNextStoryIndex(mStoryIndex, optionSelected);
        Log.d("Destini", "Current Story Index: " + mStoryIndex + ", Next Story Index: " + nextStoryIndex );
        if (nextStoryIndex <= 1 ) {
            mStoryIndex = 1;
            mStoryTextView.setText(mStoriesId[0]);
            mButtonTop.setText(mAnswersTopId[0]);
            mButtonBottom.setText(mAnswersBottomId[0]);
            return;
        }
        mStoryIndex = nextStoryIndex;
        nextStoryIndex--; // For index zero access.
        mStoryTextView.setText(mStoriesId[nextStoryIndex]); // Gets Id the string from the resource.
        if ( mStoryIndex < 4){ // Display more possible answers.
            mButtonTop.setText(mAnswersTopId[nextStoryIndex]); // Gets Id the string from the resource and put it as a possible.
            mButtonBottom.setText(mAnswersBottomId[nextStoryIndex]); // Gets Id the string from the resource and put it as a possible.
        }
        else {
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
    }
}
