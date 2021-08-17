package me.muffin.catclient.settings;

public class KeyBindSetting extends Setting {
    public int code;

    public KeyBindSetting(int code) {
        this.name = "Key Bind";
        this.code = code;
    }

    public int getKeyCode() {
        return this.code;
    }

    public void setKeyCode(int code) {
        this.code = code;
    }

    @Override
    public String getType() {
        return null;
    }
}
