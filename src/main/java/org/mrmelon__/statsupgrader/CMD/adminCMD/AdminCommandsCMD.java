package org.mrmelon__.statsupgrader.CMD.adminCMD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdminCommandsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) { // Команда, позволяющая вызывать функции админу
        String arg1 = strings[0]; // 1 Аргумент команды
        String arg2 = strings[1]; // 2 Аргумент команды
        // НАЧАЛО БЛОКА АРГУМЕНТОВ КОМАНД
        if (arg1.equals("add")) AdminRunners.add(commandSender,strings[1]);
        else if (arg1.equals("list")) AdminRunners.list(commandSender);
        else if (arg1.equals("userlist")) AdminRunners.userlist(commandSender);
        else if (arg1.equals("userstats")) {
            if (arg2.equals("playtime")) {
                try {
                    String arg3 = strings[2];
                    AdminStatsGiver.getUsersPlayTimeStats(commandSender, strings[2]);
                } catch (Exception e) {
                    AdminStatsGiver.getUsersPlayTimeStatsAll(commandSender);
                }
            } else if (arg2.equals("breakblockcount")) {
                try {
                    String arg3 = strings[2];
                    AdminStatsGiver.getUsersBreakBlockCountStats(commandSender, strings[2]);
                } catch (Exception e) {
                    AdminStatsGiver.getUsersBreakBlockCountStatsAll(commandSender);
                }
            }
        }
        else return false;
        // КОНЕЦ БЛОКА АРГУМЕНТОВ КОМАНД
        return true;
    }
}
