package com.apps.philipps.test.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.apps.philipps.test.R;
import com.apps.philipps.source.AppState;
import com.apps.philipps.source.BreathData;
import com.apps.philipps.source.helper._2D.Activity2D;

public class Game extends Activity2D {

    private TextView framerate;
    private TextView frameCount;
    private TextView dataDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_game);
        AppState.recordData = AppState.inGame = true;
    }


    @Override
    protected void draw() {
        String data = BreathData.getAsString(0, 5);
        dataDisplay.setText(data);
        framerate.setText(frameRate + " fps");
        frameCount.setText("frame " + frame);
    }

    @Override
    protected void init() {
        framerate = (TextView) findViewById(R.id.test_framerate);
        dataDisplay = (TextView) findViewById(R.id.test_data);
        frameCount = (TextView) findViewById(R.id.test_frameCount);
    }

    @Override
    protected void touch(MotionEvent event) {

    }

    public void startGame(View view) {
        Intent i = new Intent(this, Application.class);
        startActivity(i);
    }
}