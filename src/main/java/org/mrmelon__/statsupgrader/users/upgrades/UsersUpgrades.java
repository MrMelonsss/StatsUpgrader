package org.mrmelon__.statsupgrader.users.upgrades;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.HashMap;
import java.util.Map;

public class UsersUpgrades {

    private static Map<String,Integer> strength = new HashMap(); // кол-во убийств мобов
    private static Map<String,Integer> speedDiging = new HashMap(); // кол-во вскопанных блоков
    private static Map<String,Integer> slowless = new HashMap(); // Колв-во смертей
    private static Map<String,Integer> speed = new HashMap(); // Игровое время

    public static void giveLevelsEffects(Player playerClass){
        String player = playerClass.getName();
        int strentgthLvl = strength.get(player);
        int speedDigingLvl = speedDiging.get(player);
        int slowlessLvl = slowless.get(player);
        int speedLvl = speed.get(player);

        if (strentgthLvl!=0) playerClass.addPotionEffect(new PotionEffect(PotionType.STRENGTH.getEffectType(),999999999,strentgthLvl-1));
        if (speedDigingLvl!=0) playerClass.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,999999999,speedDigingLvl-1));
        if (slowlessLvl!=0) playerClass.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,999999999,slowlessLvl-1));
        if (speedLvl!=0) playerClass.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,999999999,speedLvl-1));
    }

}
