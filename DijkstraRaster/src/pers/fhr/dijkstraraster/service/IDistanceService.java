package pers.fhr.dijkstraraster.service;

import java.util.List;

import pers.fhr.dijkstraraster.model.PointNode;

public interface IDistanceService {
	Object[] getShortPath(List<PointNode> nodes,int xStart,int yStart, int xEnd,int yEnd);
}
