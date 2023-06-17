package com.vozuna.qrgen.model.enums;

public enum Colors {

    BLUE(0xFF40BAD0),
    RED(0xFFE91C43),
    PURPLE(0xFF8A4F9E),
    ORANGE(0xFFF4B13D),
    WHITE(0xFFFFFFFF),
    BLACK(0xFF000000),
    GREEN(0xFF00FF00),
    PINK(0xFFFFC0CB),
    GRAY(0xFF808080),
    YELLOW(0xFFFFFF00);

    private final int argb;

    Colors(final int argb){
        this.argb = argb;
    }

    public int getArgb(){
        return argb;
    }
}
