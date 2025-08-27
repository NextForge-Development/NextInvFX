package gg.nextforge.invfx.api.item.impl;

import gg.nextforge.invfx.api.item.ItemDescriptor;

public interface RichItemDescriptor extends ItemDescriptor {
    String getMaterial();
    String getDisplayName();
    java.util.List<String> getLore();
    boolean isGlowing();
}