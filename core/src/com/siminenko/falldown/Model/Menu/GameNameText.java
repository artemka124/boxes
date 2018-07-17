package com.siminenko.falldown.Model.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.falldown.Config.Tex;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class GameNameText {
    Vector2 positionFirst = new Vector2(-300f / (Gdx.graphics.getWidth() / MyGdxGame.width), Gdx.graphics.getHeight() / 1.22f);
    Vector2 positionSecond = new Vector2(300f / (Gdx.graphics.getWidth() / MyGdxGame.width), Gdx.graphics.getHeight() / 1.34f);

    float a = 0;
    float da = 0.07f;

    float b = 0.5f;
    float db = 0.03f;

    public GameNameText() {

    }

    public void act() {
        a += da;
        b += db;
        positionFirst.add((float) Math.cos(a) / 3, (float) Math.cos(b) / 4);
        positionSecond.add(-(float) Math.cos(a) / 3, (float) Math.cos(b) / 4);
    }

    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchFont.begin();
        Tex.loadingFont.setColor(Color.BLACK);
        Tex.loadingFont.getData().setScale(0.8f, 0.8f);
        Tex.loadingFont.draw(MyGdxGame.batchFont, "FALL", positionFirst.x, positionFirst.y, Gdx.graphics.getWidth(), 1, true);
        Tex.loadingFont.draw(MyGdxGame.batchFont, "DOWN", positionSecond.x, positionSecond.y, Gdx.graphics.getWidth(), 1, true);
        Tex.loadingFont.getData().setScale(1, 1);
        Tex.loadingFont.setColor(Color.BLACK);

        MyGdxGame.batchFont.end();
        batch.begin();
    }
}