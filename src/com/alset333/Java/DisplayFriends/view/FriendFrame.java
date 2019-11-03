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

	public FriendFrame() {
		// See here about using images: https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel

		JPanel jp = new JPanel(new BorderLayout());
		jp.setBackground(new Color(0,0,0,0));
		
		
		
		try {
			BufferedImage myTestPicture;
			myTestPicture = ImageIO.read(getClass().getResource("/images/test.bmp"));
			JLabel picTestLabel = new JLabel(new ImageIcon(myTestPicture));
			jp.add(picTestLabel, BorderLayout.NORTH);

			BufferedImage myPicture;
			myPicture = ImageIO.read(new File("D:\\Steam\\steamapps\\common\\OneShot\\Graphics\\Characters\\niko.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			jp.add(picLabel, BorderLayout.SOUTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(jp);
	}

}
