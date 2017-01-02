package pers.fhr.dijkstraraster.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GridPane extends JPanel {

	private static final long serialVersionUID = 1783593276022186913L;
	 public void paint(Graphics g){  
         int s = 60;//单元格大小  
         int c = 0;//单元格是否填充  
         int rc=20;//行列数  
         for(int i=0; i<rc; i++){  
           c++;  
         if(rc%2>0)++c;  
         for(int j=0; j<rc; j++){  
             g.drawRect(i*s,j*s,s,s);  
             if(++c%2!=0)  
             {  
                 g.fillRect(i*s,j*s,s,s);  
                 g.setColor(Color.black);  
             }  
       }  
     }  
     g.dispose();  
 }  
	
}
