package com.dev_1.SmitePlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class CommandHandler implements CommandExecutor {

    public boolean pluginToggled = true;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player p = (Player) commandSender;

        if (command.getName().equalsIgnoreCase("toggleplugin")) {
            ChatColor chatColorSelected = ChatColor.RED;

            if (!(p.isOp())) {
                p.sendMessage(chatColorSelected + "Insufficient permissions!");
                return true;
            }

            // Takes the current value of the boolean pluginToggled and then takes the inverse of it.

            pluginToggled = !pluginToggled;

            // If the plugin is toggled, then we change the color to green.
            if (pluginToggled) {
                chatColorSelected = ChatColor.GREEN;
            }

            p.sendMessage(chatColorSelected + "Plugin toggled: " + pluginToggled);
        }
        if (command.getName().equalsIgnoreCase("smite")) {

            ChatColor chatColorSelected = ChatColor.RED;

            if (!(p.isOp())) {
                p.sendMessage(chatColorSelected + "Insufficient permissions!");
                return true;
            }

            if (!(pluginToggled)) {
                return true;
            }

            if (args.length >= 1) {
                try {

                    Player targetPlayer = Bukkit.getPlayerExact(args[0]);

                    if (!targetPlayer.isOnline()) {
                        p.sendMessage(chatColorSelected + "Player " + targetPlayer + " is not online or invalid!");
                        return true;
                    }

                    chatColorSelected = ChatColor.GOLD;

                    targetPlayer.getWorld().strikeLightningEffect(targetPlayer.getLocation());

                    Vector targetVelocity = targetPlayer.getVelocity();

                    targetVelocity.setY(100);

                    targetPlayer.setVelocity(targetVelocity);

                } catch (IllegalArgumentException e) {
                    p.sendMessage(chatColorSelected + "Invalid argument!");
                }
            }

        }

        return true;
    }

}