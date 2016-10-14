package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import client.model.*;
//import client.view.storyBoard_Practice;

public class PickWordController extends MouseAdapter{
	private JPanel panel;
	public PickWordController(JPanel p){
		this.panel = p;
	} 
	
	public void mousePressed(MouseEvent me){
		mouseGen(me, true);
	}
	
	public void mouseDragged(MouseEvent me) {
		mouseGen(me, true);
	}
	
	public void mouseReleased(MouseEvent me) {
		mouseGen(me, false);
	}
	
	private void mouseGen(MouseEvent e, boolean select) {
		int x = e.getX() / 55 ;
		int y = e.getY() / 55 ;
		if(x > 3 || x < 0 || y > 3 || y < 0){
			select = false;
		}
		
//		System.out.println(e.getX());
//		System.out.println(e.getY());
//		System.out.println(Model.getModel().getBoard().cells[x][y].isSelected);
		if (select) 
			Model.getModel().getBoard().cells[x][y].selectCell();
		else 
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					Model.getModel().getBoard().cells[i][j].diselectCell();
				}
			}					
	}
}	

