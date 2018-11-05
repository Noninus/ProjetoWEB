package pj.utils;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	
		
		g.drawLine(0, 0, 1600, 0);


	}

}
