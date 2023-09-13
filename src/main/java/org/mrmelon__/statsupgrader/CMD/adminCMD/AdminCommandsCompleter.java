package org.mrmelon__.statsupgrader.CMD.adminCMD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class AdminCommandsCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) { // Таб комплитер для команды /adminsu
        if (strings.length==1){ // Лист на аргументы команды при длине 1
            return List.of(
                    "add",
                    "list",
                    "userlist",
                    "userstats"
            );
        }
        if (strings.length==2 && strings[0].equals("userstats")){ // Лист на аргументы команды при длине 2
            return List.of(
                    "playtime",
                    "breakblockcount"
            );
        }
        return null;
    }
}
