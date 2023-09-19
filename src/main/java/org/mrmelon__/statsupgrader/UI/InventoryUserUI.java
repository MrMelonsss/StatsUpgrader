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
import org.mrmelon__.statsupgrader.users.UsersStats;
import org.mrmelon__.statsupgrader.users.upgrades.UsersUpgrades;

import java.util.List;

public class InventoryUserUI { // Реализация UI интерфейса для юзера

    public static void openInventoryUserUI(String nickname, CommandSender commandSender){
        Inventory inventory = Bukkit.createInventory(null,27,"Stats of "+nickname); // Создаем инвентарь

        inventory.setItem(1,newItemStack(Material.CREEPER_HEAD,"strength",List.of("Strength Level:"),nickname));
        inventory.setItem(3,newItemStack(Material.GOLDEN_PICKAXE,"speedDiging",List.of("SpeedDiging Level:"),nickname));
        inventory.setItem(5,newItemStack(Material.LEATHER_BOOTS,"speed",List.of("Speed Level:"),nickname));
        inventory.setItem(7,newItemStack(Material.SKELETON_SKULL,"slowless",List.of("Slowless Level:"),nickname));
        inventory.setItem(9,newItemStackQuit(Material.DARK_OAK_DOOR));

        Player player = (Player) commandSender;
        player.openInventory(inventory); // Открываем инвентарь
    }

    public static ItemStack newItemStack(Material material,String meta,List<String> list,String nickname){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("key"),PersistentDataType.STRING,meta);
        switch (meta) {
            case "strength":
                itemMeta.setDisplayName("Mob's killed: " + UsersStats.getUsersKillMobCountStats().get(nickname));
                list.set(0, list.get(0) + UsersUpgrades.getStrengthLevel(nickname));
                itemMeta.setLore(list);
                break;
            case "speedDiging":
                itemMeta.setDisplayName("Block's digging: " + UsersStats.getUsersKillMobCountStats().get(nickname));
                list.set(0, list.get(0) + UsersUpgrades.getSpeedDigingLevel(nickname));
                itemMeta.setLore(list);
                break;
            case "speed":
                itemMeta.setDisplayName("Play time: " + UsersStats.getUsersPlayTimeStats().get(nickname));
                list.set(0, list.get(0) + UsersUpgrades.getSpeedLevel(nickname));
                itemMeta.setLore(list);
                break;
            case "slowless":
                itemMeta.setDisplayName("Death count: " + UsersStats.getUsersDeathCountStats().get(nickname));
                list.set(0, list.get(0) + UsersUpgrades.getSlowlessLevel(nickname));
                itemMeta.setLore(list);
                break;
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack newItemStackQuit(Material material){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Quit");
        itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("key"),PersistentDataType.STRING,"quit");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
