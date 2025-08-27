package gg.nextforge.invfx.impl.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public final class Components {
    private static final MiniMessage MM = MiniMessage.miniMessage();

    public static Component mm(String input) {
        return input == null ? Component.empty() : MM.deserialize(input);
    }
}
