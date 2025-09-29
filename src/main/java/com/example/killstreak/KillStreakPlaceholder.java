package com.example.killstreak;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class KillStreakPlaceholder extends PlaceholderExpansion {

    private final KillStreakPlugin plugin;

    public KillStreakPlaceholder(KillStreakPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String getIdentifier() {
        return "killstreak_count_as";
    }

    @Override
    public String getAuthor() {
        return "You";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null) return "0";

        if (identifier.equals("count_as")) {
            return String.valueOf(plugin.getStreak(player));
        }

        return null;
    }
}
