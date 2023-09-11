package org.mrmelon__.statsupgrader.CMD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.mrmelon__.statsupgrader.UI.InventoryUserUI;
import org.mrmelon__.statsupgrader.users.Users;

public class StatsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) { // Команда, которая будет вызывать UI со статой для юзера
        String playerName = strings[0]; // Аргумент команды
        if (Users.userChecker(playerName)) { // Проверка на присутствие пользователя в списке
            InventoryUserUI.openInventoryUserUI(playerName, commandSender); // Открытие инвентаря
            return true;
        }
        return false;
    }
}
