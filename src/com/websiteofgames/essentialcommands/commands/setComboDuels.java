package com.websiteofgames.essentialcommands.commands;

import com.websiteofgames.essentialcommands.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Map;

public class setComboDuels implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
if (args.length == 0){
 commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aCombo Duels is currently set to " + Main.getPlugin().getConfig().get("comboduels")));
}
       else if (args.length == 1){

            try {
                boolean truefalse = Boolean.parseBoolean(args[0]);
                if (truefalse){
                    Main.getPlugin().getConfig().set("comboduels", "true");
                    commandSender.sendMessage("§aCombo Duels set to§e " + Main.getPlugin().getConfig().get("comboduels"));

                }else {
                    Main.getPlugin().getConfig().set("comboduels", "false");
                    commandSender.sendMessage("§aCombo Duels set to§e " + Main.getPlugin().getConfig().get("comboduels"));

                }
                Main.getPlugin().saveConfig();
            }catch (Exception e){
                commandSender.sendMessage("§c/setcomboduels <true/false>");

            }

        }else{
            commandSender.sendMessage("§c/setcomboduels <true/false>");
        }

        return true;
    }
}
