package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;

/**
 * Created by artem on 4/19/18.
 */
public class StaticVerticalPanel extends AObject {
    float sizeX = 3;
    float sizeY = 12;

    public StaticVerticalPanel(World world, Vector2 position, Vector2 speed, float initRotation, float rotation, int sizeX, int sizeY) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        shape.setAsBox(sizeX/2, sizeY/2);

        this.shape = shape;
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(position.x, position.y);
        body = world.createBody(bodyDef);
        body.setTransform(position.x, position.y, initRotation);
        setShapeToFixture(shape, 1, 1, 0);
        this.body.setLinearVelocity(speed);
        this.body.setTransform(this.body.getPosition().x, this.body.getPosition().y, initRotation);
        this.body.setAngularVelocity(rotation);
        this.body.setUserData(this);
        isKinematic = true;
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(
                Tex.rectangleGrey,
                this.body.getPosition().x - sizeX/2f,
                this.body.getPosition().y - sizeY/2f,
                sizeX / 2,
                sizeY / 2,
                sizeX,
                sizeY,
                Tex.rectangleGrey.getScaleX(),
                Tex.rectangleGrey.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
    }
}
