package main;
import javax.swing.*;
public class main {
	
public static void main(String args[]) {
	 
	JFrame fr=new JFrame();
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fr.setResizable(false);
	fr.setTitle("ADVT GAME_hithesh");
		fr.setLocationRelativeTo(null);	
		gamepanel tf=new gamepanel();
		fr.add(tf);
		//fr.setSize(height,width);
		fr.pack();
		fr.setVisible(true);
		tf.Setupgame();
		
		tf.startthread();
		
}
}
