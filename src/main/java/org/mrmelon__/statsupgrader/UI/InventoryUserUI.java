package org.mrmelon__.statsupgrader.UI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class InventoryUserUI { // Реализация UI интерфейса для юзера

    public static void openInventoryUserUI(String nickname, CommandSender commandSender){
        Inventory inventory = Bukkit.createInventory(null,27,"Stats of "+nickname); // Создаем инвентарь

        //

        Player player = (Player) commandSender;
        player.openInventory(inventory); // Открываем инвентарь
    }

    public static ItemStack newItemStack(Material material,String meta){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("key"),PersistentDataType.STRING,meta);
        return itemStack;
    }

}
