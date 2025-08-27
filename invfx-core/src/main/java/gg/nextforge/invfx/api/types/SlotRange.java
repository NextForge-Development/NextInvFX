package gg.nextforge.invfx.api.types;

import lombok.Value;

@Value
public class SlotRange {
    int fromRow, fromCol;
    int toRow, toCol;

    public boolean contains(SlotRef s) {
        return s.getRow() >= fromRow && s.getRow() <= toRow
                && s.getCol() >= fromCol && s.getCol() <= toCol;
    }
}
