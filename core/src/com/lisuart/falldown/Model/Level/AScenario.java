package com.lisuart.falldown.Model.Level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.AObject;
import com.lisuart.falldown.Model.Player;

import java.util.Vector;

/**
 * Created by User on 22.04.2018.
 */

public abstract class AScenario {
    protected Player player;
    protected World world;
    protected ALevel level;
    public boolean isDead = false;
    public float doDelay;
    public float gravityScale = 1;
    public Vector<AObject> objects = new Vector<AObject>();

    public boolean isKinematic = false;


    public void act() {
        doDelay -= 1f * ((float)GameLayout.speedSetting / (float)GameLayout.speed);
    }

    public abstract void render(SpriteBatch batch);

    public abstract void action();

    public void dispose() {

    }

    protected Vector2 getStandartPosition() {
        return new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10);
    }
}
