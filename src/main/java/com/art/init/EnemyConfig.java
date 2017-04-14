package com.art.init;

import com.art.character.Enemies.Enemy;
import com.art.character.Enemies.Barrens.*;
import com.art.character.Enemies.Boneyard.*;
import com.art.character.Enemies.FrozenHIlls.*;
import com.art.character.Enemies.Woodland.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EnemyConfig {

    @Bean(name = "Cultist")
    @Scope(value = "prototype")
    public Enemy cultist() {

        Enemy cultist = new Cultist("Cultist", 1, 7, 7, 12, 5);
        cultist.calculatedStats();
        return cultist;

    }

    @Bean(name="Demon")
    @Scope(value = "prototype")
    public Enemy demon() {
        Demon demon = new Demon("Demon", 1, 7, 7, 12, 5);
        demon.calculatedStats();
        return demon;
    }

    @Bean(name="Mummy")
    @Scope(value = "prototype")
    public Enemy mummy() {
        Enemy mummy = new Mummy("Mummy", 1, 7, 7, 12, 5);
        mummy.calculatedStats();
        return mummy;
    }

    @Bean(name="Scorpion")
    @Scope(value = "prototype")
    public Enemy scorpion() {
        Enemy scorpion = new Scorpion("Scorpion", 1, 7, 7, 12, 5);
        scorpion.calculatedStats();
        return scorpion;
    }

    @Bean(name = "Ghost")
    @Scope(value = "prototype")
    public Enemy ghost() {
        Enemy enemy = new Ghost("Ghost", 1, 7, 7, 12, 5);
        enemy.calculatedStats();
        return enemy;
    }

    @Bean(name = "Ghoul")
    @Scope(value = "prototype")
    public Enemy ghoul() {
        Enemy ghoul = new Ghoul("Ghoul", 1, 7, 7, 12, 5);
        ghoul.calculatedStats();
        return ghoul;
    }

    @Bean(name = "Necromancer")
    @Scope(value = "prototype")
    public Enemy necromancer() {
        Enemy necromancer = new Necromancer("Necromancer", 1, 7, 7, 12, 5);
        necromancer.calculatedStats();
        return necromancer;
    }

    @Bean(name = "Skeleton")
    @Scope(value = "prototype")
    public Enemy skeleton() {
        Enemy skeleton = new Skeleton("Skeleton", 1, 7, 7, 12, 5);
        skeleton.calculatedStats();
        return skeleton;

    }

    @Bean(name = "Dragon")
    @Scope(value = "prototype")
    public Enemy dragon() {
        Enemy dragon = new Dragon("Dragon", 1, 7, 7, 12, 5);
        dragon.calculatedStats();
        return dragon;
    }

    @Bean(name = "FrozenArmor")
    @Scope(value = "prototype")
    public Enemy frozenArmor() {
        Enemy frozenArmor = new FrozenArmor("FrozenArmor", 1, 7, 7, 12, 5);
        frozenArmor.calculatedStats();
        return frozenArmor;
    }

    @Bean(name = "KillerSnowMan")
    @Scope(value = "prototype")
    public Enemy killerSnowMan() {
        Enemy killerSnowMan = new KillerSnowMan("KillerSnowMan", 1, 7, 7, 12, 5);
        killerSnowMan.calculatedStats();
        return killerSnowMan;
    }

    @Bean(name = "Sabletooth")
    @Scope(value = "prototype")
    public Enemy sabletooth() {
        Enemy sabletooth = new Sabletooth("Sabletooth", 1, 7, 7, 12, 5);
        sabletooth.calculatedStats();
        return sabletooth;
    }

    @Bean(name="Bear")
    @Scope(value = "prototype")
    public Enemy bear() {
        Enemy bear = new Bear("Bear", 1, 7, 7, 12, 5);
        bear.calculatedStats();
        return bear;
    }

    @Bean(name = "Wolf")
    @Scope(value = "prototype")
    public Enemy wolf() {
        Enemy wolf = new Wolf("Wolf", 1, 7, 7, 12, 5);
        wolf.calculatedStats();
        return wolf;
    }

    @Bean(name = "Marauder")
    @Scope(value = "prototype")
    public Enemy marauder() {
        Enemy marauder = new Marauder("Marauder", 1, 7, 7, 12, 5);
        marauder.calculatedStats();
        return marauder;
    }

}
