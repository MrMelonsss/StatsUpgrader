package org.mrmelon__.statsupgrader.users.upgrades;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.mrmelon__.statsupgrader.playerstime.PlayTime;
import org.mrmelon__.statsupgrader.users.UsersStats;

import java.util.HashMap;
import java.util.Map;

public class UsersUpgrades {

    private static Map<String,Integer> strength = new HashMap(); // кол-во убийств мобов
    private static Map<String,Integer> speedDiging = new HashMap(); // кол-во вскопанных блоков
    private static Map<String,Integer> slowless = new HashMap(); // Колв-во смертей
    private static Map<String,Integer> speed = new HashMap(); // Игровое время

    public static void setAllFromStats(Player player){
        setStrengthFromStats(player);
        setSlowlessFromStats(player);
        setSpeedFromStats(player);
        setSpeedDigingFromStats(player);
    }

    public static int getStrengthLevel(String player){
        return strength.get(player);
    }

    public static int getSpeedDigingLevel(String player){
        return speedDiging.get(player);
    }

    public static int getSpeedLevel(String player){
        return speed.get(player);
    }

    public static int getSlowlessLevel(String player){
        return slowless.get(player);
    }

    public static void setStrengthFromStats(Player player) {
        UsersStats.setUsersKillMobCountStatsPerson(player.getName(),player.getStatistic(Statistic.MOB_KILLS));
        int lvl = 0;
        int lvlRaw = UsersStats.getUsersKillMobCountStats().get(player.getName());
        if (lvlRaw>=1) lvl=1;
        if (lvlRaw>=2) lvl=2;
        if (lvlRaw>=3) lvl=3;
        if (lvlRaw>=4) lvl=4;
        if (lvlRaw>=5) lvl=5;
        strength.put(player.getName(),lvl);
    }

    public static void setSpeedFromStats(Player player) {
        PlayTime.setQuittime(player);
        PlayTime.setPlayTimeStats(player);
        PlayTime.setJointime(player);
        int lvl = 0;
        int lvlRaw = UsersStats.getUsersPlayTimeStats().get(player.getName());
        if (lvlRaw>=100) lvl=1;
        if (lvlRaw>=500) lvl=2;
        if (lvlRaw>=1000) lvl=3;
        if (lvlRaw>=2000) lvl=4;
        if (lvlRaw>=3000) lvl=5;
        speed.put(player.getName(),lvl);
    }

    public static void setSpeedDigingFromStats(Player player) {
        UsersStats.setUsersBreakBlockCountStatsPerson(player.getName(),player.getStatistic(Statistic.MINE_BLOCK, Material.GRASS_BLOCK));
        int lvl = 0;
        int lvlRaw = UsersStats.getUsersBreakBlockCountStats().get(player.getName());
        if (lvlRaw>=1) lvl=1;
        if (lvlRaw>=3) lvl=2;
        if (lvlRaw>=5) lvl=3;
        if (lvlRaw>=10) lvl=4;
        if (lvlRaw>=20) lvl=5;
        speedDiging.put(player.getName(),lvl);
    }

    public static void setSlowlessFromStats(Player player) {
        UsersStats.setUsersDeathCountStatsPerson(player.getName(),player.getStatistic(Statistic.DEATHS));
        int lvl = 0;
        int lvlRaw = UsersStats.getUsersDeathCountStats().get(player.getName());
        if (lvlRaw>=1) lvl=1;
        if (lvlRaw>=2) lvl=2;
        if (lvlRaw>=3) lvl=3;
        if (lvlRaw>=4) lvl=4;
        if (lvlRaw>=5) lvl=5;
        slowless.put(player.getName(),lvl);
    }

    public static void setStrength(String player, int strengthPut) {
        strength.put(player,strengthPut);
    }

    public static void setSpeed(String player, int speedPut) {
        strength.put(player,speedPut);
    }

    public static void setSpeedDiging(String player, int speedDigingPut) {
        strength.put(player,speedDigingPut);
    }

    public static void setSlowless(String player, int slowlessPut) {
        strength.put(player,slowlessPut);
    }

    public static void addPlayer(Player player){
        strength.put(player.getName(),0);
        slowless.put(player.getName(),0);
        speed.put(player.getName(),0);
        speedDiging.put(player.getName(),0);
    }

    public static boolean checker(Player player){
        if (strength.containsKey(player.getName()) && slowless.containsKey(player.getName())
                && speed.containsKey(player.getName()) && speedDiging.containsKey(player.getName())){
            return true;
        }
        return false;
    }

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
