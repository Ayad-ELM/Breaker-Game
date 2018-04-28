package com.ump.ensao;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Test extends JPanel implements KeyListener,ActionListener{

	private static final long serialVersionUID = 1L;
	private Timer timer ;
	public Test( )  {
		addKeyListener(this);
		setFocusable(true);
		setBackground(Color.RED);
		setFocusTraversalKeysEnabled(false);
		setPreferredSize(new Dimension(700, 700));
		timer = new Timer(80,this);
		timer.start();
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Test t = new Test();
	    frame.add(t);
	    frame.pack();
	    frame.setVisible(true);

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("pressed");
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
	}
}
