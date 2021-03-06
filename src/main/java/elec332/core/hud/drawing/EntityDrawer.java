package elec332.core.hud.drawing;

import elec332.core.hud.position.Alignment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Elec332 on 13-1-2017.
 */
public class EntityDrawer implements IDrawer<Entity> {

    public static final IDrawer<Entity> INSTANCE = new EntityDrawer(0, 0, 30);

    public EntityDrawer(float xOffset, float yOffset, float scale){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.scale = scale;
    }

    private final float xOffset, yOffset, scale;

    @Override
    @SideOnly(Side.CLIENT)
    public int draw(Entity drawable, Minecraft mc, Alignment alignment, int x, int y, Object... data) {
        x += xOffset;
        y += yOffset;
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, 50.0F);

        float scale = this.scale;

        if (data != null){
            if (data.length > 0){
                GlStateManager.rotate((float) data[0], 0, 1, 0);
            }
            if (data.length > 1) {
                scale = scale / (float) data[1];
            }
        }

        GlStateManager.scale(-scale, scale, scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = mc.getRenderManager();
        rendermanager.setPlayerViewY(180);
        rendermanager.setRenderShadow(false);
        rendermanager.doRenderEntity(drawable, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
        rendermanager.setRenderShadow(true);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return (int) drawable.width;
    }

}
