package com.lisuart.falldown.Model.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by User on 22.04.2018.
 */

public class PauseIcon {
    boolean isReady = false;
    public boolean isPressed = false;
    int timeSetting = 5;
    int timePressed = timeSetting;
    Vector2 size = new Vector2(4, 4);
    Vector2 position = new Vector2(2, com.lisuart.falldown.MyGdxGame.height - 2 - size.y);
    static Sprite button;
    int level;

    public PauseIcon(int level) {
        this.level = level;
    }

    public static void init() {
        button = new Sprite(new Texture("pause.png"));
    }

    public void act() {
        if (isPressed) {
            timePressed--;
            if (timePressed <= 0) {
                com.lisuart.falldown.MyGdxGame.layoutManager.push(new com.lisuart.falldown.Layout.PauseLayout(level));
                isReady = false;
                isPressed = false;
                timePressed = timeSetting;
            }
        } else {
            if (Gdx.input.justTouched()) {
                Vector3 vector3 = com.lisuart.falldown.MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > position.x - size.x && vector3.x < position.x + size.x) {
                    if (vector3.y > position.y - size.y && vector3.y < position.y + size.y) {
                        isPressed = true;
                        com.lisuart.falldown.MyGdxGame.setUp(5, true);
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(this.button, position.x, position.y, size.x, size.y);
    }

    public void dispose() {

    }
}
