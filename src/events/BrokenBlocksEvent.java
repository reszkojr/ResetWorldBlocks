package events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.LinkedHashMap;
import java.util.Map;

public class BrokenBlocksEvent implements Listener {

    private static final Map<Location, Material> brokenBlocks = new LinkedHashMap<>();

    @EventHandler
    public void brokenBlocksEvent(BlockBreakEvent event) {
        Block block = event.getBlock();
        Material blockMaterial = block.getType();
        Location blockLocation = block.getLocation();

        if (blockMaterial != Material.AIR) {
            brokenBlocks.put(blockLocation, blockMaterial);
        }
    }

    public static Map<Location, Material> locationAndMaterialMap() {
        return brokenBlocks;
    }
}
