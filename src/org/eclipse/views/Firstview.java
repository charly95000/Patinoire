package org.eclipse.views;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Firstview extends JPanel {
	public void paintComponent(Graphics g){
		try{
			Image logo = ImageIO.read(new File("assets/images/logo.jpg"));
			g.drawImage(logo,0,0,this);
			
		} catch(IOException e){
				e.printStackTrace();
		}
		
	}
	
	
}
