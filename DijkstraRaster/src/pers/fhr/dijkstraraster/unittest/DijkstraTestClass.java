package pers.fhr.dijkstraraster.unittest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import java.util.stream.Collectors;

import pers.fhr.dijkstraraster.core.DijkstraClass;

public class DijkstraTestClass {
	private DijkstraClass dijksta=null;
	private List<List<Float>> cost=null;
	@Before
	public void setUp() throws Exception {
		dijksta=new DijkstraClass();
	    cost=new ArrayList<>();
		Float[]row1={0f,1f,7f,1000000000f};
		Float[]row2={1f,0f,6f,5f};
		Float[]row3={7f,6f,0f,2f};
		Float[]row4={1000000000f,5f,2f,0f};
		cost.add(Arrays.asList(row1));
		cost.add(Arrays.asList(row2));
		cost.add(Arrays.asList(row3));
		cost.add(Arrays.asList(row4));
	}

	@Test
	public void testDijkstraMethodListOfListOfFloatIntListOfFloat() {
		int start=0;
		List<Float> distances=new ArrayList<>();
		List<List<Integer>> paths=dijksta.dijkstraMethod(cost, start, distances);
		assertArrayEquals(paths.get(0).toArray(), new Object[]{0});
		assertArrayEquals(paths.get(1).toArray(), new Object[]{0,1});
		assertArrayEquals(paths.get(2).toArray(), new Object[]{0,2});
		assertArrayEquals(paths.get(3).toArray(), new Object[]{0,1,3});
		/*0
		0,1
		0,2
		0,1,3
		*/
	}

	@Test
	public void testDijkstraMethodListOfListOfFloatIntIntFloat() {
		/*
		List<List<Float>> cost=new ArrayList<>();
		Float[]row1={(float) 0,(float) 1,(float) 7,(float) 1000000000};
		Float[]row2={(float) 1,(float) 0,(float) 6,(float) 5};
		Float[]row3={(float) 7,(float) 6,(float) 0,(float) 2};
		Float[]row5={(float) 1000000000,(float) 5,(float) 2,(float) 0};
		*/
		int start=0;
		int end=3;
		Float distances=null;
		List<Integer> path=dijksta.dijkstraMethod(cost, start,end, distances);
		assertArrayEquals(path.toArray(), new Object[]{0,1,3});
	}

}
