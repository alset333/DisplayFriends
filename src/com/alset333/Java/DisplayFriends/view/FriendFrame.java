package com.alset333.Java.DisplayFriends.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendFrame extends Overlay {

	private String np;
	private JLabel picLabel;
	int dir = 0;
	
	public FriendFrame(String nikoPath) {
		np = nikoPath;
		
		// See here about using images: https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel

		JPanel jp = new JPanel(new BorderLayout());
		jp.setBackground(new Color(0,0,0,0));
		
		
		
		try {
//			BufferedImage myTestPicture;
//			myTestPicture = ImageIO.read(getClass().getResource("/images/test.bmp"));
//			JLabel picTestLabel = new JLabel(new ImageIcon(myTestPicture));
//			jp.add(picTestLabel, BorderLayout.NORTH);

			BufferedImage myPicture;
			System.out.println(nikoPath);
			myPicture = ImageIO.read(new File(nikoPath));
			
			int DOWN = 0, LEFT = 1, RIGHT = 2, UP = 3;
			
			/////////////////////////////////////////
			int direction = DOWN, walkCycleStep = 0;
			/////////////////////////////////////////
			
			int indexX = walkCycleStep, indexY = direction;
			int spriteWidth = 48, spriteHeight = 64;
			
			myPicture = myPicture.getSubimage(indexX * spriteWidth, indexY * spriteHeight, spriteWidth, spriteHeight);
			
			this.picLabel = new JLabel(new ImageIcon(myPicture));
			jp.add(this.picLabel, BorderLayout.SOUTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(jp);
	}
	
	public void faceTo(int direction) {
		
		BufferedImage pic = null;
		try {
			pic = ImageIO.read(new File(np));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int DOWN = 0, LEFT = 1, RIGHT = 2, UP = 3;
		
		/////////////////////////////////////////
		int walkCycleStep = 0;
		/////////////////////////////////////////
		
		int indexX = walkCycleStep, indexY = direction;
		int spriteWidth = 48, spriteHeight = 64;
		
		pic = pic.getSubimage(indexX * spriteWidth, indexY * spriteHeight, spriteWidth, spriteHeight);
		pic.flush();


		this.picLabel.setIcon(new ImageIcon(pic));
		this.revalidate();
		this.repaint();
	}
	
	public void walkSteps(int steps) {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		switch (dir) {
		case 0:
			dir = 1;
			break;
		case 1:
			dir = 3;
			break;
		case 3:
			dir = 2;
			break;
		case 2:
			dir = 0;
			break;

		default:
			break;
		}
		
		this.faceTo(dir);
	}

}
