package main;

import commands.ResetBlocksCommand;
import events.BrokenBlocksEvent;
import events.PlacedBlocksEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ResetWorldBlocks extends JavaPlugin {

    @Override
    public void onEnable() {
        sendConsoleMessage(ChatColor.GREEN + "ResetBlocks enabled!");
        registerCommands("resetblocks", new ResetBlocksCommand());
        registerEvents(new PlacedBlocksEvent(), this);
        registerEvents(new BrokenBlocksEvent(), this);
    }

    @Override
    public void onDisable() {
        sendConsoleMessage(ChatColor.RED + "ResetBlocks disabled!");
    }

    private void registerEvents(Listener listener, Plugin plugin) {
        getServer().getPluginManager().registerEvents(listener, plugin);
    }

    private void registerCommands(String cmd, CommandExecutor cmdExecutor) {
        getCommand(cmd).setExecutor(cmdExecutor);
    }

    private void sendConsoleMessage(String s) {
        getServer().getConsoleSender().sendMessage(s);
    }
}