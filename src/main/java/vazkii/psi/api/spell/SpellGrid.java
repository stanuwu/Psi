/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 * 
 * Psi is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * 
 * File Created @ [16/01/2016, 15:19:16 (GMT)]
 */
package vazkii.psi.api.spell;

import org.lwjgl.opengl.GLSync;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class SpellGrid {

	private static final String TAG_WIDTH = "w";
	private static final String TAG_HEIGHT = "h";
	private static final String TAG_SPELL_LIST = "spellList";
	private static final String TAG_SPELL_POS_X = "spellPosX";
	private static final String TAG_SPELL_POS_Y = "spellPosY";
	private static final String TAG_SPELL_DATA = "spellData";
	
	public final Spell spell;
	public SpellPiece[][] gridData; 
	public int w, h;
	
	@SideOnly(Side.CLIENT)
	public void draw() {
	for(int i = 0; i < w; i++)
		for(int j = 0; j < h; j++) {
			SpellPiece p = gridData[i][j];
			if(p != null) {
				GlStateManager.pushMatrix();
				GlStateManager.translate(i * 18, j * 18, 0);
				p.draw();
				GlStateManager.popMatrix();
			}
		}
	}
	
	public SpellGrid(Spell spell, int w, int h) {
		this.spell = spell;
		this.w = w;
		this.h = h;
		gridData = new SpellPiece[w][h];
	}
	
	public void readFromNBT(NBTTagCompound cmp) {
		w = cmp.getInteger(TAG_WIDTH);
		h = cmp.getInteger(TAG_HEIGHT);
		gridData = new SpellPiece[w][h];
		
		NBTTagList list = cmp.getTagList(TAG_SPELL_LIST, cmp.getId());
		int len = list.tagCount();
		for(int i = 0; i < len; i++) {
			NBTTagCompound lcmp = list.getCompoundTagAt(i);
			int posX = lcmp.getInteger(TAG_SPELL_POS_X);
			int posY = lcmp.getInteger(TAG_SPELL_POS_Y);
			
			NBTTagCompound data = lcmp.getCompoundTag(TAG_SPELL_DATA);
			SpellPiece piece = SpellPiece.createFromNBT(spell, data);
			gridData[w][h] = piece;
		}
	}
	
	public void writeToNBT(NBTTagCompound cmp) {
		cmp.setInteger(TAG_WIDTH, w);
		cmp.setInteger(TAG_HEIGHT, h);
		
		NBTTagList list = new NBTTagList();
		for(int i = 0; i < w; i++)
			for(int j = 0; j < h; j++) {
				SpellPiece piece = gridData[i][j];
				if(piece != null) {
					NBTTagCompound lcmp = new NBTTagCompound();
					lcmp.setInteger(TAG_SPELL_POS_X, i);
					lcmp.setInteger(TAG_SPELL_POS_Y, j);
					
					NBTTagCompound data = new NBTTagCompound();
					piece.writeToNBT(data);
					lcmp.setTag(TAG_SPELL_DATA, data);
					
					list.appendTag(lcmp);
				}
			}
		
		cmp.setTag(TAG_SPELL_LIST, list);
	}
	
}
