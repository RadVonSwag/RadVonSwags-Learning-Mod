package net.radslearning.Main.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback.LootTableSetter;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.radslearning.Main.item.RadsItems;

public class RadsLootTableModifiers {
    public static final Logger LOGGER = LoggerFactory.getLogger("Rad's Learning");
    private static final Identifier VILLAGE_PLAINS_HOUSE_ID = new Identifier("minecraft", "chests/village/village_plains_house");
    private static final Identifier VILLAGE_DESERT_HOUSE_ID = new Identifier("minecraft", "chests/village/village_desert_house");
    private static final Identifier VILLAGE_SAVANNA_HOUSE_ID = new Identifier("minecraft", "chests/village/village_savanna_house");
    private static final Identifier VILLAGE_SNOWY_HOUSE_ID = new Identifier("minecraft", "chests/village/village_snowy_house");
    private static final Identifier VILLAGE_TAIGA_HOUSE_ID = new Identifier("minecraft", "chests/village/village_taiga_house");
    private static final Identifier PILLAGER_OUTPOST_ID = new Identifier("minecraft", "chests/pillager_outpost");
    private static final Identifier SIMPLE_DUNGEON_ID = new Identifier("minecraft", "chests/simple_dungeon");
    private static final Identifier JUNGLE_TEMPLE_ID = new Identifier("minecraft", "chests/jungle_temple");

    public static void ModifyLootTables() {
        coughSyrupLoot();
    }

    private static void coughSyrupLoot() {
        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            if (VILLAGE_PLAINS_HOUSE_ID.equals(id)) {
                addCoughSyrup(VILLAGE_PLAINS_HOUSE_ID, resourceManager, manager, id, supplier, setter);
            } else if (VILLAGE_DESERT_HOUSE_ID.equals(id)) {
                addCoughSyrup(VILLAGE_DESERT_HOUSE_ID, resourceManager, manager, id, supplier, setter);
            } else if (VILLAGE_SAVANNA_HOUSE_ID.equals(id)) {
                addCoughSyrup(VILLAGE_SAVANNA_HOUSE_ID, resourceManager, manager, id, supplier, setter);
            } else if (VILLAGE_SNOWY_HOUSE_ID.equals(id)) {
                addCoughSyrup(VILLAGE_SNOWY_HOUSE_ID, resourceManager, manager, id, supplier, setter);
            } else if (VILLAGE_TAIGA_HOUSE_ID.equals(id)) {
                addCoughSyrup(VILLAGE_TAIGA_HOUSE_ID, resourceManager, manager, id, supplier, setter);
            } else if (PILLAGER_OUTPOST_ID.equals(id)) {
                addCoughSyrup(PILLAGER_OUTPOST_ID, resourceManager, manager, id, supplier, setter);
            } else if (SIMPLE_DUNGEON_ID.equals(id)) {
                addCoughSyrup(SIMPLE_DUNGEON_ID, resourceManager, manager, id, supplier, setter);
            } else if (JUNGLE_TEMPLE_ID.equals(id)) {
                addCoughSyrup(JUNGLE_TEMPLE_ID, resourceManager, manager, id, supplier, setter);
            }
        }));
    }

    private static void addCoughSyrup(Identifier table, ResourceManager resourceManager, LootManager manager, Identifier id, FabricLootSupplierBuilder supplier, LootTableSetter setter) {
            if (table.equals(id)) {
                LOGGER.info("Modifying " + table.toString() + " loot table...");
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(4))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(RadsItems.COUGH_SYRUP))
                        .withFunction(
                                SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
        }
}
