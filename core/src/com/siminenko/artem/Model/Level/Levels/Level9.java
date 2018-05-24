package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.BonusBig;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBonusBig;
import com.siminenko.artem.Model.Level.Scenarious.Level9.TutorialBonusBig;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level9 extends ALevel {

    public Level9() {

    }

    @Override
    public void init() {
        SimpleBlockCircleBomb cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                50,
                10,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 - 11, MyGdxGame.height + 10),
                1,
                0,
                160
        );
        this.aScenarioVector2.add(cb);
        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                6,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 + 11, MyGdxGame.height + 10),
                1,
                14,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                130,
                10,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 + 11, MyGdxGame.height + 10),
                1,
                0,
                160
        );
        this.aScenarioVector2.add(cb);
        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                6,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 - 11, MyGdxGame.height + 10),
                1,
                14,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                130,
                6,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 + 11, MyGdxGame.height + 10),
                1,
                0,
                160
        );
        this.aScenarioVector2.add(cb);
        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                10,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 - 11, MyGdxGame.height + 10),
                1,
                14,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                130,
                10,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 + 11, MyGdxGame.height + 10),
                1,
                0,
                160
        );
        this.aScenarioVector2.add(cb);
        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                6,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 - 11, MyGdxGame.height + 10),
                1,
                14,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                200,
                6,
                new Vector2(25, 15),
                new Vector2(-5, MyGdxGame.height - 25),
                1,
                14,
                80
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                70,
                6,
                new Vector2(-25, 15),
                new Vector2(MyGdxGame.width + 5, MyGdxGame.height - 25),
                1,
                14,
                80
        );
        this.aScenarioVector2.add(cb);
    }
}
