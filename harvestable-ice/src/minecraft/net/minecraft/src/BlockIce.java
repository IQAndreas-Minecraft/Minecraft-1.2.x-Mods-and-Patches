package net.minecraft.src;

import java.util.Random;

public class BlockIce extends BlockBreakable
{
    public BlockIce(int par1, int par2)
    {
        super(par1, par2, Material.ice, false);
        slipperiness = 0.98F;
        setTickRandomly(true);
    }

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
        Material material = par1World.getBlockMaterial(par3, par4 - 1, par5);
        
        if (material.blocksMovement() || material.isLiquid())
        {
        	this.convertToWater(par1World, par3, par4, par5);
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if ((par1World.worldProvider.isHellWorld) || (par1World.getSavedLightValue(EnumSkyBlock.Block, par2, par3, par4) > 11 - Block.lightOpacity[blockID]))
        {
        	//Not sure why this is here or if it is needed. I'll just leave it.
            dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            
            this.convertToWater(par1World, par2, par3, par4); 
        }
    }
    

    /**
     * Destroys the water block and converts it to water (unless in the Nether)
     */
    public void convertToWater(World world, int x, int y, int z)
    {
    	if (world.worldProvider.isHellWorld)
        {
        	//Cannot create water in the nether, create air.
    		world.setBlockWithNotify(x, y, z, 0);
        	
        	//Taken from 'ItemBucket::onItemRightClick()'
    		world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
            for (int l = 0; l < 8; l++)
            {
            	world.spawnParticle("largesmoke", (double)x + Math.random(), (double)y + Math.random(), (double)z + Math.random(), 0.0D, 0.0D, 0.0D);
            }
        }
        else
        {
        	//Melts to water
        	world.setBlockWithNotify(x, y, z, Block.waterStill.blockID);
        }
    }


    /**
     * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
     * and stop pistons
     */
    public int getMobilityFlag()
    {
        return 0;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
    	//	Can now be harvested with silk touch
    	return super.createStackedBlock(par1);
    }
}
