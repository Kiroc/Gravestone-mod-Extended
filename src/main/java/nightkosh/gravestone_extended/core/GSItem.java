package nightkosh.gravestone_extended.core;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import nightkosh.gravestone_extended.core.compatibility.Compatibility;
import nightkosh.gravestone_extended.core.compatibility.forestry.CompatibilityForestry;
import nightkosh.gravestone_extended.item.*;
import nightkosh.gravestone_extended.item.armor.bone.ItemBoneBoots;
import nightkosh.gravestone_extended.item.armor.bone.ItemBoneChestplate;
import nightkosh.gravestone_extended.item.armor.bone.ItemBoneHelmet;
import nightkosh.gravestone_extended.item.armor.bone.ItemBoneLeggings;
import nightkosh.gravestone_extended.item.armor.mummy_costume.ItemMummyBoots;
import nightkosh.gravestone_extended.item.armor.mummy_costume.ItemMummyChestplate;
import nightkosh.gravestone_extended.item.armor.mummy_costume.ItemMummyHelmet;
import nightkosh.gravestone_extended.item.armor.mummy_costume.ItemMummyLeggings;
import nightkosh.gravestone_extended.item.armor.phantom_diver_costume.ItemDivingBoots;
import nightkosh.gravestone_extended.item.armor.phantom_diver_costume.ItemDivingChestplate;
import nightkosh.gravestone_extended.item.armor.phantom_diver_costume.ItemDivingHelmet;
import nightkosh.gravestone_extended.item.armor.phantom_diver_costume.ItemDivingLeggings;
import nightkosh.gravestone_extended.item.armor.swamp_thing_costume.ItemSwampThingBoots;
import nightkosh.gravestone_extended.item.armor.swamp_thing_costume.ItemSwampThingChestplate;
import nightkosh.gravestone_extended.item.armor.swamp_thing_costume.ItemSwampThingHelmet;
import nightkosh.gravestone_extended.item.armor.swamp_thing_costume.ItemSwampThingLeggings;
import nightkosh.gravestone_extended.item.tools.ItemBoneFishingPole;
import nightkosh.gravestone_extended.item.tools.ItemChisel;
import nightkosh.gravestone_extended.item.tools.axe.ItemBoneAxe;
import nightkosh.gravestone_extended.item.tools.axe.ItemDiamondBoneAxe;
import nightkosh.gravestone_extended.item.tools.axe.ItemGoldenBoneAxe;
import nightkosh.gravestone_extended.item.tools.axe.ItemIronBoneAxe;
import nightkosh.gravestone_extended.item.tools.hoe.ItemBoneHoe;
import nightkosh.gravestone_extended.item.tools.hoe.ItemDiamondBoneHoe;
import nightkosh.gravestone_extended.item.tools.hoe.ItemGoldenBoneHoe;
import nightkosh.gravestone_extended.item.tools.hoe.ItemIronBoneHoe;
import nightkosh.gravestone_extended.item.tools.pickaxe.ItemBonePickaxe;
import nightkosh.gravestone_extended.item.tools.pickaxe.ItemDiamondBonePickaxe;
import nightkosh.gravestone_extended.item.tools.pickaxe.ItemGoldenBonePickaxe;
import nightkosh.gravestone_extended.item.tools.pickaxe.ItemIronBonePickaxe;
import nightkosh.gravestone_extended.item.tools.shovel.ItemBoneShovel;
import nightkosh.gravestone_extended.item.tools.shovel.ItemDiamondBoneShovel;
import nightkosh.gravestone_extended.item.tools.shovel.ItemGoldenBoneShovel;
import nightkosh.gravestone_extended.item.tools.shovel.ItemIronBoneShovel;
import nightkosh.gravestone_extended.item.weapon.*;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@GameRegistry.ObjectHolder(ModInfo.ID)
public class GSItem {

    public static final Item CHISEL = new ItemChisel();
    public static final Item SPAWN_EGG = new ItemGSMonsterPlacer();
    public static final Item BONE_SWORD = new ItemBoneSword();
    public static final Item BONE_SWORD_IRON = new ItemIronBoneSword();
    public static final Item BONE_SWORD_GOLDEN = new ItemGoldenBoneSword();
    public static final Item BONE_SWORD_DIAMOND = new ItemDiamondBoneSword();
    public static final Item BONE_SHIELD = new ItemBoneShield();

    public static final Item BONE_FISHING_POLE = new ItemBoneFishingPole();
    public static final Item BONE_HOE = new ItemBoneHoe();
    public static final Item BONE_HOE_IRON = new ItemIronBoneHoe();
    public static final Item BONE_HOE_GOLDEN = new ItemGoldenBoneHoe();
    public static final Item BONE_HOE_DIAMOND = new ItemDiamondBoneHoe();

    public static final Item BONE_SHOVEL = new ItemBoneShovel();
    public static final Item BONE_SHOVEL_IRON = new ItemIronBoneShovel();
    public static final Item BONE_SHOVEL_GOLDEN = new ItemGoldenBoneShovel();
    public static final Item BONE_SHOVEL_DIAMOND = new ItemDiamondBoneShovel();

    public static final Item BONE_AXE = new ItemBoneAxe();
    public static final Item BONE_AXE_IRON = new ItemIronBoneAxe();
    public static final Item BONE_AXE_GOLDEN = new ItemGoldenBoneAxe();
    public static final Item BONE_AXE_DIAMOND = new ItemDiamondBoneAxe();

    public static final Item BONE_PICKAXE = new ItemBonePickaxe();
    public static final Item BONE_PICKAXE_IRON = new ItemIronBonePickaxe();
    public static final Item BONE_PICKAXE_GOLDEN = new ItemGoldenBonePickaxe();
    public static final Item BONE_PICKAXE_DIAMOND = new ItemDiamondBonePickaxe();

    public static final Item BONE_HELMET = new ItemBoneHelmet();
    public static final Item BONE_CHESTPLATE = new ItemBoneChestplate();
    public static final Item BONE_LEGGINGS = new ItemBoneLeggings();
    public static final Item BONE_BOOTS = new ItemBoneBoots();

    public static final Item DIVING_HELMET = new ItemDivingHelmet();
    public static final Item DIVING_CHESTPLATE = new ItemDivingChestplate();
    public static final Item DIVING_LEGGINGS = new ItemDivingLeggings();
    public static final Item DIVING_BOOTS = new ItemDivingBoots();

    public static final Item SWAMP_THING_HELMET = new ItemSwampThingHelmet();
    public static final Item SWAMP_THING_CHESTPLATE = new ItemSwampThingChestplate();
    public static final Item SWAMP_THING_LEGGINGS = new ItemSwampThingLeggings();
    public static final Item SWAMP_THING_BOOTS = new ItemSwampThingBoots();

    public static final Item MUMMY_HELMET = new ItemMummyHelmet();
    public static final Item MUMMY_CHESTPLATE = new ItemMummyChestplate();
    public static final Item MUMMY_LEGGINGS = new ItemMummyLeggings();
    public static final Item MUMMY_BOOTS = new ItemMummyBoots();

    public static final Item SLIME_CHUNK = new ItemSlimeChunk();
    public static final Item IMP_SKULL = new ItemImpSkull();
    public static final Item ENDER_SKULL = new ItemEnderSkull();

    public static final Item CEMETERY_KEY = new ItemCemeteryKey();

    public static final Item FROZEN_MIRROR = new ItemFrozenMirror();

    public static final Item TOXIC_SLIME = new ItemToxicSlime();
    public static final Item BAT_WING = new ItemBatWing();
    public static final Item OOZE = new ItemOoze();
    public static final Item PIECE_OF_MUMMY_CLOTH = new ItemPieceOfMummyCloth();
    public static final Item RAVEN_FEATHER = new ItemRavenFeather();
    public static final Item RAVEN_CLAWS = new ItemRavenClaws();
    public static final Item PIECE_OF_DIVING_SUIT = new ItemPieceOfDivingSuit();
    public static final Item ENCHANTED_SKULL = new ItemEnchantedSkull();

    @Mod.EventBusSubscriber(modid = ModInfo.ID)
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();
            registry.registerAll(TOXIC_SLIME, BAT_WING, OOZE, PIECE_OF_MUMMY_CLOTH, RAVEN_FEATHER, RAVEN_CLAWS, PIECE_OF_DIVING_SUIT);
            registry.registerAll(SLIME_CHUNK, IMP_SKULL, ENDER_SKULL, CEMETERY_KEY, FROZEN_MIRROR);
            registry.registerAll(CHISEL,
                    BONE_PICKAXE, BONE_PICKAXE_IRON, BONE_PICKAXE_GOLDEN, BONE_PICKAXE_DIAMOND,
                    BONE_AXE, BONE_AXE_IRON, BONE_AXE_GOLDEN, BONE_AXE_DIAMOND,
                    BONE_SHOVEL, BONE_SHOVEL_IRON, BONE_SHOVEL_GOLDEN, BONE_SHOVEL_DIAMOND,
                    BONE_HOE, BONE_HOE_IRON, BONE_HOE_GOLDEN, BONE_HOE_DIAMOND);
            if (Compatibility.isModLoaded(Compatibility.ADVANCED_FISHING_ID)) {
                registry.register(BONE_FISHING_POLE);
            }
            registry.registerAll(BONE_SWORD, BONE_SWORD_IRON, BONE_SWORD_GOLDEN, BONE_SWORD_DIAMOND, BONE_SHIELD);
            registry.registerAll(BONE_HELMET, BONE_CHESTPLATE, BONE_LEGGINGS, BONE_BOOTS,
                    DIVING_HELMET, DIVING_CHESTPLATE, DIVING_LEGGINGS, DIVING_BOOTS,
                    SWAMP_THING_HELMET, SWAMP_THING_CHESTPLATE, SWAMP_THING_LEGGINGS, SWAMP_THING_BOOTS,
                    MUMMY_HELMET, MUMMY_CHESTPLATE, MUMMY_LEGGINGS, MUMMY_BOOTS);
            registry.registerAll(ENCHANTED_SKULL, SPAWN_EGG);
            if (Compatibility.isModLoaded(Compatibility.FORESTRY_ID)) {
                CompatibilityForestry.addBackpack(registry);
            }
        }
    }
}
