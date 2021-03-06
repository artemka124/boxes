package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle;
import com.lisuart.falldown.Model.Level.ALevel;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level23 extends ALevel {

    public Level23() {
        this.hasTimePower = true;
        this.hasBlockPower = true;
        this.blockTime = 1700;
        this.clockTime = 1700;
    }

    @Override
    public void init() {
        Random random = new Random();

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(15),
                0,
                new Vector2(8, 73),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(15),
                0,
                new Vector2(0, 73),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(0),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2 - 3.5f, 73),
                new Vector2(0, 0),
                2,
                18,
                0.5f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(0),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2 + 3.5f, 73),
                new Vector2(0, 0),
                2,
                18,
                0.5f
        ));

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-15),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width - 8, 73),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-15),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width, 73),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(25),
                0,
                new Vector2(3, 50),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(25),
                0,
                new Vector2(-5, 50),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-25),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width - 4, 50),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-25),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width + 4, 50),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));

///////////////////////////////////////////////////////////////////////////////////////////////////

        for (int i = 0; i < 17; i ++) {
            int f = random.nextInt(5);
            if (f == 0) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        45,
                        4,
                        new Vector2(14, -45),
                        new Vector2(0.5f, 85)
                ));
            } else if (f == 1) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        45,
                        4,
                        new Vector2(0, -45),
                        new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 2)
                ));

            } else if (f == 2) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        45,
                        4,
                        new Vector2(-15, -45),
                        new Vector2(com.lisuart.falldown.MyGdxGame.width - 1.5f, 85)
                ));

            } else if (f == 3) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        60,
                        4,
                        new Vector2(24, -45),
                        new Vector2(-1, 50)
                ));
            } else if (f == 4) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        60,
                        4,
                        new Vector2(-24, -45),
                        new Vector2(com.lisuart.falldown.MyGdxGame.width , 50)
                ));
            }
        }
    }
}
