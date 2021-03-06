package elec332.core.client.model;

import elec332.core.api.client.model.IElecModelBakery;
import elec332.core.api.client.model.IElecQuadBakery;
import elec332.core.api.client.model.IElecTemplateBakery;
import elec332.core.api.client.model.ModelLoadEvent;
import elec332.core.client.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Elec332 on 21-11-2015.
 */
@SideOnly(Side.CLIENT)
class ModelLoadEventImpl extends ModelLoadEvent {

    ModelLoadEventImpl(IElecQuadBakery quadBakery, IElecModelBakery modelBakery, IElecTemplateBakery templateBakery, IRegistry<ModelResourceLocation, IBakedModel> registry){
        this.quadBakery = quadBakery;
        this.modelBakery = modelBakery;
        this.templateBakery = templateBakery;
        this.registry = registry;
    }

    private final IElecQuadBakery quadBakery;
    private final IElecModelBakery modelBakery;
    private final IElecTemplateBakery templateBakery;
    private final IRegistry<ModelResourceLocation, IBakedModel> registry;

    @Override
    @Nonnull
    public IElecQuadBakery getQuadBakery() {
        return quadBakery;
    }

    @Override
    @Nonnull
    public IElecModelBakery getModelBakery() {
        return modelBakery;
    }

    @Override
    @Nonnull
    public IElecTemplateBakery getTemplateBakery() {
        return templateBakery;
    }

    @Override
    public void registerModel(ModelResourceLocation mrl, IBakedModel model){
        registry.putObject(mrl, model);
    }

    @Override
    @Nullable
    public IBakedModel getModel(ModelResourceLocation mrl) {
        return registry.getObject(mrl);
    }

    @Override
    @Nonnull
    public IBakedModel getMissingModel() {
        return RenderHelper.getMissingModel();
    }

}
