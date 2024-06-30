package com.nookure.cakerespawn.command;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CakeRespawn extends Command {
  private final com.nookure.cakerespawn.CakeRespawn plugin;

  public CakeRespawn(@NotNull String name, @NotNull com.nookure.cakerespawn.CakeRespawn plugin) {
    super(name);
    setPermission("cakerespawn.admin");
    this.plugin = plugin;
  }

  @Override
  public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
    boolean active = plugin.setCakeRespawn(!plugin.isCakeRespawn());

    if (active) {
      sender.sendMessage(MiniMessage.miniMessage().deserialize("<green>Now the cake's will be respawned"));
    } else {
      sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Now the cake's will not be respawned"));
    }

    return true;
  }
}
