package com.lisuart.falldown.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by artem on 4/19/18.
 */
public class ObstacleTriangle extends AObject {
    int size;

    public ObstacleTriangle(World world, Vector2 position, int size, Vector2 speed, float initRotation, float rotation, float mass) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        Vector2[] vector2 = new Vector2[3];
        this.size = size;
        if (size == 1) {
            vector2[0] = new Vector2(0f, 5f);
            vector2[1] = new Vector2(-4.6f, -3f);
            vector2[2] = new Vector2(4.6f, -3f);
        } else if (size == 2) {
            vector2[0] = new Vector2(0f, 2f);
            vector2[1] = new Vector2(-1.5f, -1f);
            vector2[2] = new Vector2(1.5f, -1f);
        } else if (size == 3) {
            vector2[0] = new Vector2(0f, 1f);
            vector2[1] = new Vector2(-0.75f, -0.5f);
            vector2[2] = new Vector2(0.75f, -0.5f);
        }
        shape.set(vector2);
        this.shape = shape;
        this.createObject(position, shape, world, mass, 1f, 0);
        this.body.setLinearVelocity(speed);
        this.body.setAngularVelocity(rotation);
        this.body.setTransform(this.body.getPosition(), (float)Math.toRadians(initRotation));
        this.body.setUserData(this);
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        if (size == 1) {
            batch.draw(
                    com.lisuart.falldown.Config.Tex.triangle1,
                    this.body.getPosition().x - 4.6f,
                    this.body.getPosition().y - 3f,
                    4.6f,
                    3,
                    9.2f,
                    8,
                    com.lisuart.falldown.Config.Tex.rectangle1.getScaleX(),
                    com.lisuart.falldown.Config.Tex.rectangle1.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
        } else if (size == 2) {
            batch.draw(
                    com.lisuart.falldown.Config.Tex.triangle1,
                    this.body.getPosition().x - 1.5f,
                    this.body.getPosition().y - 1f,
                    1.5f,
                    1,
                    3f,
                    3,
                    com.lisuart.falldown.Config.Tex.rectangle1.getScaleX(),
                    com.lisuart.falldown.Config.Tex.rectangle1.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
        } else {
            batch.draw(
                    com.lisuart.falldown.Config.Tex.triangle1,
                    this.body.getPosition().x - 0.75f,
                    this.body.getPosition().y - 0.5f,
                    0.75f,
                    0.5f,
                    1.5f,
                    1.5f,
                    com.lisuart.falldown.Config.Tex.rectangle1.getScaleX(),
                    com.lisuart.falldown.Config.Tex.rectangle1.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
        }
    }
}
