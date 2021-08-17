package me.muffin.catclient.module.misc;

import me.muffin.catclient.module.Category;
import me.muffin.catclient.module.Module;
import me.muffin.catclient.settings.Setting;

import java.awt.*;

public class Social extends Module {
    public Social() {
        super("Social", "get frens owo", Category.MISC);
        public static final Setting<Boolean> friends = new Setting<>("Friends", "Allows for usage of the friends system", true);
        public static final Setting<Color> friendColour = new Setting<>(friends, "Friend Colour", "The colour to render friends with", new Color(0, 150, 200, 255));

        public static final Setting<Boolean> enemies = new Setting<>("Enemies", "Allows for usage of the enemy system", true);
        public static final Setting<Color> enemyColour = new Setting<>(enemies, "Enemy Colour", "The colour to render enemies with", new Color(255, 0, 0, 100));

        public Social() {
            this.addSettings(
                    friends,
                    enemies
            );

            this.setEnabled
        }
    }

