package pers.fhr.dijkstraraster.unittest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pers.fhr.dijkstraraster.model.PointNode;
import pers.fhr.dijkstraraster.service.Distance;

public class DistanceServiceTest {
	Distance distance=null; 
	@Before
	public void setUp() throws Exception {
		distance=new Distance();
	}

	@Test
	public void testGetShortPath() { 
		List<PointNode> nodes=new ArrayList<>();
		nodes.add(new PointNode(0, 0,1));
		nodes.add(new PointNode(1, 0,2));
		nodes.add(new PointNode(0, 1,4));
		nodes.add(new PointNode(1, 1,3));
		Object [] result=distance.getShortPath(nodes, 1, 0, 0, 1);
		assertEquals(result.length, 2);
		
	}

}
