package fr.luna.blockcode;

import fr.luna.blockcode.mixin.CollectingNeighborUpdaterAcessor;
import fr.luna.blockcode.mixin.LevelAcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class maxUpdate extends Block {
    public maxUpdate(Properties properties) {
        super(properties);
    }
    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        BlockPos bp = blockPos.above();
        Block b = level.getBlockState(bp).getBlock();
        while (((CollectingNeighborUpdaterAcessor)((LevelAcessor)level).getNeighborUpdater()).getCount() < ((CollectingNeighborUpdaterAcessor)((LevelAcessor)level).getNeighborUpdater()).getMaxChainedNeighborUpdates()) {
            level.neighborChanged(blockPos, b, bp);
        }
    }
}