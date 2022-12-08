package main;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class keylisten implements KeyListener{
public boolean up,down,right,left;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub// only touch so not requrie as in game we press key
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getKeyCode();//input key
		if(code==KeyEvent.VK_W|| code==38)
		{
			up=true;
		}
		if(code==KeyEvent.VK_A|| code==37)
		{
			left=true;
		}
		if(code==KeyEvent.VK_D|| code==39)
		{
			right=true;
		}
		if(code==KeyEvent.VK_S||code==40)
		{
			down=true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getKeyCode();//input key
		if(code==KeyEvent.VK_W || code==38)
		{
			up=false;
		}
		if(code==KeyEvent.VK_A || code==37)
		{
			left=false;
		}
		if(code==KeyEvent.VK_D || code==39)
		{
			right=false;
		}
		if(code==KeyEvent.VK_S ||code==40 )
		{
			down=false;
		}
		
		
	}

}
