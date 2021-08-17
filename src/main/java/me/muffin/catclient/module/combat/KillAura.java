package me.muffin.catclient.module.combat;

import com.mojang.authlib.properties.Property;
import me.muffin.catclient.CatClient;
import me.muffin.catclient.clickgui.component.components.Button;
import me.muffin.catclient.module.Category;
import me.muffin.catclient.module.Module;
import me.muffin.catclient.settings.Setting;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHand;
import scala.Int;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KillAura extends Module{
    public KillAura() {
        super("Killa Aura", "Kills enemiez", Category.COMBAT);
    }
}
