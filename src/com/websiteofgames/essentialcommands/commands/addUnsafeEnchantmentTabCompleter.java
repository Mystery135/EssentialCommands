package com.websiteofgames.essentialcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class addUnsafeEnchantmentTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command cmd, String label, String[] args) {
        if (args.length == 2){


            List<String> enchantments = new ArrayList();


            Enchantment[] arrayenchantments = Enchantment.values();


            for (int i = 0; i<arrayenchantments.length; i++){
                String ench = arrayenchantments[i].toString().toLowerCase(Locale.ROOT);
                ench = ench.replace("enchantment[minecraft:", "");
                ench = ench.replace("]", "");
                ench = removeafter(ench, ",");


                enchantments.add(ench);




            }
            return enchantments;




        }else if (args.length == 3){
            List<String> lvl = new ArrayList();
            lvl.add("1");
            lvl.add("2");
            lvl.add("3");
            lvl.add("4");
            lvl.add("5");
            lvl.add("6");
            lvl.add("7");
            lvl.add("8");
            lvl.add("9");
            return lvl;



        }
        return null;
    }

    private String removeafter(String oldvalue, String removeafter){

        String newValue = oldvalue.substring(0, oldvalue.indexOf(removeafter));

return newValue;
    }


}
