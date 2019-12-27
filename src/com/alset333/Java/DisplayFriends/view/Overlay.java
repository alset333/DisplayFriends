package com.alset333.Java.DisplayFriends.view;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

public class Overlay extends JFrame implements MouseInputListener {

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
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hey don't poke me!");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.mousePressXLocal = e.getX();
		this.mousePressYLocal = e.getY();
//		System.out.println(e);
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e);
		mouseDraggedXLocal = e.getX();
		mouseDraggedYLocal = e.getY();
		mouseDraggedXScreen = e.getXOnScreen();
		mouseDraggedYScreen = e.getYOnScreen();
		
		this.setLocation(mouseDraggedXScreen - mousePressXLocal, mouseDraggedYScreen - mousePressYLocal);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e);
	}





}
