package me.muffin.catclient.settings;

import me.muffin.catclient.module.render.HoleESP;

public class BooleanSetting extends Setting {
    public boolean value;
    private final transient boolean nativevalue;

    public BooleanSetting(String name, HoleESP holeESP, boolean nativevalue) {
        super(name);
        this.nativevalue = nativevalue;
        value = nativevalue;
    }

    public boolean getNativeValue() {
        return nativevalue;
    }

    @Override
    public String getType() {
        return null;
    }
}
