package pers.fhr.dijkstraraster.component;

import java.awt.Graphics;

public class RasterGraphicsUtil {
	
	public static void DrawGrid(Graphics graphics,int xCount,int yCount,int width,int height){
		float xSpan=width/xCount;
		float ySpan=height/yCount;
		//竖线
		for(int i=0;i<xCount;i++){
			graphics.drawLine((int)(i*xSpan),0, (int)(i*xSpan), height);
		}
		//横线
		for(int i=0;i<yCount;i++){
			graphics.drawLine(0,(int)(i*ySpan), width,(int)(i*ySpan));
		}
		
	}
}
