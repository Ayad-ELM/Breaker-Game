package com.ump.ensao;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main extends JFrame {
	//private Game game;
	
	public Main(String ch) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		Game game = new Game();
		add(game);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Main m = new Main("Game Breaker");

	}

}
