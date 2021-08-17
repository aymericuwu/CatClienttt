package me.muffin.catclient.module.render;

import me.muffin.catclient.CatClient;
import me.muffin.catclient.module.Category;
import me.muffin.catclient.module.Module;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {

	public ClickGUI() {
		super("ClickGUI", "menu.skeet", Category.RENDER);
		this.setKey(Keyboard.KEY_RCONTROL);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		mc.displayGuiScreen(CatClient.instance.clickGui);
		this.setToggled(false);
	}
}
