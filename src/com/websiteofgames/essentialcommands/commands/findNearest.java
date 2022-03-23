package com.websiteofgames.essentialcommands.commands;

import com.websiteofgames.essentialcommands.WordsCapitalizer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.awt.*;
import java.util.Locale;

public class findNearest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cOnly players can execute this command!"));
            return true;
        }
        if (!(args.length == 2)){
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/findnearest <entity type> <range>"));

            return true;
        }
        try {
            int range = Integer.parseInt(args[1]);
            EntityType entityType = EntityType.valueOf(args[0].toUpperCase());
            Player player = (Player) commandSender;
            boolean nearby = false;
            Entity closestentity = null;
            double closest = Double.MAX_VALUE;
            for (Entity entity:player.getNearbyEntities(range, range, range)){
                if (entity.getType() == entityType){
                    if (entity.getLocation().distance(player.getLocation()) < closest){
                        closest = entity.getLocation().distance(player.getLocation());
                        closestentity = entity;
                        nearby = true;

                    }

                }
            }
            if (!nearby){
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cA " + WordsCapitalizer.capitalizeEveryWord(entityType.name()) + " was not found!"));
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cTry raising the range!"));
return true;
            }else{
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a" + WordsCapitalizer.capitalizeEveryWord(entityType.name()) + " found!"));
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eLocation: " + "X: " + closestentity.getLocation().getX() + " Y: " + closestentity.getLocation().getY() + " Z: " + closestentity.getLocation().getZ()));
                player.teleport(closestentity.getLocation());

            }



        }catch (Exception e){
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/findnearest <entity type> <range>"));

        }


        return true;
    }
}
