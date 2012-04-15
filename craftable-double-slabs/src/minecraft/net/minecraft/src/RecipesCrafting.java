package net.minecraft.src;

public class RecipesCrafting
{
    public RecipesCrafting()
    {
    }

    /**
     * Adds the crafting recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager par1CraftingManager)
    {
        par1CraftingManager.addRecipe(new ItemStack(Block.chest), new Object[]
                {
                    "###", "# #", "###", '#', Block.planks
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.stoneOvenIdle), new Object[]
                {
                    "###", "# #", "###", '#', Block.cobblestone
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.workbench), new Object[]
                {
                    "##", "##", '#', Block.planks
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.sandStone), new Object[]
                {
                    "##", "##", '#', Block.sand
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.sandStone, 4, 2), new Object[]
                {
                    "##", "##", '#', Block.sandStone
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.stoneBrick, 4), new Object[]
                {
                    "##", "##", '#', Block.stone
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.fenceIron, 16), new Object[]
                {
                    "###", "###", '#', Item.ingotIron
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.thinGlass, 16), new Object[]
                {
                    "###", "###", '#', Block.glass
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.redstoneLampIdle, 1), new Object[]
                {
                    " R ", "RGR", " R ", 'R', Item.redstone, 'G', Block.glowStone
                });
        
        /* ---------- Double half-slab blocks -------
        	0x0	 Stone Slab
   	 		0x1	 Sandstone Slab
   	 		0x2	 Wooden Slab
   	 		0x3	 Cobblestone Slab
   	 		0x4	 Brick Slab
   	 		0x5	 Stone Brick Slab
   	 	*/
        
        par1CraftingManager.addRecipe(new ItemStack(Block.stairDouble, 1, 0), new Object[]
                { // Smooth stone double slabs
                    "#", "#", '#', new ItemStack(Block.stairSingle, 1, 0)
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.sandStone, 1, 1), new Object[]
                { // Sandstone (creates special sandstone blocks)
                    "#", "#", '#', new ItemStack(Block.stairSingle, 1, 1)
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.stairDouble, 1, 2), new Object[]
                { // Wooden slab (creates fireproof wood blocks)
                    "#", "#", '#', new ItemStack(Block.stairSingle, 1, 2)
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.stairDouble, 1, 3), new Object[]
                {
        			// Cobblestone block (not double slab!)
                    //"#", "#", '#', new ItemStack(Block.stairSingle, 1, 3)
        			"#", "#", '#', new ItemStack(Block.cobblestone)
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.stairDouble, 1, 4), new Object[]
                { 
        			// Brick block (not double slab!)
                    //"#", "#", '#', new ItemStack(Block.stairSingle, 1, 4)
        			"#", "#", '#', new ItemStack(Block.brick)
                });
        par1CraftingManager.addRecipe(new ItemStack(Block.stairDouble, 1, 5), new Object[]
                { 
        			// Stone brick block (not double slab!)
                    //"#", "#", '#', new ItemStack(Block.stairSingle, 1, 5)
        			"#", "#", '#', new ItemStack(Block.stoneBrick)
                });
    }
}
