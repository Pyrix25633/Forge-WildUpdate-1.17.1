package net.pyrix25633.wild_update.block;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.pyrix25633.wild_update.WildUpdate;
import net.pyrix25633.wild_update.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WildUpdate.MOD_ID);

    // Blocks:
    public static final RegistryObject<Block> MUD_BRICKS = registerBlock("mud_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.2f, 3f)
                    .destroyTime(2f)));
    public static final RegistryObject<Block> MUD_BLOCK = registerBlock("mud_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(0.7f, 1f)
                    .destroyTime(1.5f).speedFactor(0.9f).jumpFactor(0.8f)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
