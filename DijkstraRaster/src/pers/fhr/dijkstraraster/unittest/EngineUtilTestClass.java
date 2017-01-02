package pers.fhr.dijkstraraster.unittest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pers.fhr.dijkstraraster.component.EngineUtil;
import pers.fhr.dijkstraraster.model.PointNode;

public class EngineUtilTestClass {
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBuidCost() {
		//fail("Not yet implemented");
		List<PointNode> nodes=new ArrayList<>();
		//
		EngineUtil.buidCost(nodes);
		//
	}
	
	@Test
	public void testConvert2DArrayToPointNodes() {
		float[][]arrays={{7f,4f,7f,5f},
						{1f,6f,2f,5f},
						{1f,7f,0f,1f},
						{2f,8f,3f,2f}};
		List<PointNode> pointNodes=EngineUtil.convert2DArrayToPointNodes(arrays);
		assertEquals(pointNodes.size(), 16);
		PointNode node=pointNodes.get(9);
		//assertEquals(node.getCount(), 7.0);
		assertEquals(node.getX(), 1);
		assertEquals(node.getY(), 2);
	}

}
