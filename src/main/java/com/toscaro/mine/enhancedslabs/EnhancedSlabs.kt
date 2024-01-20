package com.toscaro.mine.enhancedslabs

import com.mojang.logging.LogUtils
import com.toscaro.mine.enhancedslabs.block.ModBlocks
import com.toscaro.mine.enhancedslabs.item.ModCreativeModTabs
import com.toscaro.mine.enhancedslabs.item.ModItems
import net.minecraft.client.Minecraft
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.slf4j.Logger
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.MOD_CONTEXT
import thedarkcolour.kotlinforforge.forge.runForDist

@Mod(EnhancedSlabs.MOD_ID)
object EnhancedSlabs {

    const val MOD_ID: String = "enhanced_slabs"

    // Directly reference a slf4j logger
    private val LOGGER: Logger = LogUtils.getLogger()

    init {
        val modEventBus = MOD_CONTEXT.getKEventBus()

        ModCreativeModTabs.register(modEventBus)
        ModItems.register(modEventBus)
        ModBlocks.register(modEventBus)

        modEventBus.addListener(this::commonSetup)

        FORGE_BUS.register(this)
        modEventBus.addListener(this::addCreative)

        val obj = runForDist(
                clientTarget = {
                    MOD_BUS.addListener(::onClientSetup)
                    Minecraft.getInstance()
                },
                serverTarget = {
                    MOD_BUS.addListener(::onServerSetup)
                    "test"
                },
        )

        println(obj)
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {

    }

    private fun addCreative(event: BuildCreativeModeTabContentsEvent) {

    }

    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        LOGGER.info("On server starting")
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.info("Initializing client...")
        LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().user.name)
    }
}
