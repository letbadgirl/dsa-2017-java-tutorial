package dsa2017.probing3_distrans;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class to_divide_image {

	public static void main(String[] args) 
	{
		BufferedImage img = genImage(5);
		
		GaussianRect s = sum(img, 0, 0, img.getWidth()-1, img.getHeight()-1);
		System.out.println(s);
	}

	private static BufferedImage genImage(int n) 
	{
		BufferedImage res = new BufferedImage(n, n, BufferedImage.TYPE_INT_ARGB);
		
		for(int x=0; x<n; x++)
		for(int y=0; y<n; y++)
		{
			int t = (int)Math.floor(256 * Math.random());
			Color c = new Color(0, 0, t);
			res.setRGB(x, y, c.getRGB());
		}
		
		return res;
	}

	private static GaussianRect sum(BufferedImage img, int x1, int y1, int x2, int y2) 
	{
		int r = 0, g = 0, b = 0, n = 0;
		
		for(int x=x1; x<=x2; x++)
		for(int y=y1; y<=y2; y++)
		{
			Color c = new Color( img.getRGB(x, y) );
			r += c.getRed();			
			g += c.getGreen();			
			b += c.getBlue();
			n++;
		}
		
		
		GaussianRect res = new GaussianRect();
		
		res.counter = n;
		res.meanRed = r / n;
		res.meanGreen = g / n;
		res.meanBlue = b / n;

		return var(res, img, x1, y1, x2, y2);
	}

	private static GaussianRect var(GaussianRect res, BufferedImage img, int x1, int y1, int x2, int y2)
	{
		int r = 0, g = 0, b = 0;
		
		for(int x=x1; x<=x2; x++)
		for(int y=y1; y<=y2; y++)
		{
			Color c = new Color( img.getRGB(x, y) );
			double dr = c.getRed() - res.meanRed; r += dr*dr;			
			double dg = c.getGreen() - res.meanGreen; g += dg*dg;
			double db = c.getBlue() - res.meanBlue; b += db*db;						
		}
		
		int n = res.counter;
		
		res.varRed = Math.sqrt(r / n);
		res.varGreen = Math.sqrt(g / n);
		res.varBlue = Math.sqrt(b / n);

		return res;
	}

	
}
