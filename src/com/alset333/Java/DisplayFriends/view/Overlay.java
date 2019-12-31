package com.alset333.Java.DisplayFriends.view;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

@SuppressWarnings("serial")
public class Overlay extends JFrame  {

	int mousePressXLocal, mousePressYLocal;

	int mouseDraggedXLocal, mouseDraggedYLocal, mouseDraggedXScreen, mouseDraggedYScreen;
	
	public Overlay() {
		this.setUndecorated(true);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setAlwaysOnTop(true);
        
        // Without this, the window is draggable from any non transparent
        // point, including points  inside textboxes.
		// https://stackoverflow.com/a/1768163
		// this.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
		
		

	}


}
