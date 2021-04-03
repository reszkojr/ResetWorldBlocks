package commands;

import events.PlacedBlocksEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Map;
import java.util.Set;

public class ResetBlocksCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("resetblocks")) {

            Set<Location> placedBlocks = PlacedBlocksEvent.locationSet();

            for (Location location : placedBlocks) {
                Block block = location.getBlock();
                block.setType(Material.AIR);
            }

            placedBlocks.clear();
            return true;
        }
        if (args.length > 0) {
            Bukkit.getConsoleSender().sendMessage("Incorrect command usage!");
            return false;
        }
        return true;
    }
}
