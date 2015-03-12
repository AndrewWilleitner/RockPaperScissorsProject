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
		this.setContentPane(appPanel);
		this.setSize(360,280);
		this.setResizable(false);
		this.setVisible(true);
	}
}
