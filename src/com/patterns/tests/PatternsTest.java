package com.patterns.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;
import com.patterns.factory.Circle;
import com.patterns.factory.Drawing;
import com.patterns.factory.DrawingFactory;
import com.patterns.factory.Rectangle;
import com.patterns.factory.Square;
import com.patterns.singleton.AddData;
import com.patterns.singleton.MySingleton;

@RunWith(ConcurrentTestRunner.class)
public class PatternsTest {

	AddData addData = new AddData();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		addData.initialize(1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// Factory method pattern
		DrawingFactory factory = new DrawingFactory();
		Drawing circle = factory.getDrawing("Circle");
		assertTrue(circle instanceof Circle);
		assertEquals(300, circle.getArea());

		Drawing square = factory.getDrawing("Square");
		assertTrue(square instanceof Square);
		assertEquals(100, square.getArea());

		Drawing rect = factory.getDrawing("rectangle");
		assertTrue(rect instanceof Rectangle);
		assertEquals(50, rect.getArea());
	}

	private static final int THREAD_COUNT = 4; // number of concurrent processes

	@Test
	@ThreadCount(THREAD_COUNT) // run this unit concurrently
	public void testData() {
		addData.addOne();
	}

	// Singleton test
	@After
	public void testSingleton() {
		Object[] data = MySingleton.getInstance().getData().toArray();
		Arrays.sort(data);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, data);
		assertNotEquals(new Integer[] { 1, 2, 3, 4 }, data);
	}

}
