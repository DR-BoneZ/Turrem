package net.turrem.server.load;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.turrem.server.Realm;
import net.turrem.server.entity.IEntity;
import net.turrem.server.load.control.SubscribeDecorate;
import net.turrem.server.world.Chunk;
import net.turrem.server.world.World;

public class EntityLoader implements IGameLoad
{
	protected List<Method> decorateCalls = new ArrayList<Method>();
	protected List<Method> realmInitCalls = new ArrayList<Method>();
	protected GameLoader theLoader;

	public EntityLoader(GameLoader loader)
	{
		this.theLoader = loader;
	}

	@Override
	public void processClass(Class<?> clss)
	{
		for (Method mtd : clss.getMethods())
		{
			this.processMethod(mtd, clss);
		}
	}

	private void processMethod(Method mtd, Class<?> clss)
	{
		/**
		if (Modifier.isStatic(mtd.getModifiers()))
		{
			Class<?>[] pars = mtd.getParameterTypes();
			Class<?> rtrn = mtd.getReturnType();
			if (mtd.isAnnotationPresent(SubscribeDecorate.class))
			{
				if (pars.length == 3 && pars[0].isAssignableFrom(Chunk.class) && pars[1].isAssignableFrom(World.class) && pars[2].isAssignableFrom(Random.class))
				{
					this.decorateCalls.add(mtd);
				}
			}
			if (mtd.isAnnotationPresent(SubscribeStartingEntity.class))
			{
				if (pars.length == 2 && pars[0].isAssignableFrom(Realm.class) && pars[1].isAssignableFrom(World.class) && Entity.class.isAssignableFrom(rtrn))
				{
					this.realmInitCalls.add(mtd);
				}
			}
		}
		**/
	}

	public void processChunkDecorates(Chunk chunk, World world)
	{
		long seed = this.posSeed(chunk.chunkx, chunk.chunkz, world.seed);
		for (Method mtd : this.decorateCalls)
		{
			long seedoff = mtd.getAnnotation(SubscribeDecorate.class).seed();
			try
			{
				mtd.invoke(null, chunk, world, new Random(seed * seedoff));
			}
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
			{
				System.err.println("Decorate call for \"" + mtd.getClass().getName() + "\" failed");
			}
		}
	}
	
	public List<IEntity> processRealmInits(Realm realm, World world)
	{
		List<IEntity> ents = new ArrayList<IEntity>();
		/**
		for (Method mtd : this.realmInitCalls)
		{
			try
			{
				ents.add((Entity) mtd.invoke(null, realm, world));
			}
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
			{
				System.err.println("Starting entities call for \"" + mtd.getClass().getName() + "\" failed");
			}
		}
		**/
		return ents;
	}

	private long posSeed(long x, long y, long seed)
	{
		seed *= seed * 6364136223846793005L + 1442695040888963407L;
		seed += x;
		seed *= seed * 6364136223846793005L + 1442695040888963407L;
		seed += y;
		seed *= seed * 6364136223846793005L + 1442695040888963407L;
		seed += x;
		seed *= seed * 6364136223846793005L + 1442695040888963407L;
		seed += y;
		return seed;
	}
}
