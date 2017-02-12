package com.mygdx.game.Sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.States.Playstate;

/**
 * Created by Tej Sidhu on 10/02/2017.
 */
public class Player {
    public BodyDef playerDef;
    FixtureDef fixtureDefPlayer;
    CircleShape playerShape;
    public Body playerBody;
    public Player(World world) {
        //Player body
        //BodyDef
        playerDef = new BodyDef();
        playerDef.type = BodyDef.BodyType.DynamicBody;
        playerDef.position.set(300/Playstate.PPM, 400/Playstate.PPM);
        //Shape
        playerShape = new CircleShape();
        playerShape.setRadius(1.5f);
        //Fixture def
        fixtureDefPlayer = new FixtureDef();
        fixtureDefPlayer.shape = playerShape;
        fixtureDefPlayer.density = 1f;
        fixtureDefPlayer.restitution = 0f;
        fixtureDefPlayer.friction = 2.5f;
        //Creates the body
        playerBody = world.createBody(playerDef);
        playerBody.createFixture(fixtureDefPlayer);
        //world.createBody(playerDef).createFixture(fixtureDefPlayer);

    }
    public void update(float delta){

    }
    public void render(){

    }
    public void dispose(){
        playerShape.dispose();
    }
}
