package pers.fhr.dijkstraraster.core;

import java.util.ArrayList;
import java.util.List;

public class DijkstraClass implements IDijkstra {

	@Override
	public List<List<Integer>> dijkstraMethod(List<List<Float>> cost, int start, List<Float> distances) {
		 if(cost==null||start<-1)
         {
			 distances = null;
             return null;
         }
         int n = cost.size();
         List<List<Integer>> path = new ArrayList<List<Integer>>();
         for(int i=0;i<n;i++)
         {
             path.add(new ArrayList<Integer>());
         }
         distances = new ArrayList<Float>(n);
         //是否找到最短路径的标志数组
         List<Integer> arrayFlag = new ArrayList<Integer>(n);
         for (int i = 0; i < n; i++)//初始化
         {
             arrayFlag.add(0);
             distances.add(cost.get(start).get(i));
             path.get(i).add(start);
         }
         arrayFlag.set(start, 1);
         int count = 1;
         int u = start;
         //控制循环n-1次
         while (count < n)
         {
             float temp = 1000000000;
             for (int i = 0; i < n; i++)//寻找没找到最短路径的当前路径权值最小的顶点
             {
                 if (arrayFlag.get(i) == 0 && distances.get(i) < temp)
                 {
                     u = i;
                     temp = distances.get(i);
                 }
             }
             arrayFlag.set(u, 1);
             path.get(u).add(u);
             for (int i = 0; i < n; i++)//寻找与u直接联通但没有确定最短路径的顶点,修改权值和路径
             {
                 if (arrayFlag.get(i) == 0 && distances.get(u) + cost.get(u).get(i)< distances.get(i))
                 {
                	 distances.set(i, distances.get(u) + cost.get(u).get(i));
                     path.get(i).clear();
                     for (int k = 0; k < path.get(u).size(); k++)
                     {
                         path.get(i).add(path.get(u).get(k));
                     }
                    // arrayFlag[i] = arrayFlag[u];
                 }
             }
             count++;
         }
         return path;
	}

	@Override
	public List<Integer> dijkstraMethod(List<List<Float>> cost, int start, int end, Float distance) {
	    if (cost == null || start < 0 || start > cost.size()-1||end<0||end>cost.size()-1)
        {
	    	distance = (float) 0;
            return null;
        }
	    List<Integer> singlePath=new ArrayList<>();
	    if(start== end)
	    {
	    	distance = (float) 0;
	    	singlePath.add(start);
            return singlePath;
	    }
	    List<Float> distances;
         int n = cost.size();
         List<List<Integer>> path = new ArrayList<List<Integer>>();
         for(int i=0;i<n;i++)
         {
             path.add(new ArrayList<Integer>());
         }
         distances = new ArrayList<Float>(n);
         //是否找到最短路径的标志数组
         List<Integer> arrayFlag = new ArrayList<Integer>(n);
         for (int i = 0; i < n; i++)//初始化
         {
             arrayFlag.add(0);
             distances.add(cost.get(start).get(i));
             path.get(i).add(start);
         }
         arrayFlag.set(start, 1);
         int count = 1;
         int u = start;
         //控制循环n-1次
         while (count < n)
         {
             float temp = 1000000000;
             for (int i = 0; i < n; i++)//寻找没找到最短路径的当前路径权值最小的顶点
             {
                 if (arrayFlag.get(i) == 0 && distances.get(i) < temp)
                 {
                     u = i;
                     temp = distances.get(i);
                 }
             }
             arrayFlag.set(u, 1);
             path.get(u).add(u);
             if(u==end){
            	 singlePath=path.get(u);
            	 break;
             }
             for (int i = 0; i < n; i++)//寻找与u直接联通但没有确定最短路径的顶点,修改权值和路径
             {
                 if (arrayFlag.get(i) == 0 && distances.get(u) + cost.get(u).get(i)< distances.get(i))
                 {
                	 distances.set(i, distances.get(u) + cost.get(u).get(i));
                     path.get(i).clear();
                     for (int k = 0; k < path.get(u).size(); k++)
                     {
                         path.get(i).add(path.get(u).get(k));
                     }
                    // arrayFlag[i] = arrayFlag[u];
                 }
             }
             count++;
         }
         return singlePath;
	}

}
