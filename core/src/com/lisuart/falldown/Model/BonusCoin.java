package com.lisuart.falldown.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.lisuart.falldown.Config.Progress;

import java.util.Random;

/**
 * Created by artem on 4/19/18.
 */
public class BonusCoin extends ABonus {
    float sizeX = 2f;
    float sizeY = 3;
    Random random;

    int time = 550;

    public BonusCoin(World world, Vector2 position) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        Vector2[] vector2 = new Vector2[4];
        vector2[0] = new Vector2(0, -sizeY/2);
        vector2[1] = new Vector2(-sizeX/2, 0);
        vector2[2] = new Vector2(0, sizeY/2);
        vector2[3] = new Vector2(sizeX/2, 0);
        shape.set(vector2);
        this.shape = shape;
        this.createObject(position, shape, world, 0.9f, 1f, 0);
        this.body.setUserData(this);
        timeExpire = 15;
        random = new Random();
    }

    public BonusCoin(World world, Vector2 position, Vector2 speed) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        Vector2[] vector2 = new Vector2[4];
        vector2[0] = new Vector2(0, -sizeY/2);
        vector2[1] = new Vector2(-sizeX/2, 0);
        vector2[2] = new Vector2(0, sizeY/2);
        vector2[3] = new Vector2(sizeX/2, 0);
        shape.set(vector2);
        this.shape = shape;
        this.createObject(position, shape, world, 0.9f, 1f, 0);
        this.body.setUserData(this);
        this.body.setLinearVelocity(speed);
        timeExpire = 15;
        random = new Random();
    }

    @Override
    public void act() {
        com.lisuart.falldown.Config.Tex.createParticles(1, 0.5f, new Vector2(this.body.getPosition().x + random.nextInt(4) - 2, this.body.getPosition().y + random.nextInt(4) - 2));
        super.act();
        if (isBonusGiven) {
            timeExpire--;
            if (timeExpire <= 0) {
                this.setDispose(true);
                body.setActive(false);
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        if (!isDisposed) {
            batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, timeExpire / timeExpireSetting);
            batch.draw(
                    com.lisuart.falldown.Config.Tex.diamond,
                    this.body.getPosition().x - sizeX / 2f,
                    this.body.getPosition().y - sizeY / 2f,
                    sizeX / 2,
                    sizeY / 2,
                    sizeX,
                    sizeY,
                    com.lisuart.falldown.Config.Tex.present1.getScaleX(),
                    com.lisuart.falldown.Config.Tex.present1.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
            batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, 1);
        }
    }

    public void handlePlayer(Player player) {
        if (isBonusGiven) {
            return;
        }
        com.lisuart.falldown.Model.Music.Music.coin();
        com.lisuart.falldown.Config.Tex.createParticles(30, 1, this.body.getPosition());
        isBonusGiven = true;
        Progress.addDiamond();
    }

}
