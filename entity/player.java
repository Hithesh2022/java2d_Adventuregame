package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamepanel;
import main.keylisten;

public class player extends entity {
gamepanel tf;
keylisten kh;
public final int screenx;
public final int screeny;
public player(gamepanel tf,keylisten kh)
{  
	this.tf=tf;
	this.kh=kh;
	screenx=tf.width/2;
	screeny=tf.height/2;
	solid=new Rectangle( 8,16,32,32);//setting player that coordinate to solid
	
	defaultv();
	playerimage();
	
}
public void defaultv()
{
	worldx=tf.tilesize*23;
	worldy=tf.tilesize*21;
	speed=2;
	direction="down";
}
public void update()

{
	if(kh.up==true||kh.down==true||kh.left==true||kh.right==true)
	{
	if(kh.up==true)
	{direction="up";
		
	}
	if(kh.down==true)
	{ direction="down";
		
		
	}
	if(kh.left==true)
	{ direction="left";
		
		
	}
	if(kh.right==true)
	{  direction="right";
		
		
	}
	collisionon=false;
	tf.ck.checktile(this);
	if(collisionon==false)
	{
		switch(direction)
		{
		case "up": worldy-=speed;
			break;
			
		case"down" : worldy+=speed;
			break;
			
		case "right" :worldx+=speed;
			break;
			
		case "left" : worldx-=speed;
			break;
		
		}
	}
	
spritecounter++;
if(spritecounter>18)
{
if(spritenum==1)
{
spritenum=2;	
}
else if(spritenum==2)
{
	spritenum=1;
	}
spritecounter=0;
}
}
}

public void draw ( Graphics2D g2)

{
	/*g2.setColor(Color.white);
	g2.fillRect(x, y,  tf.tilesize,  tf.tilesize);
	*/
	BufferedImage image=null;
	switch(direction)
	{
	case "up":
		if(spritenum==1)
		{
		image=up1;
				
		}
		if(spritenum==2)
		{
			image=up2;
			
		}
		break;
	case "down":
		
		if(spritenum==1)
		{image=down1;
		}
		if(spritenum==2)
		{image=down2;
		}
		
	break;
	case "right":
		if(spritenum==1)
		{image=right1;
		}
		if(spritenum==2)
		{image=right2;
		}
		
		
	break;
	case "left":
		if(spritenum==1)
		{image=left1;
		}
		if(spritenum==2)
		{image=left2;
		}
		
	break;
	
	}
	g2.drawImage(image, screenx, screeny, tf.tilesize, tf.tilesize, null );
	

}
public void playerimage()
{
	try {
		up1=ImageIO.read(getClass().getResourceAsStream("/playeri/0_Warrior_back_0.png"));
		up2=ImageIO.read(getClass().getResourceAsStream("/playeri/0_Warrior_back_01.png"));
		down1=ImageIO.read(getClass().getResourceAsStream("/playeri/0_Warrior_front_0.png"));
		down2=ImageIO.read(getClass().getResourceAsStream("/playeri/0_Warrior_front_01.png"));
		left1=ImageIO.read(getClass().getResourceAsStream("/playeri/0_Warrior_left_00.png"));
		left2=ImageIO.read(getClass().getResourceAsStream("/playeri/0_Warrior_left_01.png"));
		right1=ImageIO.read(getClass().getResourceAsStream("/playeri/0_Warrior_Right_00.png"));
		right2=ImageIO.read(getClass().getResourceAsStream("/playeri/0_Warrior_Right_01.png"));
		
	}catch(IOException e)//input output exception;
	{
		e.printStackTrace();
	}
}
}

