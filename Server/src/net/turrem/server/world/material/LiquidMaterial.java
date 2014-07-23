package net.turrem.server.world.material;

public class LiquidMaterial extends Material
{
	protected LiquidMaterial(String name, byte red, byte green, byte blue)
	{
		super(name, red, green, blue);
	}
	
	protected LiquidMaterial(String name, int color)
	{
		super(name, color);
	}

	public boolean isSolid()
	{
		return false;
	}
}
