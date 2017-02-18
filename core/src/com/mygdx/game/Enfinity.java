package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.States.GameStateManager;
import com.mygdx.game.States.Playstate;

public class Enfinity extends ApplicationAdapter {
	SpriteBatch batch;
	GameStateManager gsm;
	public static final int PPM = 150;
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new Playstate(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());//Calls the gsm so that it can update all the states.
		batch.begin();
		gsm.render(batch);
		batch.end();
		//update(); DONT NEED THIS FOR NOW oR MAYBE EVER
	}
	public void update(){

    }
	@Override
	public void dispose () {
		batch.dispose();
	}
}
