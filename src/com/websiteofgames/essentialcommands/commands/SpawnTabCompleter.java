package com.websiteofgames.essentialcommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class SpawnTabCompleter implements TabCompleter {


    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command cmd, String label, String[] args) {


        if(args.length == 1){

            List<String> spawnableEntities = new ArrayList();


            EntityType[] entities = EntityType.class.getEnumConstants();


            for (int i = 0; i<entities.length; i++){
                spawnableEntities.add(String.valueOf(entities[i]).toLowerCase());



            }


            return spawnableEntities;



        }else if (args.length == 2){

                List<String> nums = new ArrayList<>();
                nums.add("1");
                nums.add("10");
                nums.add("100");
                nums.add("1000");

                return nums;

        }else if (args.length == 3){
if (cmd.getName().equalsIgnoreCase("spawn")) {
    List<String> bool = new ArrayList<>();
    bool.add("!Spawn entities where you are looking?");
    bool.add("true");
    bool.add("false");

    return bool;
}
        }

        else{

            return null;

        }

return null;
    }
}
