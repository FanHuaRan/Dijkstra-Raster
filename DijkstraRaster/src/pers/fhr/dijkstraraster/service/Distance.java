package pers.fhr.dijkstraraster.service;

import java.lang.reflect.Array;
import java.util.List;

import pers.fhr.dijkstraraster.component.EngineUtil;
import pers.fhr.dijkstraraster.core.DijkstraClass;
import pers.fhr.dijkstraraster.core.IDijkstra;
import pers.fhr.dijkstraraster.model.PointNode;

public class Distance implements IDistanceService{
	private IDijkstra dijkstra=new DijkstraClass();
	@Override
	public Object[] getShortPath(List<PointNode> nodes,int xStart,int yStart, int xEnd,int yEnd){
		List<List<Float>> cost=EngineUtil.buidCost(nodes);
		int start=EngineUtil.findNode(nodes, xStart, yStart);
		int end=EngineUtil.findNode(nodes, xEnd, yEnd);
		Float dis = null;
		List<Integer> path=dijkstra.dijkstraMethod(cost, start,end,dis);
		return path.stream().map(p->nodes.get(p)).toArray();

	}

}
