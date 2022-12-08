package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.*;

import javax.swing.*;

import entity.player;
import object.superobject;
import tile.tilemanager;
public  class   gamepanel extends JPanel implements Runnable {
	Thread th;
 public final int tilesize=16*3;
 public final int col=16;
 public final int row=12;
 public final  int width=tilesize*col;
 public final int height=tilesize*row;
	int fps=60;
	keylisten kh=new keylisten();
	 public player Player =new player( this,kh);
	tilemanager tilem=new tilemanager(this );
	/*int playerx=100;
	int playery=100;
	int playerspeed =2;*/
	public superobject obj[]=new superobject[10];
	public assetsetter asetter=new assetsetter(this);
	public collisioncheck ck=new collisioncheck(this);
	public final int worldcol=50;
	public final int worldrow=50;
	public final int worldwidth =tilesize*worldcol;
	public final int worldheight=tilesize*worldrow;
public gamepanel()
	{ 
		this.setPreferredSize(new Dimension(width,height));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(kh);//adding keylistner
		this.setFocusable(true);//will be focused while reciving key inputs
	}
public  void Setupgame()
{
	asetter.setobject();
}

public  void startthread()
{
	 th=new Thread(this);	
	th.start();

}
@Override
public void run() {
	
	
	double drawinterval =1000000000/fps;// calculating in nanosec cuz better percision
	double nextdraw=System.nanoTime()+drawinterval;
	while(th!=null)//until thread not null
	{System.out.print("running\n");
		update();
		
		repaint();	
		
	double remaining=nextdraw-System.nanoTime()	;
	remaining=remaining/1000000;//converting nano to million sec as try catch accepts mill sec
	
	if (remaining <0)//time cannot be negaative
	{
		remaining =0;
	}
	try {
		Thread.sleep( (long) remaining);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	nextdraw+=drawinterval;//updating next drawtime;
	}
	
	
	
}



private void update() {
	// TODO Auto-generated method stub
	Player.update();

}
public void paintComponent(Graphics g){ 
	
	super.paintComponent(g);
	Graphics2D g2= (Graphics2D)g;
	tilem.draw(g2);
	for(int i=0;i<obj.length;i++)
	{
		if(obj[i]!=null)
		{
			obj[i].draw(g2, this);
		
	}
	}
	Player.draw(g2);
	
	g2.dispose();// delete or free memory after every use
	
}


}
