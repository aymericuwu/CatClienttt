package me.muffin.catclient.util;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.muffin.catclient.CatClient;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public final class MessageUtil implements Minecraft {
    Minecraft mc = Minecraft.getMinecraft();
    private static final String prefix = ChatFormatting.GRAY + "[" + ChatFormatting.GOLD + CatClient.NAME_VERSION + ChatFormatting.GRAY + "]";

    public static void sendClientMessage(String message) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(prefix + " " + ChatFormatting.WHITE + message));
    }
}
}
