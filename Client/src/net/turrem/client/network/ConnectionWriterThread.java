package net.turrem.client.network;

import net.turrem.client.Config;

public class ConnectionWriterThread extends Thread
{
	final GameConnection theConnection;

	public ConnectionWriterThread(GameConnection connection)
	{
		super("Network writer thread");
		this.theConnection = connection;
	}

	public void run()
	{
		while (this.theConnection.isRunning())
		{
			if (!GameConnection.writePacket(this.theConnection))
			{
				this.theConnection.flushWrite();
				try
				{
					sleep(Config.connectionWriteSleep);
				}
				catch (InterruptedException e)
				{
					
				}
			}
		}
	}
}
