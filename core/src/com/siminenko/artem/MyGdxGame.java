package com.siminenko.artem;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.AdMob.AdsController;
import com.siminenko.artem.AdMob.RewardAds;
import com.siminenko.artem.AdMob.VideoEventListener;
import com.siminenko.artem.Config.Info;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Layout.LayoutManager;
import com.siminenko.artem.Layout.LevelsLayout;
import com.siminenko.artem.Layout.LostLayout;
import com.siminenko.artem.Layout.MenuLayout;
import com.siminenko.artem.Layout.PauseLayout;
import com.siminenko.artem.Layout.RateLayout;
import com.siminenko.artem.Layout.SettingLayout;
import com.siminenko.artem.Layout.WinLayout;
import com.siminenko.artem.Model.Game.PauseIcon;
import com.siminenko.artem.Model.Level.Levels.Level1;
import com.siminenko.artem.Model.Level.Levels.Level19;
import com.siminenko.artem.Model.Level.Levels.LevelLoop;
import com.siminenko.artem.Model.LevelLayout.BackIcon;
import com.siminenko.artem.Model.LevelLayout.LevelGenerator;
import com.siminenko.artem.Model.LevelLayout.TopPanel;
import com.siminenko.artem.Model.Lost.AdText;
import com.siminenko.artem.Model.Lost.FailedText;
import com.siminenko.artem.Model.Lost.MenuIcon;
import com.siminenko.artem.Model.Lost.RestartText;
import com.siminenko.artem.Model.Menu.DiamondDisplay;
import com.siminenko.artem.Model.Menu.LevelText;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.artem.Model.Music.Music;
import com.siminenko.artem.Model.Pause.ContinueButton;
import com.siminenko.artem.Model.Pause.PausedText;
import com.siminenko.artem.Model.Win.CompletedText;
import com.siminenko.artem.Model.Win.NextLevelText;
import com.siminenko.artem.Model.Win.PlusDiamondText;

public class MyGdxGame extends ApplicationAdapter implements VideoEventListener {
    public static SpriteBatch batch;
    public static SpriteBatch batchDynamic;
    public static SpriteBatch batchFont;
    public static OrthographicCamera camera;
    public static LayoutManager layoutManager;
    public static int width;
    public static int height;
    public static Tex tex;
    public static Progress progress;
    public static Info info;

    Sprite whitebg;
    static int time;
    static int timeSetting;
    static boolean isUp = false;

    int rateL = 10;

    static int timeLoad = 0;

    public static AdsController adsController;

    public static RewardAds rewardAds;

    public MyGdxGame(AdsController adsController, RewardAds rewardAds)
    {
        this.adsController = adsController;
        this.rewardAds = rewardAds;
        this.rewardAds.setVideoEventListener(this);
    }

    @Override
    public void create() {
        width = 45;
        height = 80;
        batch = new SpriteBatch();
        batchFont = new SpriteBatch();
        layoutManager = new LayoutManager();
        Music.init();
        Tex.initLoading();
    }

    public void init() {
        tex = new Tex();

        progress = new Progress();
        camera = new OrthographicCamera(width, height);
        camera.position.x = width / 2;
        camera.position.y = height / 2;
        batch = new SpriteBatch();
        batchDynamic = new SpriteBatch();

        whitebg = new Sprite(new Texture("menu/whitebg.png"));
        progress.init();
        FailedText.init();
        MenuIcon.init();
        MenuLayout.init();
        LostLayout.init();
        RestartText.init();
        ModelPicker.init();
        GameLayout.init();
        CompletedText.init();
        NextLevelText.init();
        WinLayout.init();
        LevelText.init();
        LevelsLayout.init();
        TopPanel.init();
        BackIcon.init();
        LevelGenerator.init();
        PauseLayout.init();
        PauseIcon.init();
        PausedText.init();
        ContinueButton.init();
        RateLayout.init();
        Info.init();
        LevelLoop.initStatic();
        DiamondDisplay.init();
        PlusDiamondText.init();
        SettingLayout.init();

        Info.addRunNumber();

        layoutManager.push(new MenuLayout());
        Gdx.input.setCatchBackKey(true);
    }

    public static void setUp(int time, boolean isUp) {
        MyGdxGame.isUp = isUp;
        MyGdxGame.time = time;
        MyGdxGame.timeSetting = time;
    }

    @Override
    public void render() {
        if (timeLoad == 0) {
            Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            timeLoad++;
            batchFont.begin();
            Tex.loadingFont.getData().setScale(0.8f, 0.8f);
            Tex.loadingFont.draw(batchFont, "LuSiArt", 0, Gdx.graphics.getHeight()/1.3f, Gdx.graphics.getWidth(), 1, true);
            Tex.loadingFont.getData().setScale(0.2f, 0.2f);
            Tex.loadingFont.draw(batchFont, "gaming", 0, Gdx.graphics.getHeight()/1.55f, Gdx.graphics.getWidth(), 1, true);
            Tex.loadingFont.getData().setScale(1, 1);
            Tex.loadingFont.getData().setScale(0.4f, 0.4f);
            Tex.loadingFont.draw(batchFont, "loading", 0, Gdx.graphics.getHeight()/5f, Gdx.graphics.getWidth(), 1, true);
            Tex.loadingFont.getData().setScale(1, 1);
            batchFont.end();
            return;
        } else if (timeLoad == 1) {
            init();
            timeLoad++;
        }

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isKeyJustPressed(Input.Keys.BACK)) {
            if (layoutManager.vector.lastElement() instanceof GameLayout) {
                layoutManager.push(new PauseLayout(GameLayout.level.level));
            }
        }
        Music.act();
        camera.update();
        time--;

        batch.setProjectionMatrix(camera.combined);
        batchDynamic.setProjectionMatrix(camera.combined);
        batch.begin();
        layoutManager.render(batch);
        batch.end();
        layoutManager.act(Gdx.graphics.getDeltaTime());
        batchDynamic.begin();
        if (time > 0) {
            if (isUp) {
                batchDynamic.setColor(1, 1, 1, 1f - (float) time / (float) timeSetting);
            } else {
                batchDynamic.setColor(1, 1, 1, (float) time / (float) timeSetting);
            }
            batchDynamic.draw(whitebg, -5, -5, width + 10, height + 10);
        }
        batchDynamic.end();
        batchDynamic.setColor(batchDynamic.getColor().r, batchDynamic.getColor().g, batchDynamic.getColor().b, 1);

        if (Info.needRateLayout()) {
            rateL--;
            if (rateL == 0 && layoutManager.vector.size() == 1) {
                layoutManager.push(new RateLayout());
            }
        }
    }

    @Override
    public void pause() {
        super.pause();
        if (MyGdxGame.layoutManager == null) {
            return;
        }
        if (MyGdxGame.layoutManager.vector.lastElement() instanceof GameLayout) {
            MyGdxGame.layoutManager.push(new PauseLayout(GameLayout.level.level));
        }
    }

    @Override
    public void dispose() {
        layoutManager.dispose();
    }

    @Override
    public void resume() {
        super.resume();
        tex = new Tex();
    }

    @Override
    public void onRewardedEvent(String type, int amount) {
        AdText.isViewed = true;
    }

    @Override
    public void onRewardedVideoAdLoadedEvent() {

    }

    @Override
    public void onRewardedVideoAdClosedEvent() {

    }
}
