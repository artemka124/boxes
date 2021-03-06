package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontalRotate;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockX;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level19 extends ALevel {

    public Level19() {
        this.hasTimePower = true;
        this.hasBlockPower = true;
        this.blockTime = 1700;
        this.clockTime = 1700;
    }

    @Override
    public void init() {
        Random random = new Random();
        this.aScenarioVector2.add(new KinematicBlockHorizontalRotate(
                GameLayout.world,
                player,
                this,
                0,
                new Vector2(-3, 64),
                new Vector2(0, 0),
                (float) Math.toRadians(0),
                (float) Math.toRadians(125),
                (float) Math.toRadians(-180),
                200,
                2,
                25,
                0.5f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontalRotate(
                GameLayout.world,
                player,
                this,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width + 2, 64),
                new Vector2(0, 0),
                (float) Math.toRadians(0),
                (float) Math.toRadians(125),
                (float) Math.toRadians(180),
                200,
                2,
                25,
                0.5f
        ));

        for (int i = 0; i < 40; i ++) {
            int result = random.nextInt(3);
            if (result == 0) {
                this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        random.nextInt(80),
                        random.nextInt(3) + 2,
                        new Vector2(random.nextInt(10) - 5, -5),
                        new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10)
                ));
            } else if (result == 1) {
                this.aScenarioVector2.add(new SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        random.nextInt(80),
                        random.nextInt(10),
                        0,
                        new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                        new Vector2(random.nextInt(10) - 5, -5),
                        1,
                        1 + random.nextInt(2)
                ));
            } else if (result == 2) {
                this.aScenarioVector2.add(new SimpleBlockX(
                        GameLayout.world,
                        player,
                        this,
                        new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                        new Vector2(random.nextInt(10) - 5, -5),
                        random.nextInt(80),
                        random.nextInt(10),
                        random.nextInt(10),
                        1,
                        1,
                        0.5f + random.nextFloat()
                ));
            }
        }
    }
}
