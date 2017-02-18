package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Batch;
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
    Texture background;
    public static final int PPM = 100;
    //public SpriteBatch batch;
    public Playstate(GameStateManager gsm) {
        super(gsm);

        cam = new OrthographicCamera();
        cam.setToOrtho(false, 1500, 1000);
        world = new World(new Vector2(0, -9.8f), true);
        b2dr = new Box2DDebugRenderer();
        player = new Player(world);
        terrain = new Terrain(world);
        cam.position.set(0,0,0);
        background = new Texture("Space-Backgrounds-3FB.jpg");

    }
    @Override
    protected void handleInput() {
        //If no key is pressed then it make the player stop and sets the Linear velocity to zero.
        if(!Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT) &&!Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.DOWN)  && player.playerBody.getLinearVelocity().x != 0){
            player.goNowhere();
        }
        //Left
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.playerBody.getLinearVelocity().x >= -10){ //The 10 limits the velocity of the ball
            player.goLeft();
        }
        //Right
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.playerBody.getLinearVelocity().x <= 10){
            player.goRight();
        }
        //Up
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP) && player.playerBody.getLinearVelocity().y >= -10){
            player.goUp();
        }
        //Down
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && player.playerBody.getLinearVelocity().y <= 10){
            player.goDown();
        }
    }

    @Override
    public void update(float delta) {
        cam.position.x = player.playerBody.getPosition().x + 23;
        cam.position.y = player.playerBody.getPosition().y + 20; 
        cam.update();
        world.step(delta, 6, 2);//Velocity and position itterations 
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {

        update(Gdx.graphics.getDeltaTime());
        b2dr.render(world, cam.combined);
        batch.setProjectionMatrix(cam.combined); //Idk if this is necessary since the b2dr is also set to cam.combined
        batch.draw(background, 0, 0);
        System.out.println("BACKGROUND DRAWN");
    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        //This asshole shit wont work
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
        background.dispose();
        world.dispose();
    }
}
