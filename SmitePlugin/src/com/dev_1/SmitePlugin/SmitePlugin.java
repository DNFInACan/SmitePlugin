package com.dev_1.SmitePlugin;

import com.dev_1.SmitePlugin.commands.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class SmitePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("toggleplugin").setExecutor(new CommandHandler());
        getCommand("smite").setExecutor(new CommandHandler());
    }

}
