package com.websiteofgames.essentialcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class MakeUnbreakable implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (args.length == 0){
            try {
                if (commandSender instanceof Player) {
                    Player player = (Player) commandSender;
                    if (player.getInventory().getItemInMainHand() == null) {
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou aren't holding anything!"));
                        return true;

                    }

                    ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                    meta.setUnbreakable(true);
                    player.getInventory().getItemInMainHand().setItemMeta(meta);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eYour item is now unbreakable!"));
                } else {
                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cTarget a player!"));
                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/makeunbreakable <target player>"));
                }
            }catch(Exception e){
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou cannot make this item unbreakable!"));
            }
        }else if (args.length == 1){
            try {
                Player player = Bukkit.getPlayer(args[0]);
                if (player.getInventory().getItemInMainHand() == null){
                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYour target isn't holding anything!"));
                    return true;

                }

                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                meta.setUnbreakable(true);
                player.getInventory().getItemInMainHand().setItemMeta(meta);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);
                if (commandSender.getName().equals(player.getName())){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eYour item is now unbreakable!"));
                }else{
                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e" + player.getName() +"'s item is now unbreakable!"));
                }
            }catch (Exception e){
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cTarget a player!"));
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/makeunbreakable <target player>"));
            }


        }else{

        }
        return true;
    }
}
