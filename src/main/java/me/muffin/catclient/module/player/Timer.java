package me.muffin.catclient.module.player;

import me.muffin.catclient.module.Category;
import me.muffin.catclient.module.Module;
import me.muffin.catclient.settings.NumberSetting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Timer extends Module {

    public NumberSetting speed = new NumberSetting("Timer",this, 20, 1, 300, 1);
    public Timer() {
        super("Timer", "SPEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEED", Category.PLAYER);
        this.addSetting(speed);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        mc.timer.ticklength = 50f;
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent event) {
        mc.timer.ticklength = (float) (50f / (speed.getValue() / 10f));
    }


}
