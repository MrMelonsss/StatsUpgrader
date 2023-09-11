package org.mrmelon__.statsupgrader.UI;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryUserUI { // Реализация UI интерфейса для юзера

    public static void openInventoryUserUI(String nickname, CommandSender commandSender){
        Inventory inventory = Bukkit.createInventory(null,27,"Stats of "+nickname); // Создаем инвентарь

        //

        Player player = (Player) commandSender;
        player.openInventory(inventory); // Открываем инвентарь
    }

}
