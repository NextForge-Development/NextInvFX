package gg.nextforge.invfx.api.item.impl;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import net.kyori.adventure.text.Component;

public interface RichItemDescriptor extends ItemDescriptor {
    String getMaterial();
    Component getDisplayName();
    java.util.List<Component> getLore();
    boolean isGlowing();
}