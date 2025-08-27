package gg.nextforge.invfx.binding.bukkit.util;

import org.bukkit.Bukkit;

public final class BukkitVersions {
    private BukkitVersions() {}

    public static String serverVersion() {
        String pkg = Bukkit.getServer().getClass().getPackage().getName();
        int i = pkg.lastIndexOf('.');
        return i > -1 ? pkg.substring(i + 1) : "unknown";
    }
}
