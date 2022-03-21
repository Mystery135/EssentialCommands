package com.websiteofgames.essentialcommands.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {

        if (commandSender instanceof Player) {

            if (cmd.getName().equalsIgnoreCase("spawn")) {
                if (commandSender.hasPermission("essentialcommands.spawn")) {

                    Player player = (Player) commandSender;
                    Location loc = player.getLocation();

                    if (args.length == 2) {
                        EntityType mob = null;
                        try {
                            mob = EntityType.valueOf(args[0].toUpperCase());

                        } catch (Exception e) {

                            player.sendMessage("§cPlease type in a valid mob!");
                            player.sendMessage("§c/spawn <type of mob> <amount>");
                        }
                        try {
                            int amount = Integer.valueOf(args[1]);
                            for (int i = 0; i < amount; i++) {
                                player.getWorld().spawnEntity(loc, mob);


                            }
                            if (amount != 1) {

                                player.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " ") + "s");


                            } else {
                                player.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " "));


                            }
                        } catch (Exception e) {

                            player.sendMessage("§cPlease type in a valid number!");
                            player.sendMessage("§c/spawn <type of mob> <amount>");

                        }


                    } else if (args.length == 1) {
                        try {
                            EntityType mob = EntityType.valueOf(args[0].toUpperCase());
                            player.getWorld().spawnEntity(loc, mob);
                            player.sendMessage("§eSpawned 1 " + mob.name().toLowerCase());
                        } catch (Exception e) {


                            player.sendMessage("§cPlease type in a valid mob!");
                            player.sendMessage("§c/spawn <type of mob>");
                        }


                    } else if (args.length == 3) {

                        if (args[2].equals("false")) {


                            EntityType mob = null;
                            try {
                                mob = EntityType.valueOf(args[0].toUpperCase());

                            } catch (Exception e) {

                                player.sendMessage("§cPlease type in a valid mob!");
                                player.sendMessage("§c/spawn <type of mob> <amount>");
                            }
                            try {
                                int amount = Integer.valueOf(args[1]);
                                for (int i = 0; i < amount; i++) {
                                    player.getWorld().spawnEntity(loc, mob);

                                }
                                if (amount != 1) {
                                    player.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " ") + "s");


                                } else {
                                    player.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " "));


                                }

                            } catch (Exception e) {

                                player.sendMessage("§cPlease type in a valid number!");
                                player.sendMessage("§c/spawn <type of mob> <amount>");

                            }


                        } else if (args[2].equals("true")) {

                            Location location = null;
                            for (int i = 100; i > 0; i--) {
                                if (player.getTargetBlock(null, i).getType() == Material.AIR) {
                                    Block block = player.getTargetBlock(null, i);
                                    location = block.getLocation();
                                    break;
                                }
                            }
                            if (location == null) {

                                Block block = player.getTargetBlock(null, 1);
                                location = block.getLocation();
                            }

                            EntityType mob = null;
                            try {
                                mob = EntityType.valueOf(args[0].toUpperCase());

                            } catch (Exception e) {

                                player.sendMessage("§cPlease type in a valid mob!");
                                player.sendMessage("§c/spawn <type of mob> <amount>");
                            }
                            try {
                                int amount = Integer.valueOf(args[1]);
                                for (int i = 0; i < amount; i++) {
                                    player.getWorld().spawnEntity(location, mob);

                                }
                                if (amount != 1) {
                                    player.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " ") + "s");


                                } else {
                                    player.sendMessage("§eSpawned " + amount + " " + mob.name().toLowerCase().replace("_", " "));


                                }
                            } catch (Exception e) {

                                player.sendMessage("§cPlease type in a valid number!");
                                player.sendMessage("§c/spawn <type of mob> <amount>");

                            }


                        } else {
                            player.sendMessage("§c/spawn <type of mob> <amount> <spawn where you are looking?>");


                        }


                    } else {

                        player.sendMessage("§c/spawn <type of mob> <amount> <spawn where you are looking?>");


                    }
                }else{

                    commandSender.sendMessage("§cYou don't have the permission essentialcommands.spawn!");

                }

            } else {

                commandSender.sendMessage("§cOnly players can execute this command!");

            }


            return true;
        }
    return true;}}

