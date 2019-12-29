package com.alset333.Java.DisplayFriends;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.alset333.Java.DisplayFriends.exceptions.SteamException;
import com.alset333.Java.DisplayFriends.model.Friend;
import com.alset333.Java.DisplayFriends.view.FriendFrame;
import com.alset333.Java.DisplayFriends.view.FriendPanel;
import com.alset333.Java.DisplayFriends.view.Overlay;

public class DisplayFriends {

	static String steamPath, oneshotPath;
	
	public static void main(String[] args) {
		System.out.println("Hello, world!");

//		try {
//			steamPath = SteamUtilities.getSteamInstallFolder();
//		} catch (SteamException e) {
//			System.err.println(e.getMessage());
//			System.exit(83);  // Code 83. 83 is ASCII for 'S'. S as in Steam problem.
//		}
//		
//		System.out.println(steamPath);
//		
//		Path steamFolderListFilePath = Paths.get(steamPath, "steamapps", "libraryfolders.vdf");
//		File steamFolderListFile = steamFolderListFilePath.toFile();
//		
//		System.out.println(steamFolderListFile);
		
		ArrayList<String> folders = null;
		
		try {
			folders = SteamUtilities.getSteamLibraryFolders();
			System.out.println(folders);
		} catch (SteamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String oneshotPath = null;
		
		for(String fldr : folders) {
			Path osPath = Paths.get(fldr, "steamapps", "common", "OneShot");
			if (Files.isDirectory(osPath)) oneshotPath = osPath.normalize().toString();
		}
		
		System.out.println("OneShot located at path:\t" + oneshotPath);
//		System.exit(0);
		
		String nikoPath = Paths.get(oneshotPath, "Graphics", "Characters", "niko.png").normalize().toString();
		
//		FriendFrame ff = new FriendFrame(nikoPath);
		
//		ff.getContentPane().add(new JTextField("text field north"), java.awt.BorderLayout.NORTH);
//        ff.getContentPane().add(new JTextField("text field south"), java.awt.BorderLayout.SOUTH);

		Friend niko = new Friend("Niko", nikoPath);
		
		FriendPanel fp;
		try {
			fp = new FriendPanel(niko);

			Overlay ff = new Overlay();
			ff.add(fp);
			ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ff.setVisible(true);
			ff.pack();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//        ff.setSize(100,100);
		
		
	}

}
