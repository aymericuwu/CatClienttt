package me.muffin.catclient.module.notification;

import me.muffin.catclient.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

public final class Notifications implements Minecraft {
    private final String title;
    private final String message;
    private final NotificationType notificationType;
    Minecraft mc = Minecraft.getMinecraft();

    private final ResourceLocation infoIcon = new ResourceLocation("ferox", "images/info_icon.png");
    private final ResourceLocation warningIcon = new ResourceLocation("ferox", "images/warning_icon.png");
    private final ResourceLocation normalIcon = new ResourceLocation("ferox", "images/normal_icon.png");

    public Notifications(String title, String message, NotificationType notificationType) {
        this.title = title;
        this.message = message;
        this.notificationType = notificationType;

    }

    public void renderNotification(int x, int y) {
        Gui.drawRect(x, y, x + 200, y + 30, new Color(20, 20, 20, 100).getRGB());

        switch (notificationType) {
            case Info:
                mc.getTextureManager().bindTexture(infoIcon);
                Gui.drawModalRectWithCustomSizedTexture(x + 2, y + 2, 0, 0, 26, 26, 26, 26);
                break;
            case Warning:
                mc.getTextureManager().bindTexture(warningIcon);
                Gui.drawModalRectWithCustomSizedTexture(x + 2, y + 2, 0, 0, 26, 26, 26, 26);
                break;
            case Normal:
                mc.getTextureManager().bindTexture(normalIcon);
                Gui.drawModalRectWithCustomSizedTexture(x + 2, y + 2, 0, 0, 26, 26, 26, 26);
                break;
        }

    }

    }

