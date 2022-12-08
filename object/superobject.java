package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

import main.gamepanel;

public class superobject {
	
	public BufferedImage image;
	public String name;
	public boolean collision =false;
	public int worldx,worldy;
public void draw(Graphics2D g2,gamepanel tf)
{
	 int screenx=worldx-tf.Player.worldx+tf.Player.screenx;
	 int screeny=worldy-tf.Player.worldy+tf.Player.screeny;
	  	
	   if(worldx+tf.tilesize>tf.Player.worldx-tf.Player.screenx&& worldx-tf.tilesize<tf.Player.worldx+tf.Player.screenx&& worldy+tf.tilesize>tf.Player.worldy-tf.Player.screeny&& worldy-tf.tilesize<tf.Player.worldy+tf.Player.screeny) 
	   {
	 g2.drawImage(image, screenx, screeny, tf.tilesize, tf.tilesize, null);
	   }
	 
}
}
