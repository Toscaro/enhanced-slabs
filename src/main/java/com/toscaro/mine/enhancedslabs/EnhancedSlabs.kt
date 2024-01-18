package com.toscaro.mine.enhancedslabs

import com.mojang.logging.LogUtils
import net.minecraft.client.Minecraft
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.slf4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_CONTEXT

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EnhancedSlabs.MOD_ID)
class EnhancedSlabs {
    init {
        val modEventBus = MOD_CONTEXT.getKEventBus()

        modEventBus.addListener(this::commonSetup)

        MinecraftForge.EVENT_BUS.register(this)
        modEventBus.addListener(this::addCreative)
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {

    }

    private fun addCreative(event: BuildCreativeModeTabContentsEvent) {

    }

    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent?) {
        LOGGER.info("On server starting")
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
    object ClientModEvents {
        @SubscribeEvent
        fun onClientSetup(event: FMLClientSetupEvent?) {
            LOGGER.info("On client setup")
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().user.name)
        }
    }

    companion object {
        const val MOD_ID: String = "enhanced_slabs"

        // Directly reference a slf4j logger
        private val LOGGER: Logger = LogUtils.getLogger()
    }
}
