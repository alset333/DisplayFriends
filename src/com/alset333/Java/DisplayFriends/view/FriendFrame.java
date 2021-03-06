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

import com.alset333.Java.DisplayFriends.model.Friend;

@SuppressWarnings("serial")
public class FriendFrame extends Overlay {

	private final String imagePath;
	private JLabel picLabel;
	int dir = 0;
	
	public FriendFrame(Friend friend) {
		this.imagePath = friend.getImagePath();
		
	}
	
	public FriendFrame(String nikoPath) {
		imagePath = nikoPath;
		
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
			
			@SuppressWarnings("unused") // TODO this just keeps warnings away for now since these are being used like constants/reminders
			int DOWN = 0, LEFT = 1, RIGHT = 2, UP = 3;
			
			/////////////////////////////////////////
			int direction = DOWN, walkCycleStep = 0;
			/////////////////////////////////////////
			
			int indexX = walkCycleStep, indexY = direction;
			int spriteWidth = 48, spriteHeight = 64;
			
			myPicture = myPicture.getSubimage(indexX * spriteWidth, indexY * spriteHeight, spriteWidth, spriteHeight);
			
			this.picLabel = new JLabel(new ImageIcon(myPicture));
			add(this.picLabel, BorderLayout.SOUTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		add(jp);
	}
	
	public void faceTo(int direction) {
		
		BufferedImage pic = null;
		try {
			pic = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		int DOWN = 0, LEFT = 1, RIGHT = 2, UP = 3;
		
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
	

}
