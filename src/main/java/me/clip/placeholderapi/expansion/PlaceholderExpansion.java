package me.clip.placeholderapi.expansion;

import org.bukkit.entity.Player;

public abstract class PlaceholderExpansion {

    public abstract boolean canRegister();

    public abstract String getIdentifier();

    public abstract String getAuthor();

    public abstract String getVersion();

    // Must match exactly what your KillStreakPlaceholder overrides
    public abstract String onPlaceholderRequest(Player player, String identifier);

    public boolean register() {
        return true; // fake registration for compile only
    }
}
