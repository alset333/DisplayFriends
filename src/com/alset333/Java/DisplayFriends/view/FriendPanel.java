package com.alset333.Java.DisplayFriends.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.alset333.Java.DisplayFriends.model.Friend;

@SuppressWarnings("serial")
public class FriendPanel extends JPanel implements MouseListener {

	
	private Friend friend;
	
	private BufferedImage fullImage;
	private BufferedImage spriteImage;

	private JLabel picLabel; // Label for image/picture/sprite (Icon)
	
	public FriendPanel(Friend friend) throws IOException { // TODO NO THROWING HERE?
		this.friend = friend;
		
		this.fullImage = ImageIO.read(new File(this.friend.getImagePath())); // TODO move me to organize throwing?
		
		
		int spriteWidth = 48, spriteHeight = 64;
		
		this.spriteImage = this.fullImage.getSubimage(friend.getStep() * spriteWidth, friend.getDirection() * spriteHeight, spriteWidth, spriteHeight);
				
		this.picLabel = new JLabel(new ImageIcon(this.spriteImage));
		
		setBackground(new Color(0,0,0,0));
		add(picLabel);
		
		addMouseListener(this);
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
	
		int dir = friend.getDirection();
		
		System.out.println(dir);
		
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
		
		friend.setDirection(dir);
		
		int spriteWidth = 48, spriteHeight = 64;
		
		this.spriteImage = this.fullImage.getSubimage(friend.getStep() * spriteWidth, friend.getDirection() * spriteHeight, spriteWidth, spriteHeight);
		this.spriteImage.flush();
				
		this.picLabel.setIcon(new ImageIcon(this.spriteImage));
		
//		this.revalidate();
//		this.repaint();
		this.getParent().repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
