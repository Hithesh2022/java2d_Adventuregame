package tile;

import java.awt.Graphics2D;
import java.io.*;



import javax.imageio.ImageIO;

import main.gamepanel;

public class tilemanager {
gamepanel tf;
public tile[] tile;
 public int maptilenum[][];
public tilemanager(gamepanel tf)
{ 
this.tf=tf;	
tile=new tile[10];
maptilenum=new int[tf.worldcol][tf.worldrow];
loadmap("/map/worldmap.txt");
tileimage();

}
public void tileimage()
{
	try {
		tile[0]=new tile();
		tile[0].image=ImageIO.read(getClass().getResourceAsStream("/tiles/battleground.png "));
		
		tile[1]=new tile();
		tile[1].image=ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png "));
		tile[1].collision=true;
		
		tile[2]=new tile();
		tile[2].image=ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
		tile[2].collision=true;
		
		tile[3]=new tile();
		tile[3].image=ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
		
		tile[4]=new tile();
		tile[4].image=ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
	    tile[4].collision=true;
	    
		tile[5]=new tile();
		tile[5].image=ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
	
	}catch(IOException e)
	{
		e.printStackTrace();
	}
	

}
public void loadmap(String filepath)
{
try {
	InputStream in= getClass().getResourceAsStream("/maps/worldmap.txt");
	BufferedReader br=new BufferedReader(new InputStreamReader(in));

{
	
}
int col=0;
int row=0;
while(col<tf.worldcol&&row<tf.worldrow)
{
String line =br.readLine();

while(col<tf.worldcol)
{
String numbers[]=line.split(" ");//split line to individual

int num=Integer.parseInt(numbers[col]);//convert map data to string
maptilenum[col][row]=num;
col++;

}
if(col==tf.worldcol)
{
col=0;
row++;

}
}
br.close();
}catch(Exception e )
{
	
}
}
public void draw(Graphics2D g2)
{

	//g2.drawImage(tile[0].image, 0, 0, tf.tilesize, tf.tilesize, null);
int worldcol=0;
int worldrow=0;

while(worldcol<tf.worldcol&& worldrow<tf.worldrow)
{  int tilenum=maptilenum[worldcol][worldrow];//get map data according to number load map
 int worldx=worldcol*tf.tilesize;
 int worldy=worldrow*tf.tilesize;
 int screenx=worldx-tf.Player.worldx+tf.Player.screenx;
 int screeny=worldy-tf.Player.worldy+tf.Player.screeny;
  	
   if(worldx+tf.tilesize>tf.Player.worldx-tf.Player.screenx&& worldx-tf.tilesize<tf.Player.worldx+tf.Player.screenx&& worldy+tf.tilesize>tf.Player.worldy-tf.Player.screeny&& worldy-tf.tilesize<tf.Player.worldy+tf.Player.screeny) 
   {
 g2.drawImage(tile[tilenum].image, screenx, screeny, tf.tilesize, tf.tilesize, null);
   }
 worldcol++;

if(worldcol==tf.worldcol)
{
worldcol=0;

worldrow++;

}
}

}


}
