package game.view;

import javax.swing.*;

import game.controller.GameAppController;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.Font;

public class GamePanel extends JPanel
{
	private GameAppController baseController;
	private JButton rockButton;
	private JButton paperButton;
	private JButton scissorButton;
	private JLabel labelResults;
	private JLabel labelWins;
	private JLabel labelLose;
	private JLabel labelTies;
	private SpringLayout baseLayout;
	
	private Random rand;
	private int computerHand;
	private int yourHand;
	private int wins;
	private int lose;
	private int ties;
	
	
	public GamePanel(GameAppController baseController)
	{
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.BLACK);
		this.setLayout(baseLayout);
		
		
		labelWins = new JLabel("Wins: 0");
		labelWins.setForeground(Color.GREEN);
		labelWins.setFont(new Font("Quartz MS", Font.PLAIN, 12));
		baseLayout.putConstraint(SpringLayout.NORTH, labelWins, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, labelWins, 55, SpringLayout.WEST, this);
		add(labelWins);
		
		labelLose = new JLabel("Lose: 0");
		labelLose.setForeground(Color.RED);
		labelLose.setFont(new Font("Quartz MS", Font.PLAIN, 12));
		baseLayout.putConstraint(SpringLayout.NORTH, labelLose, 0, SpringLayout.NORTH, labelWins);
		add(labelLose);
		
		labelTies = new JLabel("Ties: 0");
		labelTies.setForeground(Color.ORANGE);
		labelTies.setFont(new Font("Quartz MS", Font.PLAIN, 12));
		baseLayout.putConstraint(SpringLayout.WEST, labelLose, 43, SpringLayout.EAST, labelTies);
		baseLayout.putConstraint(SpringLayout.NORTH, labelTies, 0, SpringLayout.NORTH, labelWins);
		baseLayout.putConstraint(SpringLayout.WEST, labelTies, 48, SpringLayout.EAST, labelWins);
		add(labelTies);
		
		labelResults = new JLabel("Computer Chose: ");
		labelResults.setForeground(Color.CYAN);
		baseLayout.putConstraint(SpringLayout.NORTH, labelResults, 43, SpringLayout.SOUTH, labelWins);
		baseLayout.putConstraint(SpringLayout.WEST, labelResults, 77, SpringLayout.WEST, this);
		labelResults.setFont(new Font("Quartz MS", Font.PLAIN, 16));
		add(labelResults);
		
		rockButton = new JButton("ROCK");
		rockButton.setFont(new Font("Quartz MS", Font.PLAIN, 14));
		rockButton.setForeground(Color.WHITE);
		rockButton.setBackground(Color.BLACK);
		baseLayout.putConstraint(SpringLayout.NORTH, rockButton, 113, SpringLayout.SOUTH, labelWins);
		baseLayout.putConstraint(SpringLayout.EAST, rockButton, 0, SpringLayout.EAST, labelWins);
		add(rockButton);
		
		paperButton = new JButton("PAPER");
		paperButton.setFont(new Font("Quartz MS", Font.PLAIN, 14));
		paperButton.setForeground(Color.WHITE);
		paperButton.setBackground(Color.BLACK);
		baseLayout.putConstraint(SpringLayout.NORTH, paperButton, 0, SpringLayout.NORTH, rockButton);
		baseLayout.putConstraint(SpringLayout.WEST, paperButton, 31, SpringLayout.EAST, rockButton);
		add(paperButton);
		
		scissorButton = new JButton("SCISSOR");
		scissorButton.setFont(new Font("Quartz MS", Font.PLAIN, 14));
		scissorButton.setForeground(Color.WHITE);
		scissorButton.setBackground(Color.BLACK);
		baseLayout.putConstraint(SpringLayout.NORTH, scissorButton, 0, SpringLayout.NORTH, rockButton);
		baseLayout.putConstraint(SpringLayout.WEST, scissorButton, 0, SpringLayout.WEST, labelLose);
		add(scissorButton);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		rockButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				RandomComputerHand();
				yourHand = 0;
				CheckHands();
			}
		});
		
		paperButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				RandomComputerHand();
				yourHand = 1;
				CheckHands();
			}
		});
		
		scissorButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				RandomComputerHand();
				yourHand = 2;
				CheckHands();
			}
		});
	}
	
	
	
	private void RandomComputerHand()
	{
		rand = new Random();
		computerHand = rand.nextInt((2 - 0) + 1);
	}
	
	private void CheckHands()
	{
		//tie
		if(yourHand == computerHand)
		{
			ties ++;
			labelTies.setText("Ties: " + ties);
		}
		
		//you win with rock
		if(yourHand == 0 && computerHand == 2)
		{
			wins ++;
			labelWins.setText("Wins: " + wins);
		}
		
		//you win with paper
		if(yourHand == 1 && computerHand == 0)
		{
			wins ++;
			labelWins.setText("Wins: " + wins);
		}
		
		//you win with scissor
		if(yourHand == 2 && computerHand == 1)
		{
			wins ++;
			labelWins.setText("Wins: " + wins);
		}
		
		//computer win with rock
		if(computerHand == 0 && yourHand == 2)
		{
			lose ++;
			labelLose.setText("Lose: " + lose);
		}
		
		//computer win with paper
		if(computerHand == 1 && yourHand == 0)
		{
			lose ++;
			labelLose.setText("Lose: " + lose);
		}
		
		//computer win with scissor
		if(computerHand == 2 && yourHand == 1)
		{
			lose ++;
			labelLose.setText("Lose: " + lose);
		}
		
		
		//shows what computer chose
		if(computerHand == 0)
		{
			labelResults.setText("Computer Chose: " + "\n" + "ROCK");
		}
		if(computerHand == 1)
		{
			labelResults.setText("Computer Chose: " + "\n" + "PAPER");
		}
		if(computerHand == 2)
		{
			labelResults.setText("Computer Chose: " + "\n" + "SCISSORS");
		}
	}
}
