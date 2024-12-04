package com.vladmarica.modnametooltips;

import net.minecraft.util.Formatting;

public enum TooltipTextColor {
    BLUE(Formatting.BLUE),
    RED(Formatting.RED);

    private Formatting formatting;

    TooltipTextColor(Formatting formatting) {
        this.formatting = formatting;
    }
}
