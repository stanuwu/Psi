package vazkii.psi.client.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.InputMappings;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.glfw.GLFW;
import vazkii.psi.api.spell.SpellGrid;
import vazkii.psi.api.spell.SpellPiece;
import vazkii.psi.client.gui.GuiProgrammer;

import java.util.ArrayList;
import java.util.List;

public class SideConfigWidget extends Widget {

	public final List<Button> configButtons = new ArrayList<>();
	public boolean configEnabled = false;
	public final GuiProgrammer parent;


	public SideConfigWidget(int x, int y, int width, int height, GuiProgrammer programmer) {
		super(x, y, width, height, "");
		this.parent = programmer;
	}


	@Override
	protected boolean isValidClickButton(int p_isValidClickButton_1_) {
		return false;
	}

	@Override
	public void renderButton(int mouseX, int mouseY, float pTicks) {
		SpellPiece piece = null;
		if (SpellGrid.exists(GuiProgrammer.selectedX, GuiProgrammer.selectedY))
			piece = parent.spell.grid.gridData[GuiProgrammer.selectedX][GuiProgrammer.selectedY];
		if (configEnabled && !parent.takingScreenshot) {
			blit(parent.left - 81, parent.top + 55, parent.xSize, 30, 81, 115);
			String configStr = I18n.format("psimisc.config");
			parent.getMinecraft().fontRenderer.drawString(configStr, parent.left - parent.getMinecraft().fontRenderer.getStringWidth(configStr) - 2, parent.top + 45, 0xFFFFFF);

			int i = 0;
			if (piece != null) {
				int param = -1;
				for (int j = 0; j < 4; j++)
					if (InputMappings.isKeyDown(parent.getMinecraft().getWindow().getHandle(), GLFW.GLFW_KEY_1 + j))
						param = j;

				for (String s : piece.params.keySet()) {
					int x = parent.left - 75;
					int y = parent.top + 70 + i * 26;

					RenderSystem.color3f(1F, 1F, 1F);
					parent.getMinecraft().getTextureManager().bindTexture(GuiProgrammer.texture);
					blit(x + 50, y - 8, parent.xSize, 145, 24, 24);

					String localized = I18n.format(s);
					if (i == param)
						localized = TextFormatting.UNDERLINE + localized;

					parent.getMinecraft().fontRenderer.drawString(localized, x, y, 0xFFFFFF);

					i++;
				}
			}
		}
	}
}
