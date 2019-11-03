package com.alset333.Java.DisplayFriends;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JTextField;

import com.alset333.Java.DisplayFriends.exceptions.SteamException;
import com.alset333.Java.DisplayFriends.view.FriendFrame;

public class DisplayFriends {

	static String steamPath, oneshotPath;
	
	public static void main(String[] args) {
		System.out.println("Hello, world!");

		try {
			steamPath = SteamUtilities.getSteamInstallFolder();
		} catch (SteamException e) {
			System.err.println(e.getMessage());
			System.exit(83);  // Code 83. 83 is ASCII for 'S'. S as in Steam problem.
		}
		
		System.out.println(steamPath);
		
		Path steamFolderListFilePath = Paths.get(steamPath, "steamapps", "libraryfolders.vdf");
		File steamFolderListFile = steamFolderListFilePath.toFile();
		
		System.out.println(steamFolderListFile);
		
		
		
		
		FriendFrame ff = new FriendFrame();
		
		ff.getContentPane().add(new JTextField("text field north"), java.awt.BorderLayout.NORTH);
        ff.getContentPane().add(new JTextField("text field south"), java.awt.BorderLayout.SOUTH);

		
		ff.setVisible(true);
		
//        ff.setSize(100,100);
		ff.pack();
		
		
	}

}
