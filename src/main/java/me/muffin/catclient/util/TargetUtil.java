package me.muffin.catclient.util;

import me.muffin.catclient.Social.friend.FriendManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public final class TargetUtil implements Minecraft {
    public static EntityPlayer getClosestPlayer(double range) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.world.getLoadedEntityList().size() == 0) return null;

        return mc.world.playerEntities.stream()
                .filter(entityPlayer -> entityPlayer != mc.player)
                .filter(entityPlayer -> !entityPlayer.isDead)
                .filter(entityPlayer -> mc.player.getDistance(entityPlayer) <= range)
                .filter(entityPlayer -> !FriendManager.isFriend(entityPlayer.getName()))
                .findFirst()
                .orElse(null);
    }
}
