package fr.luna.blockcode;

import fr.luna.blockcode.mixin.ServerLevelAcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class lightSupressionBlock extends Block {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public lightSupressionBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, Boolean.valueOf(false)));
    }

    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        long nb = 0;
        if (level instanceof ServerLevel serverLevel) {
            try
            {
                SignBlockEntity ble = (SignBlockEntity)level.getBlockEntity(blockPos.above());
                nb = Integer.parseInt(ble.getFrontText().getMessages(true)[0].getString());
            } catch (Exception ignored) {
                nb = 1;
            }
            for (long i = 0; i<nb; i++) {
                //serverLevel.setBlock(blockPos, blockState.cycle(LIT), 3);

                ((ServerLevelAcessor)(serverLevel)).getChunkSource().getLightEngine().checkBlock(blockPos);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
}
