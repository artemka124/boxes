package com.lisuart.falldown.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.lisuart.falldown.Config.Progress;
import com.lisuart.falldown.Model.LevelLayout.LevelGenerator;
import com.lisuart.falldown.Model.LevelLayout.TopPanel;
import com.lisuart.falldown.ModelGenerator.Background;
import com.lisuart.falldown.Config.Tex;
import com.lisuart.falldown.Model.LevelLayout.BackIcon;
import com.lisuart.falldown.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class LevelsLayout implements LayoutInterface {
    Background background;
    BackIcon backIcon;
    TopPanel topPanel;
    LevelGenerator levelGenerator;
    static Sprite arrow;

    int levelsCount;

    int level;

    static  BitmapFont font;

    static float xd;
    static float yd;

    int successCount = 0;

    public LevelsLayout() {
        background = new Background();
        backIcon = new BackIcon();
        topPanel = new TopPanel();
        this.level = (int)((((Progress.getNextLevelInt() - 1) / 12)) * 12) + 1;
        levelGenerator = new LevelGenerator(level);
        levelsCount = Progress.levels.length;
        MyGdxGame.setUp(15, false);

        for (int i = 0; i < Progress.levels.length; i ++) {
            if (Progress.levels[i] == 1) {
                successCount++;
            }
        }

        font = Tex.smallFont35;
    }

    public void setLevel(int level) {
        this.level = (int)((((Progress.getNextLevelInt() - 1) / 12)) * 12) + 1;
        levelGenerator.setLevel(this.level);
    }

    public static void init() {
        arrow = new Sprite(new Texture("menu/backIcon.png"));
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.height;
    }

    @Override
    public void act(float delta) {
        background.act();
        backIcon.act();
        topPanel.act();
        levelGenerator.act();

        if (Gdx.input.justTouched()) {
            Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (level > 12) {
                if (vector3.x > 5 && vector3.x < 13) {
                    if (vector3.y > 9 && vector3.y < 17) {
                        this.level -= 12;
                        this.levelGenerator.setLevel(this.level);
                    }
                }
            }
            if (level + 12 <= levelsCount) {
                if (vector3.x > MyGdxGame.width - 6 - 5 && vector3.x < MyGdxGame.width - 6 + 7) {
                    if (vector3.y > 9 && vector3.y < 17) {
                        this.level += 12;
                        this.levelGenerator.setLevel(this.level);
                    }
                }
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        background.render(MyGdxGame.batchDynamic);
        topPanel.render(MyGdxGame.batchDynamic);
        MyGdxGame.batchDynamic.end();
        MyGdxGame.batchFont.begin();
        font.draw(MyGdxGame.batchFont, successCount + "/" + Progress.levels.length, 0, Gdx.graphics.getHeight() - 18 * Tex.y, Gdx.graphics.getWidth(), 1, true);
        MyGdxGame.batchFont.end();
        MyGdxGame.batchDynamic.begin();
        levelGenerator.render(MyGdxGame.batchDynamic);
        backIcon.render(MyGdxGame.batchDynamic);
        if (level > 12) {
            MyGdxGame.batchDynamic.draw(arrow, 0 + 6, 10, 6, 6);
        }
        if (level + 12 <= levelsCount) {
            MyGdxGame.batchDynamic.draw(
                    arrow,
                    MyGdxGame.width - 6 - 6,
                    10,
                    3,
                    3,
                    6,
                    6,
                    arrow.getScaleX(),
                    arrow.getScaleY(),
                    180
            );
        }
        MyGdxGame.batchDynamic.end();
        batch.begin();
    }

    @Override
    public void dispose() {
        backIcon.dispose();
        topPanel.dispose();
        levelGenerator.dispose();
        background.dispose();
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
