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

        inventory.setItem(0,newItemStack(Material.CREEPER_HEAD,"strength",nickname));
        inventory.setItem(2,newItemStack(Material.GOLDEN_PICKAXE,"speedDiging",nickname));
        inventory.setItem(4,newItemStack(Material.LEATHER_BOOTS,"speed",nickname));
        inventory.setItem(6,newItemStack(Material.SKELETON_SKULL,"slowless",nickname));
        inventory.setItem(8,newItemStack(Material.DIAMOND,"lastseen",nickname));
        inventory.setItem(22,newItemStackQuit(Material.DARK_OAK_DOOR));

        Player player = (Player) commandSender;
        player.openInventory(inventory); // Открываем инвентарь
    }

    public static ItemStack newItemStack(Material material,String meta,String nickname){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("key"),PersistentDataType.STRING,meta);
        switch (meta) {
            case "strength":
                itemMeta.setDisplayName("Mob's killed: " + UsersStats.getUsersKillMobCountStats().get(nickname));
                itemMeta.setLore(List.of(
                        "Strength Level: "+UsersUpgrades.getStrengthLevel(nickname)
                ));
                break;
            case "speedDiging":
                itemMeta.setDisplayName("Block's digging: " + UsersStats.getUsersBreakBlockCountStats().get(nickname));
                itemMeta.setLore(List.of(
                        "SpeedDiging Level: "+UsersUpgrades.getSpeedDigingLevel(nickname)
                ));
                break;
            case "speed":
                itemMeta.setDisplayName("Play time: " + UsersStats.getUsersPlayTimeStats().get(nickname));
                itemMeta.setLore(List.of(
                        "Speed Level: "+UsersUpgrades.getSpeedLevel(nickname)
                ));
                break;
            case "slowless":
                itemMeta.setDisplayName("Death count: " + UsersStats.getUsersDeathCountStats().get(nickname));
                itemMeta.setLore(List.of(
                        "Slowless Level: "+UsersUpgrades.getSlowlessLevel(nickname)
                ));
                break;
            case "lastseen":
                itemMeta.setDisplayName("Player is " + (UsersStats.getUsersLastSeenStats().get(nickname).equals("now online") ? "online":"offline"));
                itemMeta.setLore(List.of(
                        "Last Seen: "+UsersStats.getUsersLastSeenStats().get(nickname)
                ));
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
