package me.muffin.catclient.module.render;

import me.muffin.catclient.CatClient;
import me.muffin.catclient.module.Category;
import me.muffin.catclient.module.Module;
import me.muffin.catclient.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HUD extends Module {

	public HUD() {
		super("HUD", "modules on screen", Category.RENDER);
	}
	
	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent egoe) {
		/*if (!egoe.type.equals(egoe.type.CROSSHAIRS)) {
			return;
		}*/
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		int y = 2;
		for (Module mod : CatClient.instance.moduleManager.getModuleList()) {
			if (!mod.getName().equalsIgnoreCase("HUD") && mod.isToggled() && mod.visible) {
				FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
				fr.drawString(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName()) - 1, y, 0x5555FF);
				y += fr.FONT_HEIGHT;
			}
		}
	}
}
