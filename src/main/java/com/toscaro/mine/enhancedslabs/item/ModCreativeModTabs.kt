package com.toscaro.mine.enhancedslabs.item

import com.toscaro.mine.enhancedslabs.EnhancedSlabs
import com.toscaro.mine.enhancedslabs.block.ModBlocks
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject

object ModCreativeModTabs {

    private val CREATIVE_MOD_TABS: DeferredRegister<CreativeModeTab> = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB,
            EnhancedSlabs.MOD_ID,
    )

    val ENHANCED_SLABS_MOD_TAB: RegistryObject<CreativeModeTab> = CREATIVE_MOD_TABS.register("enhanced_slabs_tab") {
        CreativeModeTab.builder()
                .icon { ItemStack(Items.DARK_OAK_SLAB) }
                .title(Component.translatable("creativetab.enhanced_slabs_tab"))
                .displayItems { _, pOutput -> pOutput.accept(ModBlocks.WOOD_VERTICAL_SLAB.get()) }
                .build()
    }

    fun register(eventBus: IEventBus) {
        CREATIVE_MOD_TABS.register(eventBus)
    }
}