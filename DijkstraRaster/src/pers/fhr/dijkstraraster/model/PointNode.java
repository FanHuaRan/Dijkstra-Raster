package pers.fhr.dijkstraraster.model;
/**
 * 节点
 * @author fhr
 *
 */
public class PointNode {
	//横索引
	private int x;
	//竖索引
	private int y;
	//耗费
	private float count;
	
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public void setCount(Float count){
		this.count=count;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public float getCount(){
		return this.count;
	}
	public PointNode(int x,int y,float count){
		this.x=x;
		this.y=y;
		this.count=count;
	}
	public PointNode(int x,int y){
		this.x=x;
		this.y=y;
		this.count=-1;
	}
}
