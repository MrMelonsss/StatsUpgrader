package org.mrmelon__.statsupgrader.CMD.adminCMD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdminCommandsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) { // Команда, позволяющая вызывать функции админу
        String arg = strings[0]; // Аргумент команды
        // НАЧАЛО БЛОКА АРГУМЕНТОВ КОМАНД
        if (arg.equals("add")) AdminRunners.add(commandSender,strings[1]);
        else if (arg.equals("list")) AdminRunners.list(commandSender);
        else if (arg.equals("userlist")) AdminRunners.userlist(commandSender);
        else return false;
        // КОНЕЦ БЛОКА АРГУМЕНТОВ КОМАНД
        return true;
    }
}
