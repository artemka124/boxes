package com.lisuart.falldown.Model.Setting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.lisuart.falldown.Config.Progress;
import com.lisuart.falldown.MyGdxGame;

/**
 * Created by User on 21.04.2018.
 */

public class SettingButtonB {
    boolean isReady = false;
    public boolean isPressed = false;
    int timeSetting = 0;
    int timePressed = timeSetting;
    Sprite button;
    Sprite buttonPressed;
    Sprite icon;
    Vector2 size = new Vector2(17, 17);
    float xd;
    float yd;

    Vector2 position = new Vector2(MyGdxGame.width/2 - 10,  MyGdxGame.height/2 - size.y / 2 + 10);

    public SettingButtonB() {
        button = new Sprite(new Texture("menu/onCircle.png"));
        buttonPressed = new Sprite(new Texture("menu/offCircle.png"));
        icon = new Sprite(new Texture("music.png"));
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width;
    }

    public void act() {
        if (isPressed) {
            timePressed--;
            if (timePressed <= 1) {
                Progress.setMusic(!Progress.music);
                if (Progress.music) {
                    com.lisuart.falldown.Model.Music.Music.music();
                } else {
                    com.lisuart.falldown.Model.Music.Music.stopMusic();
                }
                isPressed = false;
                timePressed = timeSetting;
            }
        } else {
            if (Gdx.input.justTouched()) {
                Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > position.x - size.x/2 && vector3.x < position.x + size.x/2) {
                    if (vector3.y > position.y - size.y/2 && vector3.y < position.y + size.y/2) {
                        isPressed = true;
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                Progress.music ? button : buttonPressed,
                position.x - size.x/2,
                position.y - size.y/2,
                size.x,
                size.y
        );
        batch.draw(icon, position.x - size.x/2 + 3.5f, position.y - size.y/2 + 4, size.x - 8, size.y - 8);
        batch.end();
        batch.begin();
    }

    public boolean isReady() {
        return isReady;
    }

    public void dispose() {
        button.getTexture().dispose();
        buttonPressed.getTexture().dispose();
        icon.getTexture().dispose();
    }
}
