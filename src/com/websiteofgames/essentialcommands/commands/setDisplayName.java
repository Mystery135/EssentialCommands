package com.websiteofgames.essentialcommands.commands;

import com.websiteofgames.essentialcommands.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class setDisplayName implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
        try {

                Player player = Bukkit.getPlayer(args[0]);
                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                String displayname = "";
                for (int i = 1; i<args.length; i++){
                    if (i == args.length-1){
                        displayname+=args[i];

                    }else{
                        displayname+=args[i] + " ";

                    }
                }



                meta.setDisplayName(ChatColor.translateAlternateColorCodes(Main.getPlugin().getConfig().get("AlternateColorCode").toString().charAt(0), displayname));
                player.getInventory().getItemInMainHand().setItemMeta(meta);

                if (commandSender instanceof Player) {
                    Player player1 = (Player) commandSender;
                    player1.getWorld().playSound(player1.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

                }

        }catch (Exception e){
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/setdisplayname <target player> <display name>"));
        }






        return true;
    }
}
