package com.siminenko.artem.Model.Level.Scenarious.Level6;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.AScenario;
import com.siminenko.artem.Model.Level.TutorialSprite;
import com.siminenko.artem.Model.Player;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class TutorialBomb extends AScenario {
    Sprite plus;
    Sprite oclock;
    Sprite equal;
    Sprite explode;
    Sprite shadow;

    TutorialSprite tbomb;
    TutorialSprite tplus;
    TutorialSprite ttime;
    TutorialSprite tequal;
    TutorialSprite texplode;


    public TutorialBomb(World world, Player player, ALevel level, int delay) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.doDelay = 180;

        plus = new Sprite(new Texture("tutorial/plus.png"));
        equal = new Sprite(new Texture("tutorial/equal.png"));
        shadow = new Sprite(new Texture("menu/bgshadow.png"));
        oclock = new Sprite(new Texture("oclock.png"));
        explode = new Sprite(new Texture("explosion.png"));

        tbomb = new TutorialSprite(Tex.circleBomb, new Vector2(1.5f, 49.5f), new Vector2(8, 8));
        tplus = new TutorialSprite(plus, new Vector2(12, 52), new Vector2(3, 3));
        ttime = new TutorialSprite(oclock, new Vector2(18f, 50), new Vector2(7, 7));
        tequal = new TutorialSprite(equal, new Vector2(28f, 52f), new Vector2(3, 3));
        texplode = new TutorialSprite(explode, new Vector2(35, 50f), new Vector2(7, 7));
    }

    @Override
    public void act() {
        super.act();
        tbomb.act();
        ttime.act();
        tequal.act();
        texplode.act();
        tplus.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(shadow, -5, 48, MyGdxGame.width + 10, 11);
        tbomb.render(batch);
        ttime.render(batch);
        tequal.render(batch);
        texplode.render(batch);
        tplus.render(batch);
    }

    @Override
    public void action() {
        isDead = true;
    }
}