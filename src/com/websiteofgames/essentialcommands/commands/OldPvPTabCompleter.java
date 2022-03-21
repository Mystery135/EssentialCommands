package com.websiteofgames.essentialcommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class OldPvPTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length == 1){
            List truefalse = new ArrayList();
            truefalse.add("true");
            truefalse.add("false");
            return truefalse;
        }else{

            return null;

        }
    }
}
