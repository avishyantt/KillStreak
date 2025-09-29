package me.clip.placeholderapi.expansion;

public abstract class PlaceholderExpansion {
    public abstract boolean canRegister();
    public abstract String getIdentifier();
    public abstract String getAuthor();
    public abstract String getVersion();
    public abstract String onPlaceholderRequest(Object player, String identifier);

    public boolean register() {
        return true; // stub
    }
}
