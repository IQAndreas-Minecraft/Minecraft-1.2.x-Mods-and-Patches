package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

public enum AnaglyphMode 
{
	// See http://en.wikipedia.org/wiki/Anaglyph_3D
	//  (not following the list to the book, but rounding off quite severely)
	
	OFF(			0x20, "OFF", 						true, true, true,		true, true, true),
	RED_CYAN(		0x21, "RED/CYAN (Default)",			true, false, false,	false, true, true),
	GREEN_MAGENTA(	0x22, "Trioscopic (GREEN/MAGENTA)",	false, true, false,	true, false, true),
	COLORCODE_3D(	0x23, "ColorCode 3D (AMBER/DARK BLUE)", true, true, false,	false, false, true),
	RED_GREEN(		0x24, "RED/GREEN",					true, false, false,	false, true, false),
	RED_BLUE(		0x25, "RED/BLUE",					true, false, false,	false, false, true);
	
	// I hate making this a non-automatically assigned value like this
	private static final int MAX_ID = 0x25;

	public static String[] getModes()
	{
		ArrayList modes = new ArrayList();		
		for (AnaglyphMode mode : AnaglyphMode.values())
		{
			modes.add(mode.name);
		}
		
		String[] array = new String[modes.size()];
		return (String[]) modes.toArray(array);
	};
	
	// This function allows the adding, removing, and re-ordering of modes.
	// This would not be possible by having an automatic index.
	public static AnaglyphMode getByID(int id)
	{
		for (AnaglyphMode mode : AnaglyphMode.values())
		{
			if (mode.id == id) { return mode; }
		}
		
		// Mode not found
		return null;
	}
	
	
	private AnaglyphMode(int id, String name, boolean leftR, boolean leftG, boolean leftB, boolean rightR, boolean rightG, boolean rightB)
	{
		this.id = id;
		this.name = name;
		
		this.leftR = leftR;
		this.leftG = leftG;
		this.leftB = leftB;
		
		this.rightR = rightR;
		this.rightG = rightG;
		this.rightB = rightB;
	}
	
	// Switch to the next mode in the list. Should never return 'null'
	public AnaglyphMode getNext(int count)
	{
		int targetID = this.id + count;
		
		while (targetID <= MAX_ID)
		{
			AnaglyphMode targetMode = AnaglyphMode.getByID(targetID);
			if (targetMode != null) { return targetMode; }
			
			//else, keep searching, skipping all the "gaps".
			targetID++;
		}
			
		//At beginning
		return OFF;
	}
	
	private static final int LEFT = 1;
	private static final int RIGHT = 0;
	// This is dirty!!
	// But I have no other choice. GL11 is a class, not an instance.
	public void applyToGL11(int anaglyphField, boolean alpha)
	{
		if (anaglyphField == LEFT)
		{
			GL11.glColorMask(leftR, leftG, leftB, alpha);
		}
		else // Assume `RIGHT`
		{
			GL11.glColorMask(rightR, rightG, rightB, alpha);
		}
	}
	
	public AnaglyphMode getNext()
	{
		return this.getNext(1);
	}
	
	public final int id;
	public final String name;
	
	private final boolean leftR;
	private final boolean leftG;
	private final boolean leftB;
	
	private final boolean rightR;
	private final boolean rightG;
	private final boolean rightB;
	
}
