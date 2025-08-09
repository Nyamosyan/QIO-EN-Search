package com.nyamosyan.client;

import com.nyamosyan.common.QIOENSearch;
import com.nyamosyan.common.util.EnUsLangCache;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = QIOENSearch.MODID, value = Dist.CLIENT)
public final class ClientReloads {
    @SubscribeEvent
    public static void onRegisterReloads(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(new SimplePreparableReloadListener<Void>() {
            @Override
            protected @NotNull Void prepare(@NotNull ResourceManager rm, @NotNull ProfilerFiller pf) {return null;}

            @Override
            protected void apply(@NotNull Void v, @NotNull ResourceManager rm, @NotNull ProfilerFiller pf) {
                EnUsLangCache.clear();
            }
        });
    }
}
