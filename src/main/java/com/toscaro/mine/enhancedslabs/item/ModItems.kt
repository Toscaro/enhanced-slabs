package com.toscaro.mine.enhancedslabs.item

import com.toscaro.mine.enhancedslabs.EnhancedSlabs
import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object ModItems {

    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, EnhancedSlabs.MOD_ID)

    fun register(eventBus: IEventBus) {
        ITEMS.register(eventBus)
    }
}