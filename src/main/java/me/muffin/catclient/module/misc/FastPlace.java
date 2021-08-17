package me.muffin.catclient.module.misc;

import me.muffin.catclient.module.Category;
import me.muffin.catclient.module.Module;

public class FastPlace extends Module {
    private transient int nativeDelay;

    public FastPlace() {
        super("FastPlace", "Places items and blocks fast", Category.MISC);
    }
}