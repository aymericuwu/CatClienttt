package me.muffin.catclient.module;

import akka.event.LoggingAdapter;
import com.google.common.collect.FluentIterable;
import me.muffin.catclient.module.movement.Sprint;
import me.muffin.catclient.module.render.ClickGUI;
import me.muffin.catclient.module.render.HUD;

import java.util.ArrayList;

public class ModuleManager {

	public static ArrayList<Module> modules = new ArrayList<>();

	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();
		this.modules.add(new HUD());
		this.modules.add(new Sprint());
		this.modules.add(new me.muffin.catclient.module.combat.Velocity());
		this.modules.add(new me.muffin.catclient.module.combat.CrystalAura());
		this.modules.add(new me.muffin.catclient.module.combat.AutoTrap());
		this.modules.add(new me.muffin.catclient.module.combat.Burrow());
		this.modules.add(new me.muffin.catclient.module.combat.OffHand());
		this.modules.add(new me.muffin.catclient.module.combat.Surround());
		this.modules.add(new me.muffin.catclient.module.render.BurrowESP());
		this.modules.add(new me.muffin.catclient.module.combat.AutoArmour());
		this.modules.add(new me.muffin.catclient.module.combat.Crits());
		this.modules.add(new me.muffin.catclient.module.combat.KillAura());
		this.modules.add(new me.muffin.catclient.module.render.HoleESP());
		this.modules.add(new me.muffin.catclient.module.render.VoidESP());
		this.modules.add(new me.muffin.catclient.module.misc.DicsordRPC());
		this.modules.add(new me.muffin.catclient.module.misc.PacketFly());
		this.modules.add(new me.muffin.catclient.module.misc.FastPlace());
		this.modules.add(new me.muffin.catclient.module.player.FreeCam());
		this.modules.add(new me.muffin.catclient.module.player.NoHurtCam());
		this.modules.add(new me.muffin.catclient.module.player.Timer());
		this.modules.add(new me.muffin.catclient.module.movement.ReverseStep());
		this.modules.add(new me.muffin.catclient.module.movement.Step());
		this.modules.add(new me.muffin.catclient.module.movement.Strafe());
		this.modules.add(new me.muffin.catclient.module.render.FullBright());
		this.modules.add(new me.muffin.catclient.module.misc.AntiVoid());
		this.modules.add(new me.muffin.catclient.module.misc.MiddleClickFriends());
		this.modules.add(new me.muffin.catclient.module.misc.SpeedMine());
		this.modules.add(new me.muffin.catclient.module.misc.Cancer());
		this.modules.add(new ClickGUI());
	}

	private static int alphabetize(Module module1, Module module2) {
		return module1.getName().compareTo(module2.getName());
	}

	public static Module getModuleByName(String name) {
		return modules.stream()
				.filter(module -> module.getName().equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);
	}

	public Module getModule(String name) {
		for (Module m : this.modules) {
			if (m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModuleList() {
		return this.modules;
	}
	
	public ArrayList<Module> getModulesInCategory(Category c) {
		ArrayList<Module> mods = new ArrayList<Module>();
		for (Module m : this.modules) {
			if (m.getCategory() == c) {
				mods.add(m);
			}
		}
		return mods;
	}
}
