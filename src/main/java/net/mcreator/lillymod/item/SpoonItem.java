
package net.mcreator.lillymod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.block.BlockState;

import net.mcreator.lillymod.LillymodModElements;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

@LillymodModElements.ModElement.Tag
public class SpoonItem extends LillymodModElements.ModElement {
	@ObjectHolder("lillymod:spoon")
	public static final Item block = null;
	public SpoonItem(LillymodModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("spoon");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
			if (slot == EquipmentSlotType.MAINHAND) {
				ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
				builder.putAll(super.getAttributeModifiers(slot));
				builder.put(Attributes.ATTACK_DAMAGE,
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Item modifier", (double) -1.9, AttributeModifier.Operation.ADDITION));
				builder.put(Attributes.ATTACK_SPEED,
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "Item modifier", -2.4, AttributeModifier.Operation.ADDITION));
			}
			return super.getAttributeModifiers(slot);
		}
	}
}
