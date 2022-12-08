package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class entity {
public int worldx,worldy;
 public int speed;
 public BufferedImage up1,up2,down1,down2,right1,right2,left1,left2;
 public String direction;
 public int spritecounter=0;
 public int spritenum=1;
 public Rectangle solid; 
 public boolean collisionon=false;
}
