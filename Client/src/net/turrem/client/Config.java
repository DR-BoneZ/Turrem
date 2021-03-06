package net.turrem.client;

import org.lwjgl.opengl.Display;

public class Config
{
	public static int chunkRenderDistance = 96;
	public static int chunkStorageWidth = 16;
	public static int entityRenderDistance = 96;
	public static int chunkCheckRenderDistance = 8;
	public static float mouseSpeedX = 0.5F;
	public static float mouseSpeedY = 0.5F;
	public static float scrollSpeed = 0.012F;
	public static float camDistMin = 8.0F;
	public static float camDistMax = 120.0F;
	public static float terrainAoSampleMult = 0.5F;
	public static float finalAoSampleMult = 0.5F;
	public static boolean terrainUsePreAO = true;
	public static boolean doAO = true;
	public static int turremServerPort = 26555;
	public static String turremServerHost = "localhost";
	public static int connectionReadSleep = 2;
	public static int connectionWriteSleep = 2;
	public static int connectionTimeoutLimit = 120;
	public static int connectionInQueueOverflow = 100000;
	public static int connectionOutQueueOverflow = 100000;
	public static long chunkRequestTimeLimit = 100;
	public static int chunkRequestDistance = 8;
	public static boolean shouldRequestChunks = false;
	
	public static int getHeight()
	{
		return Display.getDisplayMode().getHeight();
	}

	public static int getWidth()
	{
		return Display.getDisplayMode().getWidth();
	}
}
