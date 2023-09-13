package org.mrmelon__.statsupgrader.users;

import java.util.HashMap;
import java.util.Map;

public class UsersStats {

    private static Map<String,Integer> usersPlayTimeStats = new HashMap<>(); // Список статистики всех юзеров
    private static Map<String,String> usersLastSeenStats = new HashMap<>();
    private static Map<String,Integer> usersKillMobCountStats = new HashMap<>();
    private static Map<String,Integer> usersBreakBlockCountStats = new HashMap<>();
    private static Map<String,Integer> usersDeathCountStats = new HashMap<>();
    // (Ник, Количество отыгранного времени, Последний заход/на сервере, количество убитых мобов, количество сломанных блоков,
    // количество смертей)

    public static void addStats(String nickname,int playTime,String lastSeen,Integer killMobCount,Integer breakBlock,Integer deathCount){ // Метод, добавляющий статистику в список
        usersPlayTimeStats.put(nickname,playTime);
        usersLastSeenStats.put(nickname,lastSeen);
        usersKillMobCountStats.put(nickname,killMobCount);
        usersBreakBlockCountStats.put(nickname,breakBlock);
        usersDeathCountStats.put(nickname,deathCount);
    }

    public static void setUsersPlayTimeStatsPerson(String nickname, int playTime){
        usersPlayTimeStats.put(nickname,playTime);
    }

    public static int getUsersPlayTimeStatsPerson(String nickname){
        return usersPlayTimeStats.get(nickname);
    }

    public static void setUsersBreakBlockCountStatsPerson(String nickname, int breakBlockCount){
        usersBreakBlockCountStats.put(nickname,breakBlockCount);
    }

    public static int getUsersBreakBlockCountStatsPerson(String nickname){
        return usersBreakBlockCountStats.get(nickname);
    }

    public static Map<String, Integer> getUsersPlayTimeStats() {
        return usersPlayTimeStats;
    }

    public static Map<String, String> getUsersLastSeenStats() {
        return usersLastSeenStats;
    }

    public static Map<String, Integer> getUsersKillMobCountStats() {
        return usersKillMobCountStats;
    }

    public static Map<String, Integer> getUsersBreakBlockCountStats() {
        return usersBreakBlockCountStats;
    }

    public static Map<String, Integer> getUsersDeathCountStats() {
        return usersDeathCountStats;
    }
}
