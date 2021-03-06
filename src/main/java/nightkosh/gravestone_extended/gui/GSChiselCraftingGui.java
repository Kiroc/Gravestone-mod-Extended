package nightkosh.gravestone_extended.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.fml.client.config.GuiCheckBox;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone.ModGraveStone;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone.api.grave.EnumGraveType;
import nightkosh.gravestone.block.enums.EnumGraves;
import nightkosh.gravestone.gui.GuiContainerBase;
import nightkosh.gravestone_extended.block.enums.EnumMemorials;
import nightkosh.gravestone_extended.block.enums.EnumMemorials.EnumMemorialType;
import nightkosh.gravestone_extended.core.MessageHandler;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.gui.container.ChiselContainer;
import nightkosh.gravestone_extended.gui.slider.ChiselGraveTypeSlider;
import nightkosh.gravestone_extended.gui.slider.ChiselMaterialSlider;
import nightkosh.gravestone_extended.gui.slider.ChiselMemorialTypeSlider;
import nightkosh.gravestone_extended.packets.ChiselMessageToServer;
import nightkosh.gravestone_extended.renderer.tileentity.GraveInGuiRenderer;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class GSChiselCraftingGui extends GuiContainerBase {

    private EntityPlayer player;

    private final int GRAVE_BUTTON_ID = 0;
    private final int MEMORIAL_BUTTON_ID = 1;
    private final int GRAVE_TYPE_SLIDER_ID = 3;
    private final int MEMORIAL_TYPE_SLIDER_ID = 4;
    private final int MATERIAL_SLIDER_ID = 5;

    private final int IS_ENCHANTED_CHECKBOX_ID = 6;
    private final int IS_MOSSY_CHECKBOX_ID = 7;

    private final String GRAVE_BUTTON_STR = ModGraveStone.proxy.getLocalizedString("gui.chisel_crafting.grave_btn");
    private final String MEMORIAL_BUTTON_STR = ModGraveStone.proxy.getLocalizedString("gui.chisel_crafting.memorial_btn");
    private final String ENCHANTED_BUTTON_STR = ModGraveStone.proxy.getLocalizedString("gui.chisel_crafting.enchanted_btn");
    private final String MOSSY_BUTTON_STR = ModGraveStone.proxy.getLocalizedString("gui.chisel_crafting.mossy_btn");
    private final String REQUIRED_ITEMS_STR = ModGraveStone.proxy.getLocalizedString("gui.chisel_crafting.recipe");

    private GuiButton graveButton;
    private GuiButton memorialButton;

    private ChiselGraveTypeSlider graveTypeSlider;
    private ChiselMemorialTypeSlider memorialTypeSlider;

    private boolean isGravestone = ChiselContainer.DEFAULT_IS_GRAVESTONE;
    private EnumGraveType graveType = ChiselContainer.DEFAULT_GRAVE_TYPE;
    private EnumMemorialType memorialType = ChiselContainer.DEFAULT_MEMORIAL_TYPE;
    private EnumGraveMaterial material = ChiselContainer.DEFAULT_MATERIAL;
    private boolean isEnchanted = ChiselContainer.DEFAULT_IS_ENCHANTED;
    private boolean isMossy = ChiselContainer.DEFAULT_IS_MOSSY;
    //TODO sword;

    public GSChiselCraftingGui(EntityPlayer player, InventoryPlayer inventoryPlayer) {
        super(new ChiselContainer(player, inventoryPlayer));
        this.player = player;
    }

    @Override
    public void initGui() {
        super.initGui();
        final int HALF_W = (width - xSize) / 2;

        this.buttonList.add(graveButton = new GuiButton(GRAVE_BUTTON_ID, HALF_W, 20, 75, 20, this.GRAVE_BUTTON_STR) {
            @Override
            public void mouseReleased(int mouseX, int mouseY) {
                updateSlidersAndButtonsState(true);
            }
        });
        this.buttonList.add(memorialButton = new GuiButton(MEMORIAL_BUTTON_ID, HALF_W + 100, 20, 75, 20, this.MEMORIAL_BUTTON_STR) {
            @Override
            public void mouseReleased(int mouseX, int mouseY) {
                updateSlidersAndButtonsState(false);
            }
        });
        graveButton.enabled = false;

        //type
        this.buttonList.add(graveTypeSlider = new ChiselGraveTypeSlider(GRAVE_TYPE_SLIDER_ID, HALF_W, 45, 176, 20, 0, this));
        this.buttonList.add(memorialTypeSlider = new ChiselMemorialTypeSlider(MEMORIAL_TYPE_SLIDER_ID, HALF_W, 45, 176, 20, 0, this));
        memorialTypeSlider.visible = false;

        //material
        this.buttonList.add(new ChiselMaterialSlider(MATERIAL_SLIDER_ID, HALF_W, 70, 176, 20, 0, this));

        this.buttonList.add(new GuiCheckBox(IS_ENCHANTED_CHECKBOX_ID, HALF_W, 95, ENCHANTED_BUTTON_STR, false));
        this.buttonList.add(new GuiCheckBox(IS_MOSSY_CHECKBOX_ID, HALF_W + 75, 95, MOSSY_BUTTON_STR, false));

        this.sendMessage();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1, 1, 1, 1);
        this.mc.renderEngine.bindTexture(Resources.CHISEL_GUI);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        this.drawTexturedModalRect(x, y + 30, 0, 0, 256, ySize);

        this.drawString(this.fontRenderer, this.REQUIRED_ITEMS_STR, x + 185, y + 133, 16777215);

        if (isGravestone) {
            GraveInGuiRenderer.renderGraveInGui(x + 215, y - 7, EnumGraves.getByTypeAndMaterial(graveType, material), isEnchanted, isMossy, par1);
        } else {
            GraveInGuiRenderer.renderMemorialInGui(x + 215, y + 43, EnumMemorials.getByTypeAndMaterial(memorialType, material), isEnchanted, isMossy, par1);
        }
    }

    @Override
    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case IS_ENCHANTED_CHECKBOX_ID:
                this.isEnchanted = !this.isEnchanted;
                this.sendMessage();
                break;
            case IS_MOSSY_CHECKBOX_ID:
                this.isMossy = !this.isMossy;
                this.sendMessage();
                break;
        }
    }

    private void updateSlidersAndButtonsState(boolean isGravestone) {
        this.isGravestone = isGravestone;
        this.graveButton.enabled = !this.isGravestone;
        this.memorialButton.enabled = this.isGravestone;
        this.graveTypeSlider.visible = this.isGravestone;
        this.memorialTypeSlider.visible = !this.isGravestone;
        this.sendMessage();
    }

    public void sendMessage() {
        if (this.player.world.isRemote) {
            MessageHandler.networkWrapper.sendToServer(new ChiselMessageToServer(player, isGravestone, graveType.ordinal(), memorialType.ordinal(), material.ordinal(), isEnchanted, isMossy));
        }
    }

    public void setGraveType(EnumGraveType graveType) {
        this.graveType = graveType;
        this.sendMessage();
    }

    public void setMemorialType(EnumMemorialType memorialType) {
        this.memorialType = memorialType;
        this.sendMessage();
    }

    public void setMaterial(EnumGraveMaterial material) {
        this.material = material;
        this.sendMessage();
    }

    public EnumGraveMaterial getMaterial() {
        return material;
    }
}
