package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Scenarious.Level12.TutorialClock;

/**
 * Created by User on 22.04.2018.
 */

public class Level10 extends ALevel {

    public Level10() {
        this.hasTimePower = true;
        this.clockTime = 450;
    }

    @Override
    public void init() {
        for (int i = -3; i < 3; i++) {
            this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal(
                    com.lisuart.falldown.Layout.GameLayout.world,
                    this.player,
                    this,
                    10,
                    0,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width/2 + i * 4, com.lisuart.falldown.MyGdxGame.height + 4),
                    new Vector2(0, 0),
                    2,
                    5
            ));
        }
        for (int i = 3; i >= -3; i--) {
            this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal(
                    com.lisuart.falldown.Layout.GameLayout.world,
                    this.player,
                    this,
                    10,
                    0,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width/2 + i * 4, com.lisuart.falldown.MyGdxGame.height + 4),
                    new Vector2(0, 0),
                    2,
                    5
            ));
        }

        com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb o = new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                4,
                new Vector2(13, -5),
                new Vector2(-5, 50),
                0.9f,
                5,
                110
        );
        this.aScenarioVector2.add(o);

        o = new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                4,
                new Vector2(-13, -5),
                new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, 50),
                0.9f,
                11,
                100
        );
        this.aScenarioVector2.add(o);

        this.aScenarioVector2.add(new TutorialClock(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                10
        ));

        for (int i = -2; i < 5; i++) {
            this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal(
                    com.lisuart.falldown.Layout.GameLayout.world,
                    this.player,
                    this,
                    10,
                    0,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width/2 + i * 4, com.lisuart.falldown.MyGdxGame.height + 2),
                    new Vector2(0, -20),
                    2,
                    6
            ));
        }

        for (int i = -2; i <= 2; i++) {
            this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockX(
                    com.lisuart.falldown.Layout.GameLayout.world,
                    this.player,
                    this,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width/2 + i * 7 , com.lisuart.falldown.MyGdxGame.height + 5),
                    new Vector2(0, -15),
                    2,
                    0,
                    10,
                    0.4f,
                    2,
                    1
            ));
        }
    }
}
