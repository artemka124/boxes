package com.siminenko.artem.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Model.LevelLayout.BackIcon;
import com.siminenko.artem.Model.LevelLayout.LevelGenerator;
import com.siminenko.artem.Model.LevelLayout.TopPanel;
import com.siminenko.artem.Model.Lost.MenuIcon;
import com.siminenko.artem.Model.Menu.LevelText;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.artem.Model.Win.CompletedText;
import com.siminenko.artem.Model.Win.NextLevelText;
import com.siminenko.artem.ModelGenerator.Background;
import com.siminenko.artem.ModelGenerator.BackgroundCircle;
import com.siminenko.artem.MyGdxGame;

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
    static BitmapFont font1;

    static float xd;
    static float yd;

    public LevelsLayout() {
        background = new Background();
        backIcon = new BackIcon();
        topPanel = new TopPanel();
        this.level = (int)((((Progress.getNextLevelInt() - 1) / 12)) * 12) + 1;
        levelGenerator = new LevelGenerator(level);
        levelsCount = Progress.levels.length;
        System.out.println(levelsCount);
        MyGdxGame.setUp(15, false);

    }

    public void setLevel(int level) {
        this.level = (int)((((Progress.getNextLevelInt() - 1) / 12)) * 12) + 1;
        levelGenerator.setLevel(this.level);
    }

    public static void init() {
        arrow = new Sprite(new Texture("menu/backIcon.png"));
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.height;
        font = Tex.generateFont(Color.ORANGE, (int) (3.5f * xd), "bigfont.ttf");
        font1 = Tex.generateFont(Color.WHITE, (int) (3.5f * xd), "bigfont.ttf");
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
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
