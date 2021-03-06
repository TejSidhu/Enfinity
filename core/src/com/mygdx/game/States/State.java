package com.mygdx.game.States;

/**
 * Created by Tej Sidhu on 9/02/2017.
 */


import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector3;
public abstract class State implements Screen {
    protected OrthographicCamera cam;//This is the camera used to view the game

    protected Vector3 mouse;    //Mouse xy

    protected  GameStateManager gsm;



    protected State(GameStateManager gsm){

        this.gsm = gsm;

        cam = new OrthographicCamera();

        mouse = new Vector3();

    }



    protected abstract void handleInput();

    public abstract void update(float delta);

    public abstract void render(SpriteBatch batch);

    public abstract void dispose();
}
