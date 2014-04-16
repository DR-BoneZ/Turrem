package net.turrem.server.entity;

import net.turrem.server.world.World;

public abstract class Entity
{
	protected static long nextId = 0;
	
	public final long entityIdentifier;
	
	protected boolean living = false;
	
	public World theWorld;
	
	public double x;
	public double y;
	public double z;
	
	public Entity()
	{
		this.entityIdentifier = nextId++;
	}
	
	public void onTick()
	{
		
	}
	
	public void onWorldRegister(World world)
	{
		this.living = true;
		this.theWorld = world;
		this.onEnter();
	}
	
	public void kill()
	{
		this.living = false;
	}
	
	public boolean isDead()
	{
		return !this.living;
	}
	
	public abstract void onEnter();
	
	public abstract short loadRadius();
	
	public boolean equals(Object obj)
	{
		if (obj != null && obj instanceof Entity)
		{
			return ((Entity) obj).entityIdentifier == this.entityIdentifier;
		}
		return false;
	}
}