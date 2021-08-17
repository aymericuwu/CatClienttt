package me.muffin.catclient.module;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.muffin.catclient.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

import java.lang.annotation.Annotation;
import java.util.*;

public class Module {
	Minecraft mc = Minecraft.getMinecraft();
	private final String name = getAnnotation().name();

	private String name() {
	}

	private final String description = getAnnotation().description();

	private String description() {
	}

	private final Category category = getAnnotation().category();

	private Category category() {
	}

	private int key = getAnnotation().key();

	private boolean enabled = false;
	private boolean opened = false;
	private boolean binding = false;
	private boolean drawn = true;

	private final ArrayList<Setting<?>> settings = new ArrayList<>();

	private Module getAnnotation() {
		if (getClass().isAnnotationPresent(Module)) {
			return getClass().getAnnotation(Module);
		}

		throw new IllegalStateException("Annotation 'FeroxModule' not found!");
	}

	public boolean nullCheck() {
		return mc.player == null || mc.world == null;
	}

	public void enable() {
		enabled = true;

		MinecraftForge.EVENT_BUS.register(this);

		onEnable();

		handleNotifications(true);
	}

	public void disable() {
		enabled = false;

		MinecraftForge.EVENT_BUS.unregister(this);

		onDisable();

		handleNotifications(false);
	}

	private void handleNotifications(boolean enable) {
		if (nullCheck()) return;

		String message;
		String narratorMessage;

		if (enable) {
			message = ChatFormatting.AQUA + name + ChatFormatting.RESET + " is now " + ChatFormatting.GREEN + "ENABLED";
			narratorMessage = name + " is now enabled";
		} else {
			message = ChatFormatting.AQUA + name + ChatFormatting.RESET + " is now " + ChatFormatting.RED + "DISABLED";
			narratorMessage = name + " is now disabled";
		}

	}

	public void toggle() {
		try {
			if (enabled) {
				disable();
			} else {
				enable();
			}
		} catch (Exception ignored) {}
	}

	public void setEnabled(boolean enabled) {
		if (enabled) {
			enable();
		} else {
			disable();
		}
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public void setBinding(boolean binding) {
		this.binding = binding;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public int getKey() {
		return key;
	}

	public boolean isOpened() {
		return opened;
	}

	public boolean isBinding() {
		return binding;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public ArrayList<Setting<?>> getSettings() {
		return settings;
	}

	public void addSettings(Setting<?>... settings) {
		this.settings.addAll(Arrays.asList(settings));
	}

	public boolean hasSettings() {
		return this.settings.size() > 0;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public boolean isDrawn() {
		return drawn;
	}

	public void setDrawn(boolean drawn) {
		this.drawn = drawn;
	}

	public String getArraylistInfo() {
		return "";
	}

	public void onEnable() {}

	public void onDisable() {}

	public void onUpdate() {}
}
