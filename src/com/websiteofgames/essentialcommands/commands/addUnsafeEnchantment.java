package com.websiteofgames.essentialcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import java.util.Locale;

public class addUnsafeEnchantment implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
        if (commandSender.hasPermission("essentialcommands.addunsafeenchant")){

            if (args.length == 2){
                try{
                    Player player = Bukkit.getPlayerExact(args[0]);
                    Enchantment enchantment = Enchantment.getByKey(NamespacedKey.minecraft(args[1].toLowerCase(Locale.ROOT)));
                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment, 1);

                    String ench = enchantment.toString().toLowerCase(Locale.ROOT);
                    ench = ench.replace("enchantment[minecraft:", "");
                    ench = ench.replace("]", "");
                    ench = removeafter(ench, ",");


                    if (commandSender.getName().equals(player.getName())){
                        player.sendMessage("§eEnchanted your item with " + ench + " " + 1);


                    }else{

                        player.sendMessage("§eEnchanted " + player.getName()+ "'s" + " item with " + ench + " "+1);


                    }
                }catch (Exception e){
commandSender.sendMessage("§c/<addunsafeenchantment> <target> <type of enchantment> <level>");
commandSender.sendMessage("§cYou need to be holding an item in your hand!");

                }

            }else if (args.length == 3){

                try{
                    Player player = Bukkit.getPlayerExact(args[0]);
                    Enchantment enchantment = Enchantment.getByKey(NamespacedKey.minecraft(args[1].toLowerCase(Locale.ROOT)));
                    int lvl = Integer.parseInt(args[2]);
                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment, lvl);

                    String ench = enchantment.toString().toLowerCase(Locale.ROOT);
                    ench = ench.replace("enchantment[minecraft:", "");
                    ench = ench.replace("]", "");
                    ench = removeafter(ench, ",");


                    if (commandSender.getName().equals(player.getName())){
                        player.sendMessage("§eEnchanted your item with " + ench + " " + lvl);


                    }else{

                        player.sendMessage("§eEnchanted " + player.getName()+ "'s" + " item with " + ench + " "+lvl);


                    }

                }catch (Exception e){
                    commandSender.sendMessage("§c/<addunsafeenchantment> <target> <type of enchantment> <level>");
                    commandSender.sendMessage("§cThe target needs to be holding an item in their hand!");


                }


            }else{



commandSender.sendMessage("§cYou don't have the permission essentialcommands.addunsafeenchant!");

            }




        }

        return true;

    }
    private String removeafter(String oldvalue, String removeafter){

        String newValue = oldvalue.substring(0, oldvalue.indexOf(removeafter));

        return newValue;
    }
}
