package com.patterns.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.patterns.factory.Circle;
import com.patterns.factory.Drawing;
import com.patterns.factory.DrawingFactory;
import com.patterns.factory.Rectangle;
import com.patterns.factory.Square;

public class PatternsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//Factory method pattern
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

}
