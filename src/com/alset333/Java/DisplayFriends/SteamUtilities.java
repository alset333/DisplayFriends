package com.alset333.Java.DisplayFriends;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.alset333.Java.DisplayFriends.exceptions.SteamException;
import com.registry.RegStringValue;
import com.registry.RegistryKey;
import com.registry.RegistryValue;

import sun.security.util.Length;



public class SteamUtilities {
	
	static String key32Str, key64Str;
	static RegistryKey localMachine, key32, key64;
	static RegistryValue val32, val64, val;
	static RegStringValue regStr;
	static String valStr;
	
//	public static String getSteamInstallFolder() throws SteamException {
//		// Get the root key for HKEY_LOCAL_MACHINE
//		localMachine = RegistryKey.getRootKeyForIndex(RegistryKey.HKEY_LOCAL_MACHINE_INDEX);
//		
//		// The key locations for 32 and 64 bit systems
//		key32Str = "SOFTWARE\\Valve\\Steam";
//		key64Str = "SOFTWARE\\WOW6432Node\\Valve\\Steam";
//		
//		// Get the keys for 32 and 64 bit systems
//		key32 = new RegistryKey(localMachine, key32Str);
//		key64 = new RegistryKey(localMachine, key64Str);
//		
//		// Get the keys' values
//		val32 = key32.getValue("InstallPath");
//		val64 = key64.getValue("InstallPath");
//		
//		// If a key is not null, use its value
//		if		(val32 != null) val = val32;		// found 32-bit system Steam registry key
//		else if (val64 != null) val = val64;		// found 64-bit system Steam registry key
//		else throw new SteamException("Could not find Steam registry key.");
//
//		regStr = (RegStringValue)val;  // Cast the RegistryValue to a RegStrValue
//		valStr = regStr.getValue();  // Get the String-value from the RegStrValue
//		
//		return valStr;  // Return the string of the path
//	}
	
	private static String readSteamRegistryInstallFolder(boolean is64Bit) throws IOException {
		String installPathPrefix = "    InstallPath    REG_SZ    ";
		String querySteamKey32 = "reg query HKEY_LOCAL_MACHINE\\SOFTWARE\\Valve\\Steam";
		String querySteamKey64 = "reg query HKEY_LOCAL_MACHINE\\SOFTWARE\\WOW6432Node\\Valve\\Steam";
		
		String command = is64Bit ? querySteamKey64 : querySteamKey32;
		
		// Create a process to read the registry key
		Process rt = Runtime.getRuntime().exec(command);
		
		// Create a buffered reader for STDOUT
		BufferedReader rout = new BufferedReader(new InputStreamReader(rt.getInputStream()));
		
		// Read the lines to find the InstallPath
		String line;
		while ((line = rout.readLine()) != null) {
			if (line.startsWith(installPathPrefix)) {
				return line.substring(installPathPrefix.length());
			}
		}
		
		return null;//TODO
		
		
	}
	
	public static String getSteamInstallFolder() throws SteamException { // https://stackoverflow.com/a/1982033
//		String s;
//		try {
//			// 64-bit
//			
//			// Create a process to read the registry key
//			Process 		steamReg64Runtime	= Runtime.getRuntime().exec("reg query HKEY_LOCAL_MACHINE\\SOFTWARE\\WOW6432Node\\Valve\\Steam");
//			
//			// Create a reader for the stdout
//			BufferedReader	steamReg64StdInput	= new BufferedReader(new InputStreamReader(steamReg64Runtime.getInputStream()));
//			
////			// Create a reader for the stderr
////			BufferedReader	steamReg64StdError	= new BufferedReader(new InputStreamReader(steamReg64Runtime.getErrorStream()));
//			
//			while ((s = steamReg64StdInput.readLine()) != null) if (s.startsWith("    InstallPath    REG_SZ    ")) System.out.println(s);
//
//			// 32-bit
//			Process			steamReg32Runtime	= Runtime.getRuntime().exec("reg query HKEY_LOCAL_MACHINE\\SOFTWARE\\Valve\\Steam");
//			BufferedReader	steamReg32StdInput	= new BufferedReader(new InputStreamReader(steamReg32Runtime.getInputStream()));
//
////			// Create a reader for the stderr
////			BufferedReader	steamReg32StdError	= new BufferedReader(new InputStreamReader(steamReg32Runtime.getErrorStream()));
//			while ((s = steamReg32StdInput.readLine()) != null) if (s.startsWith("    InstallPath    REG_SZ    ")) System.out.println(s);
//
//
//
//		}catch ( IOException e) {
//			
//		}
//		
//		
		try {
			String path;
			if		((path = readSteamRegistryInstallFolder(false)) != null) return path;
			else if	((path = readSteamRegistryInstallFolder(true)) 	!= null) return path;
		}catch (IOException e){
			e.printStackTrace();
		}
		
		
		System.exit(123);
		return null;
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
