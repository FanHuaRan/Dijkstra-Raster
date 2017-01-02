package pers.fhr.dijkstraraster.component;

import java.util.ArrayList;
import java.util.List;

import pers.fhr.dijkstraraster.model.PointNode;

/**
 * 邻接矩阵驱动类
 * @author fhr
 *
 */
public class EngineUtil {
	private static final float MAXDIS=1000000f;
	/**
	 * 根据节点数组构建邻接矩阵
	 * @param nodes
	 * @return
	 */
	public static List<List<Float>> buidCost(List<PointNode> nodes){
		//初始化操作
		List<List<Float>> cost=new ArrayList<>();
		for(int i=0;i<nodes.size();i++){
			cost.add(new ArrayList<>());
		}
		for(List<Float> temp :cost){
			for(int i=0;i<nodes.size();i++){
				temp.add(MAXDIS);
			}
		}
		for(int i=0;i<nodes.size();i++){
			PointNode node=nodes.get(i);
			int index1=findNode(nodes,node.getX()-1,node.getY());
			if(index1!=-1){
				DealTwoPoint(nodes,cost,i,index1,0);
			}
			int index2=findNode(nodes,node.getX(),node.getY()+1);
			if(index2!=-1){
				DealTwoPoint(nodes,cost,i,index2,0);
			}
			int index3=findNode(nodes,node.getX()+1,node.getY());
			if(index3!=-1){
				DealTwoPoint(nodes,cost,i,index3,0);
			}
			int index4=findNode(nodes,node.getX(),node.getY()-1);
			if(index4!=-1){
				DealTwoPoint(nodes,cost,i,index4,0);
			}
			int index5=findNode(nodes,node.getX()-1,node.getY()-1);
			if(index5!=-1){
				DealTwoPoint(nodes,cost,i,index5,0);
			}
			int index6=findNode(nodes,node.getX()-1,node.getY()+1);
			if(index1!=-1){
				DealTwoPoint(nodes,cost,i,index6,0);
			}
			int index7=findNode(nodes,node.getX()+1,node.getY()-1);
			if(index7!=-1){
				DealTwoPoint(nodes,cost,i,index7,0);
			}
			int index8=findNode(nodes,node.getX()+1,node.getY()+1);
			if(index8!=-1){
				DealTwoPoint(nodes,cost,i,index8,0);
			}
		}
		return null;
	}
	/**
	 * 处理两个结点之间的权重关系
	 * @param nodes
	 * @param cost
	 * @param i
	 * @param j
	 * @param flag
	 */
	private static void DealTwoPoint(List<PointNode> nodes,List<List<Float>> cost,int i,int j,int flag){
		PointNode node1=nodes.get(i);
		PointNode node2=nodes.get(j);
		//指向
		if(flag==0){
			cost.get(i).set(j,(node1.getCount()+node2.getCount())/2);
		}
		//斜向
		if(flag==1){
			cost.get(i).set(j,(float)((node1.getCount()+node2.getCount())/2*1.414));
		}
	}
	/**
	 * 寻找节点
	 * @param nodes
	 * @param x
	 * @param y
	 * @return
	 */
	public static int findNode(List<PointNode> nodes,int x,int y){
		for(int i=0;i<nodes.size();i++){
			PointNode node=nodes.get(i);
			if(node.getX()==x&&node.getY()==y){
				return i;
			}
		}
		return -1;
	}
	/**
	 * 将二维数组转换为节点数组
	 * 如果元素值为1，则该位置无节点
	 * @param arrays
	 * @return
	 */
	public static List<PointNode> convert2DArrayToPointNodes(float [][] arrays){
		List<PointNode> pointNodes=new ArrayList<>();
		if(arrays==null){
			return null;
		}
		for(int i=0;i<arrays.length;i++){
			float[]row=arrays[i];
			for(int j=0;j<row.length;j++){
				float value=row[j];
				if(value>=0){
					PointNode node=new PointNode(j, i,value);
					pointNodes.add(node);
				}
			}
		}
		return pointNodes;
	}
}
