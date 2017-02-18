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

    }
    //Neat af code
    //Get on my level
    public void goLeft() {
        playerBody.applyLinearImpulse(new Vector2(-5f, 0),playerBody.getWorldCenter(), true);
    }
    public void goRight(){
        playerBody.applyLinearImpulse(new Vector2(5f, 0),playerBody.getWorldCenter(), true);
    }
    public void goUp(){
        playerBody.applyLinearImpulse(new Vector2(0, 50f),playerBody.getWorldCenter(), true);
    }
    public void goDown(){
        playerBody.applyLinearImpulse(new Vector2(0, -50f),playerBody.getWorldCenter(), true);
    }
    public void goNowhere(){
        playerBody.setLinearVelocity(0, 0);
    }
    public void dispose(){
        playerShape.dispose();
    }
}
