package com.websiteofgames.essentialcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnOn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {

        if (commandSender.hasPermission("essentialcommands.spawnon")) {

            if (cmd.getName().equalsIgnoreCase("spawnon")) {




                if (args.length == 3) {
                    EntityType mob = null;
                    Player player = null;
                    Location loc = null;
                    try {
                        player = Bukkit.getPlayer(args[0]);
                        loc = player.getLocation();
                    }catch (Exception e){


                        commandSender.sendMessage("§cPlease type in a valid player!");
                        commandSender.sendMessage("§c/spawnon <target player> <type of mob> <amount> ");

                    }
                    try {
                        mob = EntityType.valueOf(args[1].toUpperCase());

                    }catch (Exception e){

                        commandSender.sendMessage("§cPlease type in a valid mob!");
                        commandSender.sendMessage("§c/spawnon <target player> <type of mob> <amount> ");
                    }
                    try {
                        int amount = Integer.valueOf(args[2]);
                        for (int i = 0; i < amount; i++) {
                            player.getWorld().spawnEntity(loc, mob);


                        }
                        if (amount != 1){

                            commandSender.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " ") + "s on " + player.getName());


                        }else{
                            commandSender.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " ") + " on " + player.getName());


                        }
                    }catch (Exception e){

                        commandSender.sendMessage("§cPlease type in a valid number!");
                        commandSender.sendMessage("§c/spawnon <target player> <type of mob> <amount> ");

                    }



                } else if (args.length == 2) {

                    Player player = null;
                    Location loc = null;
                    try {
                        player = Bukkit.getPlayer(args[0]);
                        loc = player.getLocation();
                    }catch (Exception e){


                        commandSender.sendMessage("§cPlease type in a valid player!");
                        commandSender.sendMessage("§c/spawnon <target player> <type of mob>");

                    }
                    try {
                        EntityType mob = EntityType.valueOf(args[1].toUpperCase());
                        player.getWorld().spawnEntity(loc, mob);
                        commandSender.sendMessage("§eSpawned 1 " + mob.name().toLowerCase() + " on " + player.getName());
                    }catch (Exception e){



                        commandSender.sendMessage("§cPlease type in a valid mob!");
                        commandSender.sendMessage("§c/spawnon <target player> <type of mob>");                    }



                } else if (args.length == 4) {

                    if (args[3].equals("false")){


                        EntityType mob = null;
                        Player player = null;
                        Location loc = null;
                        try {
                            player = Bukkit.getPlayer(args[0]);
                            loc = player.getLocation();
                        }catch (Exception e){


                            commandSender.sendMessage("§cPlease type in a valid player!");
                            commandSender.sendMessage("§c/spawnon <target player> <type of mob> <amount> ");

                        }
                        try {
                            mob = EntityType.valueOf(args[1].toUpperCase());

                        }catch (Exception e){

                            commandSender.sendMessage("§cPlease type in a valid mob!");
                            commandSender.sendMessage("§c/spawnon <target player> <type of mob> <amount> ");
                        }
                        try {
                            int amount = Integer.valueOf(args[2]);
                            for (int i = 0; i < amount; i++) {
                                player.getWorld().spawnEntity(loc, mob);

                            }
                            if (amount != 1){
                                player.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " ") + "s on " + player.getName());


                            }else{
                                player.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " ") + " on " + player.getName());


                            }

                        }catch (Exception e){

                            commandSender.sendMessage("§cPlease type in a valid number!");
                            commandSender.sendMessage("§c/spawnon <target player> <type of mob> <amount> ");

                        }




                    }else if (args[3].equals("true")){

                        Location location = null;
                        Player player = null;
                        Location loc = null;
                        try {
                            player = Bukkit.getPlayer(args[0]);
                            loc = player.getLocation();
                        }catch (Exception e){


                            commandSender.sendMessage("§cPlease type in a valid player!");
                            commandSender.sendMessage("§c/spawnon <target player> <type of mob> <amount> ");

                        }
                        for(int i = 100; i>0; i--){
                            if (player.getTargetBlock(null, i).getType()== Material.AIR){
                                Block block = player.getTargetBlock(null, i);
                                location = block.getLocation();
                                break;
                            }
                        }
                        if (location == null){

                            Block block = player.getTargetBlock(null, 1);
                            location = block.getLocation();
                        }

                        EntityType mob = null;
                        try {
                            mob = EntityType.valueOf(args[1].toUpperCase());

                        }catch (Exception e){

                            commandSender.sendMessage("§cPlease type in a valid mob!");
                            commandSender.sendMessage("§c/spawnon <target player> <type of mob> <amount> ");
                        }
                        try {
                            int amount = Integer.valueOf(args[2]);
                            for (int i = 0; i < amount; i++) {
                                player.getWorld().spawnEntity(location, mob);

                            }
                            if (amount != 1){
                                commandSender.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " ") + "s on " + player.getName());


                            }else{
                                commandSender.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " ") + " on "+player.getName());


                            }
                        }catch (Exception e){

                            commandSender.sendMessage("§cPlease type in a valid number!");
                            commandSender.sendMessage("§c/spawnon <target player> <type of mob> <amount> ");

                        }




                    }else{
                        commandSender.sendMessage("§c/spawnon <target player> <type of mob> <amount> <spawn where you are looking?>");


                    }





                }else{

                    commandSender.sendMessage("§c/spawnon <target player> <type of mob> <amount> <spawn where you are looking?>");


                }
            }

        } else {

            commandSender.sendMessage("§cYou don't have the permission essentialcommands.spawnon!");

        }


        return true;
    }
    }

