package fr.luna.blockcode.mixin;

import fr.luna.blockcode.BlockItemStorage;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import static net.minecraft.world.item.Items.registerBlock;

@Mixin(Items.class)
public class AddItemMixin {

    @Inject(at = @At("HEAD"), method = "<clinit>")
    private static void addItem(CallbackInfo ci){
        BlockItemStorage.SupressionItem = registerBlock(BlockItemStorage.SupressionBlock);
        BlockItemStorage.SkipperItem = registerBlock(BlockItemStorage.SkipperBlock);
        BlockItemStorage.lightSupressionItem = registerBlock(BlockItemStorage.lightSupressionBlock);
        BlockItemStorage.maxUpdateItem = registerBlock(BlockItemStorage.maxUpdateBlock);
        BlockItemStorage.passUpdateItem = registerBlock(BlockItemStorage.passUpdateBlock);
    }
}