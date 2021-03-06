package net.turrem.client.render;

import java.awt.image.BufferedImage;
import java.io.IOException;

import net.turrem.client.Config;
import net.turrem.client.asset.AssetLoader;
import net.turrem.client.render.object.RenderObjectTexture;
import net.turrem.client.render.object.RenderTVF;
import net.turrem.utils.models.TVFFile;

public class RenderEngine
{
	public AssetLoader assets;
	public RenderStoreTexture renderStore2D;
	public RenderStoreTVF renderStoreTVF;

	public RenderEngine(AssetLoader assets)
	{
		this.assets = assets;
		this.renderStore2D = new RenderStoreTexture(this);
		this.renderStoreTVF = new RenderStoreTVF(this);
	}

	public BufferedImage loadTexture(RenderObjectTexture object)
	{
		if (object.isLoaded())
		{
			return null;
		}
		try
		{
			return this.assets.loadTexture(object.getSource());
		}
		catch (IOException e)
		{
			return null;
		}
	}

	public TVFFile loadTVF(String name)
	{
		try
		{
			return this.assets.loadTVF(name);
		}
		catch (IOException e)
		{
			return null;
		}
	}

	public RenderTVF loadTVFRender(TVFFile tvf, float scale, boolean doAO)
	{
		TVFBuffer buffer = new TVFBuffer();
		RenderTVF render = new RenderTVF();
		buffer.bindTVF(tvf, render, scale, Config.doAO);
		return render;
	}

	public RenderTVF loadTVFRender(String name, float scale, boolean doAO)
	{
		TVFFile tvf = this.loadTVF(name);
		RenderTVF render = new RenderTVF();
		if (tvf != null)
		{
			TVFBuffer buffer = new TVFBuffer();
			buffer.bindTVF(tvf, render, scale, Config.doAO);
		}
		return render;

	}
}
