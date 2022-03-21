package com.websiteofgames.essentialcommands;

import com.websiteofgames.essentialcommands.bstats.Metrics;
import com.websiteofgames.essentialcommands.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class Main extends JavaPlugin {
private static Main plugin;

    public static Main getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.saveConfig();

        if (this.getConfig().get("oldpvp") == null){

            this.getConfig().set("oldpvp", "false");

        }
        if (this.getConfig().get("comboduels") == null){

            this.getConfig().set("comboduels", "false");

        }
        if (this.getConfig().get("setlore.newlinekey") == null){

            this.getConfig().set("newlinekey", "/newline/");
//
        }
        runnable.runTaskTimer(this, 0, 0);

        plugin = this;
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("spawn").setTabCompleter(new SpawnTabCompleter());
        getCommand("spawnon").setExecutor(new SpawnOn());
        getCommand("spawnon").setTabCompleter(new SpawnOnTabCompleter());
        getCommand("oldpvp").setExecutor(new OldPvP());
        getCommand("oldpvp").setTabCompleter(new OldPvPTabCompleter());
        getCommand("setlore").setExecutor(new SetLore());
        getCommand("addunsafeenchantment").setExecutor(new addUnsafeEnchantment());
        getCommand("addunsafeenchantment").setTabCompleter(new addUnsafeEnchantmentTabCompleter());
        getCommand("comboduels").setExecutor(new setComboDuels());
        getCommand("comboduels").setTabCompleter(new OldPvPTabCompleter());


        int pluginId = 14701; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);

        // Optional: Add custom charts
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
    }
    BukkitRunnable runnable = new BukkitRunnable() {
        @Override
        public void run() {
            if (getPlugin().getConfig().get("comboduels").equals("true")){
                for (LivingEntity livingEntity: getServer ().getWorld("world").getLivingEntities()){
                    livingEntity.setMaximumNoDamageTicks(0);
                }
            }else{
                for (LivingEntity livingEntity: getServer ().getWorld("world").getLivingEntities()){
                    livingEntity.setMaximumNoDamageTicks(20);
                }
            }

            List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();
            if (Main.getPlugin().getConfig().get("oldpvp").equals("true")) {







                for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
                    if (Main.getPlugin().getConfig().get("AxesAffectedByOldPVP").toString().equals("false")) {
                        if (!(players.get(i).getInventory().getItemInMainHand().getType() == Material.NETHERITE_AXE) &&
                                !(players.get(i).getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE) &&
                                !(players.get(i).getInventory().getItemInMainHand().getType() == Material.GOLDEN_AXE) &&
                                !(players.get(i).getInventory().getItemInMainHand().getType() == Material.IRON_AXE) &&
                                !(players.get(i).getInventory().getItemInMainHand().getType() == Material.STONE_AXE) &&
                                !(players.get(i).getInventory().getItemInMainHand().getType() == Material.WOODEN_AXE)
                        ) {


                            players.get(i).getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(Integer.MAX_VALUE);


                        } else {

                            players.get(i).getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4);


                        }
                    }else{
                        players.get(i).getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(Integer.MAX_VALUE);



                    }

                }


            } else if (Main.getPlugin().getConfig().get("oldpvp").equals("false")) {
                for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
                    players.get(i).getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4);



                }

            }

        }

    };


}
