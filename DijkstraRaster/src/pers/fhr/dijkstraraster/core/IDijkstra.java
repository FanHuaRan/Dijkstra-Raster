package pers.fhr.dijkstraraster.core;

import java.util.List;

/**
 * 迪杰斯特拉算法接口
 * @author fhr
 *
 */
public interface IDijkstra {
  /**
   * 求起点对所有节点的最短路径
   * @param cost
   * @param start
   * @param distances
   * @return
   */
  List<List<Integer>> dijkstraMethod(List<List<Float>> cost,int start,List<Float> distances);
  /**
   * 求两节点的最短路径
   * @param cost
   * @param start
   * @param end
   * @param distance
   * @return
   */
  List<Integer> dijkstraMethod(List<List<Float>> cost,int start,int end,Float distance);
}
