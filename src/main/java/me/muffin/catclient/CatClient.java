package me.muffin.catclient;

import org.lwjgl.input.Keyboard;

import me.muffin.catclient.clickgui.ClickGui;
import me.muffin.catclient.module.Module;
import me.muffin.catclient.module.ModuleManager;
import me.muffin.catclient.settings.SettingsManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class CatClient
//if you read this you are a sussy baka owo
{
    public static CatClient instance;
    public ModuleManager moduleManager;
    public SettingsManager settingsManager;
    public ClickGui clickGui;
    public static final String MOD_ID = "catclient";
    public static final String MOD_NAME = "CatClient";
    public static final String MOD_VERSION = "v1.0.4";
    public static final String NAME_VERSION = MOD_VERSION + " " + MOD_NAME;

    public void init() {
    	MinecraftForge.EVENT_BUS.register(this);
    	settingsManager = new SettingsManager();
    	moduleManager = new ModuleManager();
    	clickGui = new ClickGui();
    }
    
    @SubscribeEvent
    public void key(KeyInputEvent e) {
    	if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
    		return; 
    	try {
             if (Keyboard.isCreated()) {
                 if (Keyboard.getEventKeyState()) {
                     int keyCode = Keyboard.getEventKey();
                     if (keyCode <= 0)
                    	 return;
                     for (Module m : moduleManager.modules) {
                    	 if (m.getKey() == keyCode && keyCode > 0) {
                    		 m.toggle();
                    	 }
                     }
                 }
             }
         } catch (Exception q) { q.printStackTrace(); }
    }
}
