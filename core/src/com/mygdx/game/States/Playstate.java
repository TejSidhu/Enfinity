package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.Sprites.Player;
import com.mygdx.game.Sprites.Terrain;

public class Playstate extends State implements Screen{
    private OrthographicCamera cam;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Player player;
    private Terrain terrain;
    public static final int PPM = 100;
    public Playstate(GameStateManager gsm) {
        super(gsm);
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 150, 100);
        world = new World(new Vector2(0, 9.8f), true);
        b2dr = new Box2DDebugRenderer();
        player = new Player(world);
        terrain = new Terrain(world);
        cam.position.set(0,0,0);

    }
    @Override
    protected void handleInput() {
        if(!Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT) &&!Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.DOWN)  && player.playerBody.getLinearVelocity().x != 0){
            player.playerBody.setLinearVelocity(0, 0);
        }if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.playerBody.getLinearVelocity().x > -10){ //The 10 limits the velocity of the ball
            player.playerBody.applyLinearImpulse(new Vector2(-3f, 0),player.playerBody.getWorldCenter(), true);
        }if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.playerBody.applyLinearImpulse(new Vector2(0.2f, 0),player.playerBody.getWorldCenter(), true);
        }if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            player.playerBody.applyLinearImpulse(new Vector2(0, -50f),player.playerBody.getWorldCenter(), true);
        }if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            player.playerBody.applyLinearImpulse(new Vector2(0, -0.3f),player.playerBody.getWorldCenter(), true);
        }
    }

    @Override
    public void update(float delta) {
        cam.position.x = player.playerBody.getPosition().x + 23;
        cam.position.y = player.playerBody.getPosition().y - 15; //MIGHT NEED THIS LATER
        cam.update();
        world.step(delta, 6, 2);
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(cam.combined); //Idk if this is necessary since the b2dr is also set to cam.combined
        update(Gdx.graphics.getDeltaTime());
        b2dr.render(world, cam.combined);
    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
       //This render loop doesn't even work
        //Useless piece of ****
    }

    @Override
    public void resize(int width, int height) {
        //System.out.println("Resized");
        cam.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        world.dispose();
    }
}
