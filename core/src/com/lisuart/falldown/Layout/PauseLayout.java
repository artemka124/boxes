package com.lisuart.falldown.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.Model.Lost.MenuIcon;
import com.lisuart.falldown.Model.Menu.DiamondDisplay;
import com.lisuart.falldown.Model.Menu.LevelText;
import com.lisuart.falldown.Model.Menu.ModelPickerModels.ModelPicker;
import com.lisuart.falldown.Model.Music.Music;
import com.lisuart.falldown.Model.Pause.ContinueButton;
import com.lisuart.falldown.Model.Pause.PausedText;
import com.lisuart.falldown.ModelGenerator.BackgroundCircle;
import com.lisuart.falldown.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class PauseLayout implements LayoutInterface {
    BackgroundCircle backgroundCircle;
    ModelPicker modelPicker;
    MenuIcon menuIcon;
    ContinueButton continueButton;
    PausedText pausedText;
    LevelText levelText;
    DiamondDisplay diamondDisplay;

    int level;

    public PauseLayout(int level) {
        backgroundCircle = new BackgroundCircle(1);
        modelPicker = new ModelPicker();
        menuIcon = new MenuIcon();
        menuIcon.disposeAll = true;
        pausedText = new PausedText();
        continueButton = new ContinueButton();
        diamondDisplay = new DiamondDisplay();
        this.level = level;
        levelText = new LevelText(level, Color.DARK_GRAY);
        MyGdxGame.setUp(15, false);
        Music.music();
        Music.stopMusicGame();


    }

    public static void init() {

    }

    @Override
    public void act(float delta) {
        backgroundCircle.act();
        modelPicker.act();
        menuIcon.act();
        continueButton.act();
        pausedText.act();
        diamondDisplay.act();
        levelText.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        backgroundCircle.render(MyGdxGame.batchDynamic);
        modelPicker.render(MyGdxGame.batchDynamic);
        pausedText.render(MyGdxGame.batchDynamic);
        levelText.render(MyGdxGame.batchDynamic);
        menuIcon.render(MyGdxGame.batchDynamic);
        continueButton.render(MyGdxGame.batchDynamic);
        diamondDisplay.render(MyGdxGame.batchDynamic);
        MyGdxGame.batchDynamic.end();
        batch.begin();
    }

    @Override
    public void dispose() {
        backgroundCircle.dispose();
        modelPicker.dispose();
        pausedText.dispose();
        levelText.dispose();
        menuIcon.dispose();
        continueButton.dispose();
        diamondDisplay.dispose();

        Music.stopMusic();
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
