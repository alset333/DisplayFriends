package com.alset333.Java.DisplayFriends;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.alset333.Java.DisplayFriends.exceptions.SteamException;
import com.registry.RegStringValue;
import com.registry.RegistryKey;
import com.registry.RegistryValue;



public class SteamUtilities {
	
	static String key32Str, key64Str;
	static RegistryKey localMachine, key32, key64;
	static RegistryValue val32, val64, val;
	static RegStringValue regStr;
	static String valStr;
	
	public static String getSteamInstallFolder() throws SteamException {
		// Get the root key for HKEY_LOCAL_MACHINE
		localMachine = RegistryKey.getRootKeyForIndex(RegistryKey.HKEY_LOCAL_MACHINE_INDEX);
		
		// The key locations for 32 and 64 bit systems
		key32Str = "SOFTWARE\\Valve\\Steam";
		key64Str = "SOFTWARE\\WOW6432Node\\Valve\\Steam";
		
		// Get the keys for 32 and 64 bit systems
		key32 = new RegistryKey(localMachine, key32Str);
		key64 = new RegistryKey(localMachine, key64Str);
		
		// Get the keys' values
		val32 = key32.getValue("InstallPath");
		val64 = key64.getValue("InstallPath");
		
		// If a key is not null, use its value
		if		(val32 != null) val = val32;		// found 32-bit system Steam registry key
		else if (val64 != null) val = val64;		// found 64-bit system Steam registry key
		else throw new SteamException("Could not find Steam registry key.");

		regStr = (RegStringValue)val;  // Cast the RegistryValue to a RegStrValue
		valStr = regStr.getValue();  // Get the String-value from the RegStrValue
		
		return valStr;  // Return the string of the path
	}
	
	public static ArrayList<String> getSteamLibraryFolders() throws SteamException {
		String steamPath = SteamUtilities.getSteamInstallFolder();
			
		Path steamFolderListFilePath = Paths.get(steamPath, "steamapps", "libraryfolders.vdf");
		File steamFolderListFile	 = steamFolderListFilePath.toFile();
		
		System.out.println(steamFolderListFile);
		
		Scanner steamFolderListScanner;
		
		try {
			steamFolderListScanner = new Scanner(steamFolderListFile);	
		} catch (FileNotFoundException e) {
			throw new SteamException("Could not find \"libraryfolders.vdf\" file.");
		}
		
		ArrayList<String> folders = new ArrayList<String>();
		
		folders.add(steamPath);
		
		int lineNum = 0;
		while(steamFolderListScanner.hasNextLine()) {
			String line = steamFolderListScanner.nextLine();
			if (line.contains("\"" + String.valueOf(lineNum - 3) + "\"\t\t")) {
				String splitLine = line.split("\"")[3].replace("\\\\", "\\");
				folders.add(splitLine);
			}
			lineNum++;
		}
		
		
		steamFolderListScanner.close();
		
		return folders;
		
	}


}
