package com.siminenko.artem.Model.Pause;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 21.04.2018.
 */

public class ContinueButton {
    boolean isReady = false;
    boolean isPressed = false;
    int timeSetting = 20;
    int timePressed = timeSetting;
    static Sprite button;
    static Sprite buttonPressed;
    Vector2 size;
    static BitmapFont font;

    static float xd;
    static float yd;

    public ContinueButton() {
        size = new Vector2(22, 6.5f);
    }

    public static void init() {
        button = new Sprite(new Texture("menu/playButton.png"));
        buttonPressed = new Sprite(new Texture("menu/playButtonPressed.png"));
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width;
        font = Tex.generateFont(Color.WHITE, (int) (3.0f * xd), "smallfont.ttf");
    }

    public void act() {
        if (isPressed) {
            timePressed--;
            if (timePressed <= 1) {
                MyGdxGame.layoutManager.pop();
            }
        } else {
            if (Gdx.input.justTouched()) {
                Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > MyGdxGame.width / 2 - size.x / 2 && vector3.x < MyGdxGame.width / 2 + size.x / 2) {
                    if (vector3.y > MyGdxGame.height / 2 - 7 - size.y / 2 && vector3.y < MyGdxGame.height / 2 - 7 + size.y / 2) {
                        isPressed = true;
                        MyGdxGame.setUp(20, true);
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                !isPressed ? button : buttonPressed,
                MyGdxGame.width / 2 - size.x / 2,
                MyGdxGame.height / 2 - 7 - size.y / 2,
                size.x,
                size.y
        );
        batch.end();
        MyGdxGame.batchFont.begin();
        font.draw(
                MyGdxGame.batchFont,
                "CONTINUE",
                Tex.x * 327,
                Tex.y * 204
        );
        MyGdxGame.batchFont.end();
        batch.begin();
    }

    public boolean isReady() {
        return isReady;
    }

    public void dispose() {
        button.getTexture().dispose();
        font.dispose();
    }
}
