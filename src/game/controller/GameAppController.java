package game.controller;

import game.view.GameFrame;
import game.view.GamePanel;

public class GameAppController
{
	private GameFrame baseFrame;
	
	
	public GameAppController()
	{
		baseFrame = new GameFrame(this);
	}
	
	public void start()
	{
		GamePanel myAppPanel = (GamePanel) baseFrame.getContentPane();
	}
}
