package net.turrem.client.render;

import java.util.Map;

import net.turrem.client.render.icon.IRenderIcon;
import net.turrem.client.render.object.IRenderObject;

public interface IRenderStore
{
	public void unloadAll();
	
	public void reloadAll(boolean loadnew);
	
	public int size();
	
	public Map<String, IRenderObject> getMap();
	
	public IRenderObject getObject(IRenderIcon ico);
	
	public IRenderObject unloadObject(IRenderIcon ico);
	
	public IRenderObject loadObject(IRenderIcon ico);
	
	public IRenderObject reloadObject(IRenderIcon ico);
}
