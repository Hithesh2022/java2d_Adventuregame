package object;

import java.io.*;

import javax.imageio.ImageIO;

public class objkey extends superobject {
public objkey()
{
name="key";
try {
	image=ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
	
}catch(IOException e)
{
	e.printStackTrace();
}
}
}
