package me.muffin.catclient.event.events;

import me.muffin.catclient.event.EventStage;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class ChatEvent extends EventStage
{
    private final String msg;

    public ChatEvent(final String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
