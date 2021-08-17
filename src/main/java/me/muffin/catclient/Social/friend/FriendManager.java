package me.muffin.catclient.Social.friend;

import me.muffin.catclient.module.ModuleManager;
import me.muffin.catclient.module.misc.Social;

import java.util.ArrayList;

public final class FriendManager {
    private static final ArrayList<Friend> friends = new ArrayList<>();

    public static boolean isFriend(String name) {
        boolean isFriend = false;

        for (Friend friend : getFriends()) {
            if (friend.getName().equalsIgnoreCase(name) && ModuleManager.getModuleByName("Social").isEnabled() && Social.friend.getValue()) {
                isFriend = true;
            }
        }

        return isFriend;
    }

    public static Friend getFriendByName(String name) {
        Friend namedFriend = null;

        for (Friend friend : getFriends()) {
            if (friend.getName().equalsIgnoreCase(name)) {
                namedFriend = friend;
            }
        }

        return namedFriend;
    }

    public static ArrayList<Friend> getFriends() {
        return friends;
    }

    public static void addFriend(String name) {
        friends.add(new Friend(name));
    }

    public static void delFriend(String name) {
        friends.remove(getFriendByName(name));
    }
}
