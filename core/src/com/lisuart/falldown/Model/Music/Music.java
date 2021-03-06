package com.lisuart.falldown.Model.Music;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.lisuart.falldown.Config.Progress;

import java.util.Random;

/**
 * Created by artem on 7/9/18.
 */

public class Music {
    static Sound touch1;
    static Sound touch2;
    static Sound touch3;
    static Sound win;
    static Sound lost;
    static Sound coin;
    static Sound start;
    static Sound big;
    static Sound boom;
    public static Sound music;
    public static Sound gameMusic;

    public static long id = -1;
    public static long gameId = -1;

    public static boolean isPlay = true;
    public static boolean isPlayGame = false;

    static float volume = 0;
    static float volumeGame = 0;
    static float max = 1f;

    static int iteration = 0;


    public static void init() {
        touch1 = Gdx.audio.newSound(Gdx.files.internal("music/touch1.ogg"));
        touch2 = Gdx.audio.newSound(Gdx.files.internal("music/touch2.ogg"));
        touch3 = Gdx.audio.newSound(Gdx.files.internal("music/touch3.ogg"));
        win = Gdx.audio.newSound(Gdx.files.internal("music/win.ogg"));
        coin = Gdx.audio.newSound(Gdx.files.internal("music/coin.ogg"));
        big = Gdx.audio.newSound(Gdx.files.internal("music/big.ogg"));
        lost = Gdx.audio.newSound(Gdx.files.internal("music/lost.ogg"));
        music = Gdx.audio.newSound(Gdx.files.internal("music/music.ogg"));
        gameMusic = Gdx.audio.newSound(Gdx.files.internal("music/gameMusic.ogg"));
        start = Gdx.audio.newSound(Gdx.files.internal("music/start.ogg"));
        boom = Gdx.audio.newSound(Gdx.files.internal("music/boom.ogg"));
    }

    public static void touch() {
        if (Progress.sound) {
            Random random = new Random();
            int result = random.nextInt(3);
            if (result == 0) {
                touch1.play(0.6f);
            } else if (result == 1) {
                touch2.play(0.6f);
            } else if (result == 2) {
                touch3.play(0.6f);
            }
        }
    }

    public static void start() {
        if (Progress.sound) {
            start.play();
        }
    }

    public static void boom() {
        if (Progress.sound) {
            boom.play(0.5f);
        }
    }

    public static void win() {
        if (Progress.sound) {
            win.play();
        }
    }

    public static void big() {
        if (Progress.sound) {
            big.play();
        }
    }

    public static void coin() {
        if (Progress.sound) {
            coin.play();
        }
    }

    public static void lost() {
        if (Progress.sound) {
            lost.play();
        }
    }

    public static void music() {
        if (Progress.music) {
            isPlay = true;
        }
    }

    public static void musicGame() {
        if (Progress.music) {
            isPlayGame = true;
        }
    }

    public static void act() {
        if (iteration < 30) {
            iteration++;
        } else if (iteration == 30) {
            iteration++;
            id = music.loop(0);
            gameId = gameMusic.loop(0);
        }
        if (iteration > 30) {
            if (isPlay) {
                if (volume < max) {
                    volume += 0.0035f;
                    if (Progress.music) {
                        music.setVolume(id, volume);
                    }
                }
            } else {
                if (volume > 0) {
                    volume -= 0.01f;
                    music.setVolume(id, volume);
                }
            }

            if (isPlayGame) {
                if (volumeGame < 0.2f) {
                    volumeGame += 0.001f;
                    if (Progress.music) {
                        gameMusic.setVolume(gameId, volumeGame);
                    }
                }
            } else {
                if (volumeGame > 0) {
                    volumeGame -= 0.01f;
                    gameMusic.setVolume(gameId, volumeGame);
                }
            }
        }
    }

    public static void stopMusic() {
        if (Progress.music) {
            isPlay = false;
        }
    }

    public static void stopMusicGame() {
        if (Progress.music) {
            isPlayGame = false;
        }
    }
}
