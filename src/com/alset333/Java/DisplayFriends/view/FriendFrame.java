package com.alset333.Java.DisplayFriends.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendFrame extends Overlay {

	public FriendFrame(String nikoPath) {
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
			
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			jp.add(picLabel, BorderLayout.SOUTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(jp);
	}

}
