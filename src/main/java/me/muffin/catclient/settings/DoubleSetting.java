package me.muffin.catclient.settings;

public class DoubleSetting extends Setting{
    public double value;
    private final transient double nativevalue;

    public DoubleSetting(String name, double nativevalue) {
        super(name);
        this.nativevalue = nativevalue;
        value = nativevalue;
    }

    public double getNativevalue() {
        return nativevalue;
    }
    @Override
    public String getType() {
        return null;
    }
}
