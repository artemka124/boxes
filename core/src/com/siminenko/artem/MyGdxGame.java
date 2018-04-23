package com.siminenko.artem;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Layout.LayoutManager;
import com.siminenko.artem.Layout.LostLayout;
import com.siminenko.artem.Layout.MenuLayout;
import com.siminenko.artem.Layout.WinLayout;
import com.siminenko.artem.Model.Lost.FailedText;
import com.siminenko.artem.Model.Lost.MenuIcon;
import com.siminenko.artem.Model.Lost.RestartText;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.artem.Model.Win.CompletedText;
import com.siminenko.artem.Model.Win.NextLevelText;

public class MyGdxGame extends ApplicationAdapter {
    public static SpriteBatch batch;
    public static SpriteBatch batchDynamic;
    public static SpriteBatch batchFont;
    public static OrthographicCamera camera;
    public static LayoutManager layoutManager;
    public static int width;
    public static int height;
    public static Tex tex;
    public static Progress progress;

    @Override
    public void create() {
        tex = new Tex();
        progress = new Progress();
        width = 45;
        height = 80;
        camera = new OrthographicCamera(width, height);
        camera.position.x = width / 2;
        camera.position.y = height / 2;
        batch = new SpriteBatch();
        batchDynamic = new SpriteBatch();
        batchFont = new SpriteBatch();


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

        layoutManager = new LayoutManager();
        layoutManager.push(new MenuLayout());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batchDynamic.setProjectionMatrix(camera.combined);
        batch.begin();
        layoutManager.render(batch);
        batch.end();
        layoutManager.act(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        layoutManager.dispose();
    }
}
