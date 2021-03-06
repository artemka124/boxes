package com.lisuart.falldown.Model.Lost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class FailedText {
    static BitmapFont font;
    static float xd;
    static float yd;
    public boolean record = false;

    String string;

    float a = 0.05f;
    float da = 0.1f;

    float size = 0.7f;

    public FailedText(boolean record) {
        this.record = record;
        string = getText();
        if (record) {
            com.lisuart.falldown.Model.Music.Music.win();

            font.getData().setScale(size, size);
        }
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / com.lisuart.falldown.MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / com.lisuart.falldown.MyGdxGame.width;
        font = com.lisuart.falldown.Config.Tex.failedWinFont;
    }

    public void act() {
        if (this.record) {
            a += da;
            size += Math.sin(a) / 60;
            font.getData().setScale(size, size);
        }
    }

    public void render(SpriteBatch batch) {
        act();
        batch.end();
        com.lisuart.falldown.MyGdxGame.batchFont.begin();
        font.draw(
                com.lisuart.falldown.MyGdxGame.batchFont,
                string,
                0,
                com.lisuart.falldown.Config.Tex.y * 400,
                Gdx.graphics.getWidth(),
                1,
                false
        );
        com.lisuart.falldown.MyGdxGame.batchFont.end();
        batch.begin();
    }

    public String getText() {
        if (record) {
            Random random = new Random();
            int result = random.nextInt(3);
            if (result == 0) {
                return "GOOD JOB!";
            } else if (result == 1) {
                return "new result!";
            } else if (result == 2) {
                return "NEW RECORD";
            }
        }
        Random random = new Random();
        int result = random.nextInt(4);
        if (result == 0) {
            return "FAILED";
        } else if (result == 1) {
            return "OOPS..";
        } else if (result == 2) {
            return "YOU LOST";
        } else {
            return "TRY AGAIN";
        }
    }

    public void dispose() {
    }
}
