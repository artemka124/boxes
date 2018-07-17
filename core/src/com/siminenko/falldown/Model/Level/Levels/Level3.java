package com.siminenko.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level3 extends com.siminenko.falldown.Model.Level.ALevel {

    public Level3() {

    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 30, 2, new Vector2(7, 0), new Vector2(-5, MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 0, 2, new Vector2(-7, 0), new Vector2(MyGdxGame.width + 5, MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 100, 3, new Vector2(7, 0), new Vector2(-5, MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 0, 3, new Vector2(-7, 0), new Vector2(MyGdxGame.width + 5, MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 100, 4, new Vector2(7, 0), new Vector2(-5, MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 0, 4, new Vector2(-7, 0), new Vector2(MyGdxGame.width + 5, MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 100, 5, new Vector2(7, 0), new Vector2(-5, MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 0, 5, new Vector2(-7, 0), new Vector2(MyGdxGame.width + 5, MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 100, 6, new Vector2(7, 0), new Vector2(-5, MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 0, 6, new Vector2(-7, 0), new Vector2(MyGdxGame.width + 5, MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 100, 7, new Vector2(7, 0), new Vector2(-5, MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 0, 7, new Vector2(-7, 0), new Vector2(MyGdxGame.width + 5, MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 100, 8, new Vector2(7, 0), new Vector2(-5, MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 0, 8, new Vector2(-7, 0), new Vector2(MyGdxGame.width + 5, MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 100, 9, new Vector2(7, 0), new Vector2(-5, MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 0, 9, new Vector2(-7, 0), new Vector2(MyGdxGame.width + 5, MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 100, 15, new Vector2(0, 0), new Vector2(MyGdxGame.width/2, MyGdxGame.height + 5)));

    }
}