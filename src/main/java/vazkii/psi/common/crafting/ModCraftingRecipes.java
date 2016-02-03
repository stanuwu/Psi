/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 * 
 * Psi is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * 
 * File Created @ [25/01/2016, 20:38:39 (GMT)]
 */
package vazkii.psi.common.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import vazkii.psi.common.block.base.ModBlocks;
import vazkii.psi.common.item.base.ModItems;

public class ModCraftingRecipes {

	public static void init() {
		addOreDictRecipe(new ItemStack(ModBlocks.cadAssembler),
				"IPI", "I I", " I ",
				'I', "ingotIron",
				'P', new ItemStack(Blocks.piston));
		
		addOreDictRecipe(new ItemStack(ModBlocks.programmer),
				"IDI", "I I", "I I",
				'I', "ingotIron",
				'D', "dustPsi");
		
		addOreDictRecipe(new ItemStack(ModItems.cadAssembly, 1, 0),
				"III", "I  ",
				'I', "ingotIron");
		addOreDictRecipe(new ItemStack(ModItems.cadAssembly, 1, 1),
				"III", "I  ",
				'I', "ingotGold");
		addOreDictRecipe(new ItemStack(ModItems.cadAssembly, 1, 2),
				"III", "I  ",
				'I', "ingotPsi");
		
		addOreDictRecipe(new ItemStack(ModItems.cadCore, 1, 0),
				" I ", "IDI", " I ",
				'I', "ingotIron",
				'D', "dustPsi");
		addOreDictRecipe(new ItemStack(ModItems.cadCore, 1, 1),
				" I ", "IDI", " I ",
				'I', "ingotPsi",
				'D', "dustRedstone");
		addOreDictRecipe(new ItemStack(ModItems.cadCore, 1, 2),
				" I ", "IDI", " I ",
				'I', "ingotPsi",
				'D', "dustGlowstone");
		
		addOreDictRecipe(new ItemStack(ModItems.cadSocket, 1, 0),
				"DI", "I ",
				'I', "ingotIron",
				'D', "dustPsi");
		addOreDictRecipe(new ItemStack(ModItems.cadSocket, 1, 1),
				"DI", "I ",
				'I', "ingotPsi",
				'D', "dustRedstone");
		addOreDictRecipe(new ItemStack(ModItems.cadSocket, 1, 2),
				"DI", "I ",
				'I', "ingotPsi",
				'D', "dustGlowstone");
		
		addOreDictRecipe(new ItemStack(ModItems.cadBattery, 1, 0),
				"I", "D", "G",
				'I', "ingotIron",
				'G', "ingotGold",
				'D', "dustPsi");
		addOreDictRecipe(new ItemStack(ModItems.cadBattery, 1, 1),
				"I", "D", "G",
				'I', "ingotIron",
				'G', "ingotGold",
				'D', "ingotPsi");
		
        String[] dyes = {
            "White", "Orange", "Magenta", "LightBlue", "Yellow", "Lime", "Pink", "Gray", "LightGray", "Cyan", "Purple", "Blue", "Brown", "Green", "Red"," Black"
        };
		for(int i = 0; i < 16; i++)
			addOreDictRecipe(new ItemStack(ModItems.cadColorizer, 1, i),
					" D ", "GCG", " I ",
					'I', "ingotIron",
					'G', "blockGlass",
					'C', "dye" + dyes[i],
					'D', "dustPsi");
		addOreDictRecipe(new ItemStack(ModItems.cadColorizer, 1, 16),
				" D ", "GCG", " I ",
				'I', "ingotIron",
				'G', "blockGlass",
				'C', "crystalsPrismarine",
				'D', "dustPsi");
		
		addOreDictRecipe(new ItemStack(ModItems.spellBullet, 1, 0),
				"ID",
				'I', "ingotIron",
				'D', "dustPsi");
		addOreDictRecipe(new ItemStack(ModItems.spellBullet, 1, 2),
				"AID",
				'A', new ItemStack(Items.arrow),
				'I', "ingotIron",
				'D', "dustPsi");
		addOreDictRecipe(new ItemStack(ModItems.spellBullet, 1, 4),
				"AID",
				'A', new ItemStack(Items.string),
				'I', "ingotIron",
				'D', "dustPsi");
		addOreDictRecipe(new ItemStack(ModItems.spellBullet, 1, 6),
				"AID",
				'A', new ItemStack(Items.gunpowder),
				'I', "ingotIron",
				'D', "dustPsi");
		
		addOreDictRecipe(new ItemStack(ModItems.spellDrive),
				"I", "R", "I",
				'I', "ingotPsi",
				'R', "dustRedstone");
		
		addOreDictRecipe(new ItemStack(ModBlocks.psiDecorative, 1, 0), 
				"OOO", "OOO", "OOO",
				'O', "dustPsi");
		addOreDictRecipe(new ItemStack(ModBlocks.psiDecorative, 1, 1), 
				"OOO", "OOO", "OOO",
				'O', "ingotPsi");
		addOreDictRecipe(new ItemStack(ModBlocks.psiDecorative, 1, 2), 
				"OOO", "OOO", "OOO",
				'O', "gemPsi");
		addShapelessOreDictRecipe(new ItemStack(ModItems.material, 1, 0), new ItemStack(ModBlocks.psiDecorative, 1, 0));
		addShapelessOreDictRecipe(new ItemStack(ModItems.material, 1, 1), new ItemStack(ModBlocks.psiDecorative, 1, 1));
		addShapelessOreDictRecipe(new ItemStack(ModItems.material, 1, 2), new ItemStack(ModBlocks.psiDecorative, 1, 2));
		
		addOreDictRecipe(new ItemStack(ModBlocks.psiDecorative, 6, 3), 
				" C ", "CIC", " C ",
				'C', "coal",
				'I', "ingotPsi");
		addOreDictRecipe(new ItemStack(ModBlocks.psiDecorative, 6, 5), 
				" C ", "CIC", " C ",
				'C', "gemQuartz",
				'I', "ingotPsi");
		addShapelessOreDictRecipe(new ItemStack(ModBlocks.psiDecorative, 1, 4), new ItemStack(ModBlocks.psiDecorative, 1, 3), "dustGlowstone");
		addShapelessOreDictRecipe(new ItemStack(ModBlocks.psiDecorative, 1, 6), new ItemStack(ModBlocks.psiDecorative, 1, 5), "dustGlowstone");
	}
	
	private static void addOreDictRecipe(ItemStack output, Object... recipe) {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(output, recipe));
	}

	private static void addShapelessOreDictRecipe(ItemStack output, Object... recipe) {
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(output, recipe));
	}
	
}