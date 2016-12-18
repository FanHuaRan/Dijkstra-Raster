package pers.fhr.dijkstraraster.ui;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;

public class DijkWindow extends JFrame {

	private static final long serialVersionUID = 2998685707355471631L;
	private GridLayout gridLayout=null;
	private List<List<Float>> cost;
	public void setCost(List<List<Float>> cost) {
		this.cost=cost;
	}
	private DijkWindow(List<List<Float>> cost){
		super("迪杰斯特拉算法演示");
		setWindow();
	}
	public DijkWindow(){
		super("迪杰斯特拉算法演示");
		setWindow();
	}
	public void setWindow(){
		setSize(550,450);
		setLocation(20,20);
		//设置窗体居中显示
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false); //设置为不可调整大小
		gridLayout=new GridLayout(50, 30);
		setLayout(gridLayout);
	}

	//横纵格之间都间隔10像素，起点在（20,40）
	public void paint(Graphics g){
		//绘制横向线
		for(int i=0;i<=5;i++){
			g.drawLine(0, i*20, this.getWidth()-1, i*20);
		}
		//绘制纵向线
		for(int i=0;i<=9;i++){
			g.drawLine(i*10, 0, 20+i*10, 90);
		}
	}
}
