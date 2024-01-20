package com.toscaro.mine.enhancedslabs.block

import com.toscaro.mine.enhancedslabs.EnhancedSlabs
import com.toscaro.mine.enhancedslabs.item.ModItems
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import java.util.function.Supplier

object ModBlocks {

    private val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, EnhancedSlabs.MOD_ID)

    val WOOD_VERTICAL_SLAB: RegistryObject<Block> = registerBlock(
            name = "wood_vertical_slab",
            blockSupplier = { Block(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)) },
    )

//    val STONE_VERTICAL_SLAB: RegistryObject<Block> = registerBlock(
//            name = "STONE Vertical Slab",
//            blockSupplier = { Block(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)) },
//    )

    fun register(eventBus: IEventBus) {
        BLOCKS.register(eventBus)
    }

    private fun registerBlock(
            name: String,
            blockSupplier: Supplier<out Block>,
    ) = BLOCKS.register(name, blockSupplier).apply {
        registerBlockItem(name, this)
    }

    private fun registerBlockItem(
            name: String,
            block: RegistryObject<out Block>,
    ): RegistryObject<Item> = ModItems.ITEMS.register(name) {
        BlockItem(block.get(), Item.Properties())
    }

}