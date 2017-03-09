package com.apps.philipps.audiosurf;

import android.content.Context;

import com.apps.philipps.audiosurf.activities.Game;
import com.apps.philipps.source.AppState;
import com.apps.philipps.source.abstracts.AbstractRenderer;
import com.apps.philipps.source.interfaces.IObserver;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Jevgenij Huebert on 09.03.2017. Project Breathy
 */
public class MyRenderer extends AbstractRenderer {
    int frames;
    Context game;
    public MyRenderer(Game game, IObserver observer) {
        this.observer = observer;
        this.game = game;
        AppState.framelimit = AppState.Framelimit.Thirty;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        super.onSurfaceCreated(gl, config);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }
}