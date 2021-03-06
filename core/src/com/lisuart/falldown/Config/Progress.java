package com.lisuart.falldown.Config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.lisuart.falldown.Model.Level.Levels.Level10;
import com.lisuart.falldown.Model.Level.Levels.Level17;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Levels.Level1;
import com.lisuart.falldown.Model.Level.Levels.Level12;
import com.lisuart.falldown.Model.Level.Levels.Level13;
import com.lisuart.falldown.Model.Level.Levels.Level14;
import com.lisuart.falldown.Model.Level.Levels.Level15;
import com.lisuart.falldown.Model.Level.Levels.Level16;
import com.lisuart.falldown.Model.Level.Levels.Level19;
import com.lisuart.falldown.Model.Level.Levels.Level2;
import com.lisuart.falldown.Model.Level.Levels.Level20;
import com.lisuart.falldown.Model.Level.Levels.Level23;
import com.lisuart.falldown.Model.Level.Levels.Level3;
import com.lisuart.falldown.Model.Level.Levels.Level4;
import com.lisuart.falldown.Model.Level.Levels.Level5;
import com.lisuart.falldown.Model.Level.Levels.Level6;
import com.lisuart.falldown.Model.Level.Levels.Level8;
import com.lisuart.falldown.Model.Level.Levels.Level9;
import com.lisuart.falldown.Model.Level.Levels.LevelLoop;

/**
 * Created by User on 22.04.2018.
 */

public class Progress {
    public static final String progress = "progressLevel4";
    public static final String maxScoreSetting = "maxScore8";
    public static final String diamondCount = "diamondCount";
    public static final String musicSetting = "music";
    public static final String soundSetting = "sound";
    public static final String themeSetting = "gameTheme1";
    public static int[] levels = new int[24];
    public static int[] themes = new int[3];
    public static int maxScore = 0;
    public static int diamonds = 0;
    public static int theme = 0;
    public static boolean music = true;
    public static boolean sound = true;

    public void init() {
        Preferences prefs = Gdx.app.getPreferences(progress);
        for (int i = 0; i < levels.length; i++) {
            levels[i] = prefs.getInteger("level" + (i + 1), 0);
        }
        for (int i = 0; i < themes.length; i++) {
            themes[i] = prefs.getInteger("gameTheme1" + (i + 1), 0);
        }
        maxScore = prefs.getInteger(maxScoreSetting, 0);
        diamonds = prefs.getInteger(diamondCount, 0);
        music = prefs.getBoolean(musicSetting, true);
        sound = prefs.getBoolean(soundSetting, true);
        theme = prefs.getInteger(themeSetting, 0);
    }

    public static void purchase(int themek) {
        Preferences prefs = Gdx.app.getPreferences(progress);
        prefs.putInteger("gameTheme1" + themek, 1);
        themes[themek - 1] = 1;
        prefs.flush();
    }

    public static void setTheme(int themek)
    {
        Preferences prefs = Gdx.app.getPreferences(progress);
        theme = themek;
        prefs.putInteger(themeSetting, themek);
        prefs.flush();
    }

    public static void setMusic(boolean a)
    {
        if (!a) {
            com.lisuart.falldown.Model.Music.Music.stopMusic();
        }

        Preferences prefs = Gdx.app.getPreferences(progress);
        music = a;
        prefs.putBoolean(musicSetting, a);
        prefs.flush();

        if (a) {
            com.lisuart.falldown.Model.Music.Music.music();
        }
    }

    public static void setSound(boolean a)
    {
        Preferences prefs = Gdx.app.getPreferences(progress);
        sound = a;
        prefs.putBoolean(soundSetting, a);
        prefs.flush();
    }

    public static int getMaxLevel() {
        return levels.length;
    }

    public static boolean saveScore(int currentScore) {
        Preferences prefs = Gdx.app.getPreferences(progress);
        if (maxScore < currentScore) {
            prefs.putInteger(maxScoreSetting, currentScore);
            maxScore = currentScore;
            prefs.flush();

            return true;
        }

        return false;
    }

    public static void addDiamond() {
        Preferences prefs = Gdx.app.getPreferences(progress);
        diamonds += 1;
        prefs.putInteger(diamondCount, diamonds);
        prefs.flush();
        com.lisuart.falldown.Model.Menu.DiamondDisplay.alpha = 0.7f;
    }

    public static void minusDiamond(int count) {
        Preferences prefs = Gdx.app.getPreferences(progress);
        diamonds -= count;
        prefs.putInteger(diamondCount, diamonds);
        prefs.flush();
    }

    public static int getDiamonds() {
        return diamonds;
    }

    public static void saveLevelProgress(int level) {
        Preferences prefs = Gdx.app.getPreferences(progress);
        prefs.putInteger("level" + level, 1);
        levels[level - 1] = 1;
        prefs.flush();
    }

    public static ALevel getNextLevel() {
        int index = 1;
        for (int i = 0; i < levels.length; i++) {
            if (levels[i] == 1) {
                index = i + 2;
            }
        }

        return getLevelByInt(index);
    }

    public static int getNextLevelInt() {
        int index = 1;
        for (int i = 0; i < levels.length; i++) {
            if (levels[i] == 1) {
                index = i + 2;
            }
        }

        if (index > levels.length) {
            return levels.length;
        }

        return index;
    }

    public static ALevel getLevelByInt(int index) {
        ALevel level = null;

        if (index > levels.length) {
            index = levels.length;
        }

        if (index == 1) {
            level = new Level1();
        } else if (index == 2) {
            level = new Level2();
        } else if (index == 3) {
            level = new Level3();
        } else if (index == 4) {
            level = new Level4();
        } else if (index == 5) {
            level = new Level5();
        } else if (index == 6) {
            level = new Level6();
        } else if (index == 7) {
            level = new com.lisuart.falldown.Model.Level.Levels.Level7();
        } else if (index == 8) {
            level = new Level8();
        } else if (index == 9) {
            level = new Level9();
        } else if (index == 10) {
            level = new Level10();
        } else if (index == 11) {
            level = new com.lisuart.falldown.Model.Level.Levels.Level11();
        } else if (index == 12) {
            level = new Level12();
        } else if (index == 13) {
            level = new Level13();
        } else if (index == 14) {
            level = new Level14();
        } else if (index == 15) {
            level = new Level15();
        } else if (index == 16) {
            level = new Level16();
        } else if (index == 17) {
            level = new Level17();
        } else if (index == 18) {
            level = new com.lisuart.falldown.Model.Level.Levels.Level18();
        } else if (index == 19) {
            level = new Level19();
        } else if (index == 20) {
            level = new Level20();
        } else if (index == 21) {
            level = new com.lisuart.falldown.Model.Level.Levels.Level21();
        } else if (index == 22) {
            level = new com.lisuart.falldown.Model.Level.Levels.Level22();
        } else if (index == 23) {
            level = new Level23();
        } else if (index == 24) {
            level = new com.lisuart.falldown.Model.Level.Levels.Level24();
        } else {
            return new LevelLoop();
        }

        level.setNumber(index);

        return level;
    }
}
