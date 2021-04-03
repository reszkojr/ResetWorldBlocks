package events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.LinkedHashSet;
import java.util.Set;

public class PlacedBlocksEvent implements Listener {

    private static final Set<Location> placedBlocks = new LinkedHashSet<>();

    @EventHandler
    public void placedBlocksEvent(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Material blockMaterial = block.getType();

        if (blockMaterial != Material.AIR) {
            placedBlocks.add(block.getLocation());
        }
    }

    public static Set<Location> locationSet() {
        return placedBlocks;
    }
}
