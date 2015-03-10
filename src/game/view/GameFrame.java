package game.view;

import game.controller.GameAppController;

import javax.swing.*;

public class GameFrame extends JFrame
{
	private GamePanel appPanel;
	
	public GameFrame(GameAppController baseController)
	{
		appPanel = new GamePanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(400,400);
		this.setContentPane(appPanel);
		this.setVisible(true);
	}
}
