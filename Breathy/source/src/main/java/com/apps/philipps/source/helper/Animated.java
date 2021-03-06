package com.apps.philipps.source.helper;

import android.provider.Settings;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;

import com.apps.philipps.source.AppState;
import com.apps.philipps.source.interfaces.IObserver;

import java.security.PolicySpi;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jevgenij Huebert on 18.03.2017. Project Breathy
 */
public class Animated {

    private Vector position;
    private Vector destination;
    private List<IObserver> oberver = new ArrayList<>();
    private int speed;

    private boolean active = false;

    /**
     * Instantiates a new Animated.
     *
     * @param position the position
     */
    public Animated(@NonNull Vector position){
        this.position = position;
    }


    /**
     * Instantiates a new Animated.
     *
     * @param position    the position
     * @param destination the destination
     */
    public Animated(@NonNull Vector position, @NonNull Vector destination){
        this.position = position;
        this.destination = destination;
    }

    public boolean isMoving(){
        return active;
    }

    /**
     * Instantiates a new Animated.
     *
     * @param position    the position
     * @param destination the destination
     * @param speed       the speed
     * @param activate    the activate
     */
    public Animated(@NonNull Vector position, @NonNull Vector destination, int speed, boolean activate){
        this.position = position;
        this.destination = destination;
        this.speed = speed;
        this.active = activate;
    }

    /**
     * Stop.
     */
    public void stop(){
        active = false;
    }

    /**
     * Resume.
     */
    public void resume(){
        active = true;
    }

    public void resume(int speed){
        this.speed = speed;
        active = true;
    }

    /**
     * Animate.
     *
     * @param destination the destination
     * @param speed       the speed
     */
    public void animate(Vector destination, Integer speed){
        if(speed!=null)
            this.speed = speed;
        this.destination = destination;
        active = true;
    }

    /**
     * Get position vector.
     *
     * @return the vector
     */
    public Vector getPosition(){
        return position;
    }

    /**
     * Add observer.
     *
     * @param observer the observer
     */
    public void addObserver(IObserver observer){
        this.oberver.add(observer);
    }

    public void update(long deltaMilliseconds) {
        if (active) {
            if (position.compareTo(destination) == 0)
                active = false;
            else {
                Vector add = Vector.mult(Vector.sub(destination, position).norm(), speed * deltaMilliseconds / 1000f);
                if (position.getDistance(destination) < position.getDistance(Vector.add(position, add)))
                    destination = position.clone();
                else {
                    position.add(add);
                    for (IObserver o : oberver)
                        o.call(position);
                }
            }
        }
    }
}
