package net.minecraft.src;

import java.util.Random;

public class BlockSilverfish extends Block
{
    public BlockSilverfish(int par1)
    {
        super(par1, 1, Material.clay);
        setHardness(0.0F);
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        if (par2 == 1)
        {
            return Block.cobblestone.blockIndexInTexture;
        }

        if (par2 == 2)
        {
            return Block.stoneBrick.blockIndexInTexture;
        }
        else
        {
            return Block.stone.blockIndexInTexture;
        }
    }

    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            EntitySilverfish entitysilverfish = new EntitySilverfish(par1World);
            entitysilverfish.setLocationAndAngles((double)par2 + 0.5D, par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(entitysilverfish);
            entitysilverfish.spawnExplosionParticle();
        }

        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	//Will drop the block it spawned out of as a standard block
    	
        if (par1 == 1)
        {
            return Block.cobblestone.idDropped(par1, par2Random, par3);
        }

        if (par1 == 2)
        {
            return Block.stoneBrick.idDropped(par1, par2Random, par3);
        }
        else
        {
            return Block.stone.idDropped(par1, par2Random, par3);
        }
    }

    /**
     * Gets the blockID of the block this block is pretending to be according to this block's metadata.
     */
    public static boolean getPosingIdByMetadata(int par0)
    {
        return par0 == Block.stone.blockID || par0 == Block.cobblestone.blockID || par0 == Block.stoneBrick.blockID;
    }

    /**
     * Returns the metadata to use when a Silverfish hides in the block. Sets the block to BlockSilverfish with this
     * metadata. It changes the displayed texture client side to look like a normal block.
     */
    public static int getMetadataForBlockType(int par0)
    {
        if (par0 == Block.cobblestone.blockID)
        {
            return 1;
        }

        return par0 != Block.stoneBrick.blockID ? 0 : 2;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        Block block = Block.stone;

        if (par1 == 1)
        {
            block = Block.cobblestone;
        }

        if (par1 == 2)
        {
            block = Block.stoneBrick;
        }

        return new ItemStack(block);
    }
}
