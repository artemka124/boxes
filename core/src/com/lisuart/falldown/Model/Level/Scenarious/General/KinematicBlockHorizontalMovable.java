package com.lisuart.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.lisuart.falldown.Model.AObject;
import com.lisuart.falldown.Model.Level.AScenario;
import com.lisuart.falldown.Model.Player;
import com.lisuart.falldown.Model.Level.ALevel;

/**
 * Created by User on 22.04.2018.
 */

public class KinematicBlockHorizontalMovable extends AScenario {

    public KinematicBlockHorizontalMovable(
            World world,
            Player player,
            ALevel level,
            int delay,
            float initRotation,
            float rotation,
            Vector2 position,
            Vector2 finalPosition,
            Vector2 speed,
            int x,
            int y,
            float r,
            int time
    ) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.objects.add(new com.lisuart.falldown.Model.StaticVerticalPanelTimeAndPosition(
                world,
                position,
                finalPosition,
                speed,
                initRotation,
                rotation,
                x,
                y,
                r,
                time
        ));
        this.doDelay = delay;

        this.isKinematic = true;
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public void action() {
        AObject a = this.objects.firstElement();
        this.objects.remove(a);
        a.getBody().setActive(true);
        this.level.aObjectVector2.add(a);
        isDead = true;
    }
}
