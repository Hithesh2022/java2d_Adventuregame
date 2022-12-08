package main;

import object.objkey;

public class assetsetter {
gamepanel tf;
public assetsetter(gamepanel tf)
{
this.tf=tf;	
}
public void setobject()
{
	tf.obj[0]=new objkey();
	tf.obj[0].worldx=20*tf.tilesize;
	tf.obj[0].worldy=7*tf.tilesize;
	
	tf.obj[1]=new objkey();
	tf.obj[1].worldx=23*tf.tilesize;
	tf.obj[1].worldy=24*tf.tilesize;
}
}
