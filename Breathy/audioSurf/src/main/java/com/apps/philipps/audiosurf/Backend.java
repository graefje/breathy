package com.apps.philipps.audiosurf;

import com.apps.philipps.source.GameOptions;

/**
 * Created by Jevgenij Huebert on 28.01.2017. Project Breathy
 */
public class Backend {
    /**
     * The GameOptions.
     */
    public static GameOptions<String, Boolean> options;
    /**
     * The constant highscore.
     */
    public static int highscore;
    private static boolean init=false;


    /**
     * Reinitialize <code>Backend</code> of the game.
     */
    public static void reinit(){
        init = false;
        init();
    }
    /**
     * Initialize <code>Backend</code> of the game.
     */
    public static boolean init() {
        if (!init) {
            //TODO: Die Werte (gekauft, nicht gekauft) sollten mit SaveData ausgelesen werden

            options = new GameOptions<>();
            options.add("First Skin", false, 20);
            options.add("Second Skin", false, 40);
            options.add("Third Skin", false, 30);
            options.add("Fourth Skin", false, 70);
            init = true;
            return true;
        }
        return false;
    }
}
