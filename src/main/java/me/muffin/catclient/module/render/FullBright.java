package me.muffin.catclient.module.render;

import me.muffin.catclient.module.Category;
import me.muffin.catclient.module.Module;
import me.muffin.catclient.settings.BooleanSetting;
import me.muffin.catclient.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.SidedProxy;

public class FullBright extends Module {
    public FullBright() {
        super("FullBright", "Makes Game Brighter", Category.RENDER);
    }
}
