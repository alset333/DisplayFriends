package com.alset333.Java.DisplayFriends.view;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.alset333.Java.DisplayFriends.model.Friend;

public class FriendPanel extends JPanel {

	private Friend friend;
	
	private BufferedImage image;
	private Icon icon;	
	private JLabel picLabel; // Label for image/picture/sprite (Icon)
	
	public FriendPanel(Friend friend) throws IOException { // TODO NO THROWING HERE?
		this.friend = friend;
		
		this.image = ImageIO.read(new File(this.friend.getImagePath())); // TODO move me to organize throwing?
		
		this.icon = new ImageIcon(image);
		this.picLabel = new JLabel(icon);
		
		setBackground(new Color(0,0,0,0));
		add(picLabel);
	}

}
