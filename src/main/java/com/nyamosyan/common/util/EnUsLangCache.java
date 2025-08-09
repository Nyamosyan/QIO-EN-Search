package com.nyamosyan.common.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.ClientLanguage;

import java.util.List;

public final class EnUsLangCache {
    private static ClientLanguage cache;

    public static String getEnUsName(String translationKey) {
        if(cache == null) {
            cache = ClientLanguage.loadFrom(
                    Minecraft.getInstance().getResourceManager(),
                    List.of("en_us"),
                    false
            );
        }
        return cache.getOrDefault(translationKey);
    }

    public static void clear() {
        cache = null;
    }

    private EnUsLangCache() {}
}
