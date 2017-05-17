package org.DungChung;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.DungChung.actions.ColorAction;
import org.DungChung.actions.FileAction;
import org.TenCongTy.project1.resources.__resources;

@SuppressWarnings("serial")
public class SwingMainFrame extends JFrame 
{
	protected static SwingMainFrame __frame;

	public static SwingMainFrame useFrame() 
	{
		return __frame;		
	}

	
	public BufferedImage loadIcon() 
	{
		try { 
			BufferedImage t = ImageIO.read(__resources.class.getResourceAsStream("bucket.png"));
			return t;
		}
		
		catch(Exception xp) {
			return null;
		}
	}
	
	public void message(String msg)
	{
		JOptionPane.showMessageDialog(this, msg);
		
	}

	public void inspectEvent(ActionEvent arg0)
	{
		Object src = arg0.getSource();
		
		if(src instanceof JMenuItem) {
			System.out.println("JMenuItem:" + ((JMenuItem)src).getText() );
		}
		
		else {
			System.out.println(arg0.getSource());
		}
	}
	
	public void showOpenDialog(FileAction lf)
	{
		JFileChooser d = new JFileChooser();
		if( d.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;
//		System.out.println( d.getSelectedFile() );
		lf.invokeAction(d.getSelectedFile());		
	}
	
	public void showSaveDialog(File f, FileAction lf)
	{
		if(f != null) { lf.invokeAction(f); return; }
		
		JFileChooser d = new JFileChooser();
		if( d.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
//		System.out.println( d.getSelectedFile() );
		lf.invokeAction(d.getSelectedFile());		
	}
	
	public void showColorDialog(ColorAction lf)
	{
		Color c = JColorChooser.showDialog(this, "Choose color", Color.black);
//		System.out.println( d.getSelectedFile() );
		lf.invokeAction(c);		
	}
	
}