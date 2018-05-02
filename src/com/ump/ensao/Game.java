package com.ump.ensao;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioPermission;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener,ActionListener {

	private boolean play = false;
	private BufferedImage image,ball,player,candy;
	
	private int score = 0;
	private int totalBricks = 21;
	private Timer timer;
	private int ballspeed    = 5 ;
	private int playerXCor  = 310,
				ballXpos = 120,
				ballYpos = 400,
				ballXdir =-1,
				ballYdir = -2,
				breakM = 90;
	private Break[][] breaks;
	public Game() {
		try {
			image = ImageIO.read(new FileInputStream("./og.png"));
			ball = ImageIO.read(new FileInputStream("./ball.png"));
			player = ImageIO.read(new FileInputStream("./player.png"));
			candy = ImageIO.read(new FileInputStream("./candy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		breaks = new Break[3][7];
		for(int i=0;i<3;i++) {
			for(int j=0;j<7;j++) {
				breaks[i][j] = new Break(true,breakM+(j*74),(i*74)+30);
			}
			
		}
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setPreferredSize(new Dimension(735, 592));
		timer = new Timer(ballspeed,this);
		timer.start();
	}
	public void paint(Graphics g) {
		// background
		//g.setColor(Color.black);
		//g.fillRect(1, 1, 692, 592);
		  g.drawImage(image, 1,1,692,592,null);
		
		// borders
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691,0, 3, 592);
		//g.fillRect(0,592, 692, 10);
		
		// create the paddle
		//g.setColor(Color.GREEN);
		//g.fillRect(playerXCor,570, 100, 8);
		g.drawImage(player, playerXCor,570,100,8,null);
		g.setColor(Color.white);
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<7;j++) {
				if(breaks[i][j].isActive()) {
					//g.fillRect(breaks[i][j].getXcor(),breaks[i][j].getYcour(), 70, 70);
					g.drawImage(candy,breaks[i][j].getXcor(), breaks[i][j].getYcour(),70,70,null);
				}
				
			}
			
		}
		
		// create the ball
		//g.setColor(Color.GREEN);
		//g.fillOval(ballXpos,ballYpos, 20,20);
		g.drawImage(ball, ballXpos,ballYpos,20,20,null);
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<7;j++) {
				if(new Rectangle(ballXpos,ballYpos,20,20).intersects(new Rectangle(breaks[i][j].
						getXcor(),breaks[i][j].getYcour(),70,70))&& breaks[i][j].isActive()) {
					breaks[i][j].setActive(false);
					ballYdir = - ballYdir;
					ballXdir = - ballXdir;
				}
			}
				
			}
			
		
		
		if(play) {
			if(new Rectangle(ballXpos,ballYpos,20,20).intersects(new Rectangle(playerXCor, 570, 100, 8))){
				ballYdir = - ballYdir;
				
			}
			ballXpos+=ballXdir;
			ballYpos+=ballYdir;
			if(ballXpos < 0) {
				ballXdir = -ballXdir;
			}
			if(ballYpos < 0) {
				ballYdir = -ballYdir;
			}
			if(ballXpos > 670) {
				ballXdir = -ballXdir;
			}
		}
		//timer.start();
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerXCor>=600) {
				playerXCor = 600;
			}else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerXCor<2) {
				playerXCor = 1;
			}else {
				moveLeft();
			}
		}
		
	}
	public void moveRight() {
		play = true;
		playerXCor+=20;
		
		
	}
	public void moveLeft() {
	
		play = true;
		playerXCor-=20;
	}

}
