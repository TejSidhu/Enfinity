package com.mygdx.game.Sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Tej Sidhu on 12/02/2017.
 */
public class Terrain {
    Body ground;
    BodyDef groundDef;
    FixtureDef groundFixDef;
    World world;
    ChainShape groundShape;
    Body groundBody;
    public Terrain(World world) {
        this.world = world;
        initTerrain();
    }

    public void initTerrain() {

        //Body def
        groundDef = new BodyDef();
        groundDef.type = BodyDef.BodyType.StaticBody;
        groundDef.position.set(0,0);
        //Shape
        groundShape = new ChainShape();
        groundShape.createChain(new Vector2[]{new Vector2(-200, 60), new Vector2(500, 60)});
        //Fixture
        groundFixDef = new FixtureDef();
        groundFixDef.shape = groundShape;
        groundFixDef.density = 2.5f;
        groundFixDef.friction = 1f;
        groundFixDef.restitution = 0;
        //Body
        groundBody = world.createBody(groundDef);
        groundBody.createFixture(groundFixDef);
        world.createBody(groundDef).createFixture(groundFixDef);
        groundShape.dispose();
    }
}
