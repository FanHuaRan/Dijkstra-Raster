package pers.fhr.dijkstraraster.ui;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;

import pers.fhr.dijkstraraster.component.RasterGraphicsUtil;
import pers.fhr.dijkstraraster.service.Distance;
import pers.fhr.dijkstraraster.service.IDistanceService;

public class DijkWindow extends JFrame {
	private static final long serialVersionUID = 2998685707355471631L;
	private IDistanceService distanceService=new Distance();
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
	//	RasterGraphicsUtil.DrawGrid(, 10, 10, this.getWidth(), this.getHeight());;
	}

	//横纵格之间都间隔10像素，起点在（20,40）
	public void paint(Graphics g){
		//RasterGraphicsUtil.DrawGrid(g, 10, 10, this.getWidth(), this.getHeight());;
	}
}
