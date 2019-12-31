package com.alset333.Java.DisplayFriends.controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import com.alset333.Java.DisplayFriends.view.Overlay;

public class OverlayMouseInputListener implements MouseInputListener {
	
	private Overlay overlay;
	
	private int mousePressXLocal, mousePressYLocal;
	private int mouseDraggedXLocal, mouseDraggedYLocal, mouseDraggedXScreen, mouseDraggedYScreen;
	
	public OverlayMouseInputListener(Overlay o) {
		this.overlay = o;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mousePressXLocal = e.getX();
		mousePressYLocal = e.getY();
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
		mouseDraggedXLocal = e.getX();
		mouseDraggedYLocal = e.getY();
		mouseDraggedXScreen = e.getXOnScreen();
		mouseDraggedYScreen = e.getYOnScreen();
		
		this.overlay.setLocation(mouseDraggedXScreen - mousePressXLocal, mouseDraggedYScreen - mousePressYLocal);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
