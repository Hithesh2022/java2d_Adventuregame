package main;

import entity.entity;

public class collisioncheck {
	gamepanel tf;
public collisioncheck(gamepanel tf)
{
this.tf=tf;	
}
public  void checktile(entity entity)
{
	int entityleftworldx=entity.worldx+entity.solid.x;
	int entityrightworldx=entity.worldx+entity.solid.x+entity.solid.width;
	int entitytopworldy=entity.worldy+entity.solid.y;
    int entitybottomworldy=entity.worldy+entity.solid.y+entity.solid.height;
    
    int entityleftcol=entityleftworldx/tf.tilesize;
    int entityrightcol=entityrightworldx/tf.tilesize;
    int entitytoprow=entitytopworldy/tf.tilesize;
    int entitybottomrow=entitybottomworldy/tf.tilesize;
    
    int tilenum1,tilenum2;
    switch(entity.direction)
    {
    
    case "up": entitytoprow=(entitytopworldy-entity.speed)/tf.tilesize;
          tilenum1=tf.tilem.maptilenum[entityleftcol][entitytoprow];
          tilenum2=tf.tilem.maptilenum[entityrightcol][entitytoprow];
          if(tf.tilem.tile[tilenum1].collision==true|| tf.tilem.tile[tilenum2].collision==true)
          {
        	  entity.collisionon=true;
          }
        	  
        	  
          break;
    
    case "down": entitybottomrow=(entitybottomworldy+entity.speed)/tf.tilesize;
    tilenum1=tf.tilem.maptilenum[entityleftcol][entitybottomrow];
    tilenum2=tf.tilem.maptilenum[entityrightcol][entitybottomrow];
    if(tf.tilem.tile[tilenum1].collision==true|| tf.tilem.tile[tilenum2].collision==true)
    {
  	  entity.collisionon=true;
    }
  	
    	
    	break;
    case "right": entityrightcol=(entityrightworldx+entity.speed)/tf.tilesize;
    tilenum1=tf.tilem.maptilenum[entityleftcol][entitytoprow];
    tilenum2=tf.tilem.maptilenum[entityrightcol][entitybottomrow];
    if(tf.tilem.tile[tilenum1].collision==true|| tf.tilem.tile[tilenum2].collision==true)
    {
  	  entity.collisionon=true;
    }
  	break;
    case "left" :entityleftcol=(entityleftworldx-entity.speed)/tf.tilesize;
    tilenum1=tf.tilem.maptilenum[entityleftcol][entitytoprow];
    tilenum2=tf.tilem.maptilenum[entityrightcol][entitybottomrow];
    if(tf.tilem.tile[tilenum1].collision==true|| tf.tilem.tile[tilenum2].collision==true)
    {
  	  entity.collisionon=true;
    }
  	break;
    }
  
}
}
