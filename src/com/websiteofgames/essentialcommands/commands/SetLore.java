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
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetLore implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {

        try {
            Player player = Bukkit.getPlayer(args[0]);
            List<String> lores = new ArrayList<>();
            for (int i = 0; i<args.length; i++){

            lores.add(args[i]);
            }
            lores.remove(0);

            ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
            List<String> lore = new ArrayList<>();
            String truelorestring = "";

            for (String s: lores){
                truelorestring = truelorestring+s;
            }
            String[] truelore = truelorestring.split(Objects.requireNonNull(Main.getPlugin().getConfig().getString("setlore.newlinekey")));
            for (String s:truelore){
                lore.add(ChatColor.translateAlternateColorCodes(Main.getPlugin().getConfig().get("AlternateColorCode").toString().charAt(0), s));
            }


            meta.setLore(lore);
            player.getInventory().getItemInMainHand().setItemMeta(meta);

            if (commandSender instanceof Player){
                Player player1 = (Player) commandSender;
                player1.getWorld().playSound(player1.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);

            }
        }catch (Exception e){
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/setlore <target player> <line1" +Main.getPlugin().getConfig().get("setlore.newlinekey") +"line2" + Main.getPlugin().getConfig().get("setlore.newlinekey")
                    +"line3" + Main.getPlugin().getConfig().get("setlore.newlinekey") +"line4 etc>"));
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cType in " + Main.getPlugin().getConfig().get("setlore.newlinekey") + " to create a new line!"));
        }






        return true;
    }
}
