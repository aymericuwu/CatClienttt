package me.muffin.catclient.module.combat;

import me.muffin.catclient.module.Category;
import me.muffin.catclient.module.Module;
import me.muffin.catclient.settings.NumberSetting;
import me.muffin.catclient.settings.Setting;
import me.muffin.catclient.util.TargetUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.BlockPos;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public final class CrystalAura extends Module {
    public CrystalAura() {
        super("Crystal Aura", "ca", Category.COMBAT);
        Minecraft mc = Minecraft.getMinecraft();
//break stuff
        public static final Setting<Boolean> crystalBreak = new Setting<>("Break", "Breaks crystals", true);
        public static final Setting<BreakMode> breakMode = new Setting<>(crystalBreak, "Type", "Mode for how crystal is broken duh", BreakModes.Packet);
        public static final Setting<SwingModes> swingMode = new Setting<>(crystalBreak, "Swing", "Which hand u want to swing", Swingmodes.None);
        public static final Setting<SyncModes> syncMode = new Setting<>(crystalBreak, "Sync", "Sync crystalsz", SynceModes.None);
        public static final Setting<Boolean> antiWeakness = new Setting<>(crystalBreak, "AntiWeakness", "Does the weakness thing w crysstalsz", false);
        public static final Setting<Boolean> throughWalls = new Setting<>(crystalBreak, "Thru Wallz", "lets crystalz break thru wallz", true);
        public static final NumberSetting<Double> breakrange = new NumberSetting<>(crystalBreak, "BreakRange", "Range for breaking crystals", 0.0, 6.0, 5.0, 1);
        public static final NumberSetting<Integer> breakAttempts = new NumberSetting<>(crystalBreak, "BreakAttempts", "Amount of times u try to break a crystal", 1, 5, 1, 0);
        public static final NumberSetting<Integer> breakDelay = new NumberSetting<>(crystalBreak, "BreakDelay", "Delay when u breeak tha crystal", 0, 2, 20, 0);
//place stuff
        public static final Setting<Boolean> crystalPlace = new Setting<>("Place", "Places crystals", true);
        public static final Setting<PlaceModes> placeMode = new Setting<>(crystalPlace, "Type", "Mode for how crystlaz r placed", PlaceModes.Packet);
        public static final Setting<Boolean> autoSwitch = new Setting<>(crystalPlace, "AutoSwitch", "Switchs to crystal when ya place em", false);
        public static final Setting<Boolean> raytrace = new Setting<>(crystalPlace, "RayTrace", "Raytraces placements", true);
        public static final Setting<Boolean> multiPlace = new Setting<>(crystalPlace, "MultiPlace", "places multiple crystals", false);
        public static final Setting<Boolean> predictPlace = new Setting<>(crystalPlace, "Predict", "Predicts where its gunna be", true);
        public static final Setting<Boolean> verifyPlace = new Setting<>(crystalPlace, "Verify", "verifies if its allowed to place", false);
        public static final NumberSetting<Double> placeRange = new NumberSetting<>(crystalPlace, "PlaceRange", "Range where u can place crytsals", 0.0, 6.0, 5.0, 1);
        public static final NumberSetting<Double> wallRange = new NumberSetting<>(crystalPlace, "Walls Range", "Range where u can place crystals thru wallz", 0.0, 5.0, 5.0, 1);
        public static final NumberSetting<Double> maxSelfDamage = new NumberSetting<>(crystalPlace, "MaxSelfDmg", "Maximum amount of damage u can take from", 0.0, 36.0, 8.0, 1);
        public static final NumberSetting<Integer> placeDelay = new NumberSetting<>(crystalPlace, "Place Delay", "The delay when u place a crystal", 0.0, 5.0, 2.0, 1);
//rotations owo
        public static final Setting<Boolean> crystalRotations = new Setting<>("Rotate", "Allows you to rotate", false);
        public static final Setting<RotationModes> rotateMode = new Setting<>(crystalRotations, "Rotate Mode", "Mode for rotations", RotationModes.Packet);
        public static final Setting<RoateWheMode> rotateWhen = new Setting<>(crystalRotations, "Rotate When", "When it rotates", RotateWhen.Packet);
//predictions
        public static final Setting<Boolean> crystalCalculations = new Setting<>("calculations", "Calculates when to place and break", true);
        public static final Setting<LogicModes> logicMode = new Setting<>(crystalCalculations"Logic Mode", "Uses logic ._.", LogicModes.Break);
        public static final Setting<BlockLogicModes> blockLogicMode = new Setting<>(crystalCalculations, "Block Logic Mode", "Uses block logic ._.", BlockLogicModes.Twelve);
        public static final NumberSetting<Double> targeRange = new NumberSetting<>(crystalCalculations, "Target Range", "Range of the targets", 0.0, 8.0, 6.0, 1);
//pawz
        public static final Setting<Boolean> crystalPause = new Setting<>("Pause", "Pauses the ca when doing something", true);
        public static final Setting<Boolean> pauseHealthAllow = new Setting<>(crystalPause, "Specified Health", "Pauses ca when ur health lo", true);
        public static final NumberSetting<Double> pauseHealth = new NumberSetting<>(crystalPause, "Pause Health", "Health to pause the ca", 0.0, 36.0, 12.0, 1);
        public static final Setting<Boolean> pauseWhileMining = new Setting<>(crystalPause, "Pause Mining", "pauses ca when u mine (dont use)", false);
        public static final Setting<Boolean> pauseWhileEating = new Setting<>(crystalPause, "Pause Eat", "pauses when u eat (dont use)", false);
//colours-render
        public static final Setting<Boolean>  crystalRender = new Setting<>("Crystal Render", "Choose what colour u want the crysstal to be so that it looks hella sexy", true);
        public static final Setting<BlockRenderModes> blockRenderMode = new Setting<>(crystalRender, "Block Render", "What kind of box u wanna hax it to render", BlockRenderModes.Full);
        public static final Setting<TextRenderModes> textRenderMode = new Setting<>(crystalRender, "Text Render", "Renders text duh ._.", TextRenderModes.Both);
        public static final NumberSetting<Double> outlineWidth = new NumberSetting<>(crystalRender, "Outline Width", "Width of the outline", 1.0, 5.0, 2.0, 1);
        public static final Setting<Color> renderColor = new Settting<>(crystalRender, "Colour", "What colour u want tha crystal to be", new Color(0, 232, 237, 180));

        public CrystalAura() {
            this.addSetting(
                    crystalBreak,
                    crystalPlace,
                    crystalCalculations,
                    crystalPause,
                    crystalRotations,
                    crystalRender
            );
        }

        private final CooldownUtil breakTimer = new CooldownUtil();
        private final CooldownUtil placeTimer = new CooldownUtil();

        private EntityPlayer playerTarget = null;
        private CrystalPosition crystalTarget = new CrystalPosition(null, 0, 0);

        @Override
        private void onDisable() {
            if (nullCheck()) return;

            playerTarget = null;
            crystalTarget = null;

        }

        public void onUpdate() {
            if (nullCheck()) return;

            playerTarget = TargetUtil.getClosestPlayer(targetRange.getValue());

            implementLogic();
        }

        private void implementLogic() {
            switch (logicMode.getValue()) {
                case BreakPlace:
                    breakCrystal();
                    placeCrystal();
                    break;
                    case placeBreak();
                    placeCrystal();
                    breakCrystal();

            }
        }

        private void breakCrystal() {
            if (handlePause()) return;

            if (crystalBreak.getValue()) {
                EntityEnderCrystal entityEnderCrystal = (EntityEnderCrystal) mc.world.loadedEntityList.stream()
                        .filter(entity -> entity instanceof EntityEnderCrystal)
                        .min(Comparator.comparing(entity -> mc.player.getDistance(entity)))
                        .orElse(null);

                if (entityEnderCrystal != null && !entityEnderCrystal.isDead && breakTimer.passed(breakDelay.getValue()) * 60) {
                    if (!(mc.player.getDistance(entityEnderCrystal) <= breakrange.getValue())) return;

                    if (!(mc.player.canEntityBeSeen(entityEnderCrystal) && ! throughWalls.getValue())) return;

                    if (antiWeakness.getValue() && mc.player.isPotionActive(MobEffects.WEAKNESS)) {
                        InventoryUtil.switchToSlot(ItemSword.class);
                    }

                    if (crystalRotations.getValue()) {
                        if (rotateWhen.getValue() == RotateWhenModes.Break || rotateWhen.getValue() == RotateWhenModes.Both) {
                            RotationManager.rotateToEntity(entityEnderCrystal, rotateMode.getValue() == RotateWhenModes.Packet);
                        }

                        handleBreak(entityEnderCrystal);

                        if(syncMode.getValue() == SyncModes.Attack) {
                            entityEnderCrystal.setDead();
                        }

                        breakTimer.reset();

                    }
                }
            }

            private void placeCrystal() {
                if(handlePause()) return;

                if (crystalPlace.getValue()) {
                    List<CrystalPosition> crystalPositions = new ArrayList<>();

                    CrystalPosition tempPosition;

                    for (BlockPos blockPos : crystalBlocks(mc.player, placeRange.getValue(), predictPlace.getValue(), !multiPlace.getValue(), blockLogicMode.getValue() == BlockLogicModes.Thirteen)) {
                        if (PlayerUtil.isInViewFrutrum(blockPos) && mc.player.getDistanceSq(blockPos.getX() + 0.5, blockPos.getY() + 1, blockPos.getZ() + 0.5, playerTarget));
                    }
                }
            }
        }
     }
}
