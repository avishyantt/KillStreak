package com.example.killstreak;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class KillStreakPlugin extends JavaPlugin implements Listener {

    private final HashMap<UUID, Integer> streaks = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new KillStreakPlaceholder(this).register();
            getLogger().info("KillStreak placeholder registered!");
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player dead = event.getEntity();
        Player killer = dead.getKiller();

        streaks.remove(dead.getUniqueId()); // reset dead player's streak

        if (killer != null && killer != dead) {
            streaks.put(killer.getUniqueId(), streaks.getOrDefault(killer.getUniqueId(), 0) + 1);
        }
    }

    public int getStreak(Player player) {
        return streaks.getOrDefault(player.getUniqueId(), 0);
    }
}
