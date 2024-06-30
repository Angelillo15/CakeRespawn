package com.nookure.cakerespawn;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Cake;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CakeRespawn extends JavaPlugin implements Listener {
  private static final boolean defaultState;

  static {
    defaultState = System.getProperty("nookure.cakeRespawn") == null;
  }

  private boolean cakeRespawn = defaultState;

  @Override
  public void onEnable() {
    Bukkit.getPluginManager().registerEvents(this, this);
    Bukkit.getCommandMap().register("crespawn", new com.nookure.cakerespawn.command.CakeRespawn("cakerespawn", this));
    getSLF4JLogger().info("CakeRespawn has been loaded");
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    if (!isCakeRespawn()) return;

    Block block = event.getClickedBlock();

    if (block == null) return;

    if (!(block.getState().getBlockData() instanceof Cake cake)) {
      return;
    }

    if (cake.getBites() == cake.getMaximumBites()) {
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
        block.getLocation().getBlock().setType(Material.CAKE);
      }, 1L);
    }
  }

  public boolean isCakeRespawn() {
    return cakeRespawn;
  }

  public boolean setCakeRespawn(boolean cakeRespawn) {
    this.cakeRespawn = cakeRespawn;
    return this.cakeRespawn;
  }
}
