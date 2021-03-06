package com.lisuart.falldown.Model.Level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Config.Progress;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.AObject;
import com.lisuart.falldown.Model.Game.Particles;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBonusCoin;
import com.lisuart.falldown.Model.Player;
import com.lisuart.falldown.Model.Powers.APower;
import com.lisuart.falldown.Model.Powers.PowerClock;
import com.lisuart.falldown.Model.Powers.PowerShield;

import java.util.Random;
import java.util.Vector;

/**
 * Created by User on 22.04.2018.
 */

public abstract class ALevel {
    public Player player;
    public Vector<AScenario> aScenarioVector2 = new Vector<AScenario>();
    public Vector<AObject> aObjectVector2 = new Vector<AObject>();
    public Vector<APower> aPowerVector = new Vector<APower>();
    public int level;
    com.lisuart.falldown.Model.Game.ProgressBar bar;
    Particles particles;
    public int blockTime;
    public int clockTime;

    public boolean newVictory = false;

    public boolean hasBlockPower = false;
    public boolean hasTimePower = false;

    public abstract void init();

    public void afterInit() {
        this.bar = new com.lisuart.falldown.Model.Game.ProgressBar(this);
        this.particles = new Particles();
        generateCoins();

        if (hasBlockPower) {
            aPowerVector.add(new PowerShield(level, GameLayout.world, blockTime));
        }
        if (hasTimePower) {
            aPowerVector.add(new PowerClock(level, GameLayout.world, clockTime));
        }
        GameLayout.world.setGravity(new Vector2(0, -10f));
    }

    public void generateCoins() {
        if (this.level == 0) {
            return;
        }
        boolean a = true;
        Random random = new Random();
        int chance = (int) (this.aScenarioVector2.size() * 1.5);
        if (chance > 70) {
            chance = 70;
        }

        while (a) {
            int result = random.nextInt(100);
            if (result <= chance) {
                this.aScenarioVector2.add(
                        random.nextInt(this.aScenarioVector2.size()),
                        new SimpleBonusCoin(
                                GameLayout.world,
                                player,
                                this,
                                0,
                                new Vector2(random.nextInt(com.lisuart.falldown.MyGdxGame.width - 20) + 10, com.lisuart.falldown.MyGdxGame.height + 5),
                                random.nextInt(5)
                        ));
            } else {
                a = false;
            }
        }
    }

    public void act() {
        particles.act();
        if (aScenarioVector2.size() > 0) {
            aScenarioVector2.firstElement().act();
            if (aScenarioVector2.firstElement().doDelay <= 0) {
                aScenarioVector2.firstElement().action();
                if (aScenarioVector2.firstElement().isDead) {
                    aScenarioVector2.remove(aScenarioVector2.firstElement());
                    if (aScenarioVector2.size() > 0 && aScenarioVector2.firstElement().doDelay <= 0) {
                        aScenarioVector2.firstElement().action();
                        if (aScenarioVector2.firstElement().isDead) {
                            aScenarioVector2.remove(aScenarioVector2.firstElement());
                        }
                    }
                }
            }
        }
        for (int i = 0; i < aObjectVector2.size(); i++) {
            aObjectVector2.get(i).act();
        }
        for (int i = 0; i < aPowerVector.size(); i++) {
            aPowerVector.get(i).act();
        }
        for (int i = aObjectVector2.size() - 1; i >= 0; i--) {
            if (aObjectVector2.get(i).getDispose()) {
                aObjectVector2.get(i).dispose();
                aObjectVector2.remove(i);
            }
        }
    }

    public void afterWin() {
        if (Progress.levels[this.level - 1] == 0) {
            Progress.addDiamond();
            Progress.addDiamond();
            Progress.addDiamond();
            Progress.addDiamond();
            Progress.addDiamond();
            this.newVictory = true;
        }
        Progress.saveLevelProgress(this.level);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void render(SpriteBatch b) {
        if (aScenarioVector2.size() > 0) {
            aScenarioVector2.firstElement().render(b);
        }
        for (int i = 0; i < aObjectVector2.size(); i++) {
            aObjectVector2.get(i).render(b);
        }
        for (int i = 0; i < aPowerVector.size(); i++) {
            aPowerVector.get(i).render(b);
        }
        bar.render(b);
    }

    public void renderBG(SpriteBatch batch) {
        particles.render(batch);

    }

    public void dispose() {
        for (int i = 0; i < aScenarioVector2.size(); i++) {
            aScenarioVector2.get(i).dispose();
        }
        for (int i = 0; i < aObjectVector2.size(); i++) {
            aObjectVector2.get(i).dispose();
        }
    }

    public int kinematicCount() {
        int kinematicCount = 0;
        for (int i = this.aObjectVector2.size() - 1; i >= 0; i--) {
            if (this.aObjectVector2.get(i).isKinematic) {
                kinematicCount++;
            }
        }

        return kinematicCount;
    }

    public boolean isComplete() {
        int kinematicCount = this.kinematicCount();
        boolean result = this.aScenarioVector2.size() == 0 && (this.aObjectVector2.size() == 0 || kinematicCount == this.aObjectVector2.size());
        if (result) {
            afterWin();
        }
        return result;
    }

    public void setNumber(int level) {
        this.level = level;
    }
}
