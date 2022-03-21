package com.websiteofgames.essentialcommands.commands;

import com.websiteofgames.essentialcommands.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class OldPvP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
if (commandSender.hasPermission("essentialcommands.oldpvp")){

    if (args.length == 1){
        if (args[0].equalsIgnoreCase("false")){
            Main.getPlugin().getConfig().set("oldpvp", "false");
            Main.getPlugin().saveConfig();
            commandSender.sendMessage("§eOldPvP is now set to §b" + Main.getPlugin().getConfig().get("oldpvp").toString());

        }else if (args[0].equalsIgnoreCase("true")){
            Main.getPlugin().getConfig().set("oldpvp", "true");
            Main.getPlugin().saveConfig();
            commandSender.sendMessage("§eOldPvP is now set to §b" + Main.getPlugin().getConfig().get("oldpvp").toString());

        }


    }else if (args.length == 0){


        commandSender.sendMessage("§eOldPvP is set to §b" + Main.getPlugin().getConfig().get("oldpvp").toString());


    }else{

        commandSender.sendMessage("§c/<oldpvp> <true/false>");

    }




}else {


    commandSender.sendMessage("§cYou don't have the permission essentialcommands.oldpvp!");
}





        return true;
    }
}
