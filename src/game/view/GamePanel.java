package game.view;

import javax.swing.*;

import game.controller.GameAppController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel
{
	private GameAppController baseController;
	private JButton rockButton;
	private JButton paperButton;
	private JButton scissorButton;
	
	
	public GamePanel(GameAppController baseController)
	{
		this.baseController = baseController;
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
