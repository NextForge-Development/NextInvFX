package gg.nextforge.invfx.api.types;

import lombok.Value;

@Value
public class SlotRef {
    int row;
    int col;

    public int index(int cols) {
        if (row < 0 || col < 0 || cols <= 0) throw new IllegalArgumentException("Invalid slot");
        return row * cols + col;
    }
}