package com.patterns.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;
import com.patterns.builder.BankAccount;
import com.patterns.builder.BankAccount.BankAccountBuilder;
import com.patterns.factory.Circle;
import com.patterns.factory.Drawing;
import com.patterns.factory.DrawingFactory;
import com.patterns.factory.Rectangle;
import com.patterns.factory.Square;
import com.patterns.prototype.Shape;
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
	@ThreadCount(1)
	public void testFactoryPattern() {
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

	@ThreadCount(1)
	@Test
	public void testPrototypePattern() {
		Shape rect = new com.patterns.prototype.Rectangle();
		rect.id = "1";
		rect.x = -1;
		rect.y = 1;
		Shape rect2 = rect.clone();
		assertEquals(-1, rect2.x);
		assertEquals(rect, rect2);
		assertTrue(rect.equals(rect2));
		assertTrue("These two shape objects are identical but different!",rect != rect2 && rect.equals(rect2));
		assertEquals(rect.id, rect2.id);
	}

	@Test
	@ThreadCount(1)
	public void testBuilderPattern() {
		BankAccount account = new BankAccountBuilder("Linus", "00102993230293").isActive(true).wantsNewsLetter(true)
				.withEmail("ll.ed@mail.com").build();
//		System.out.println("Account name::" + account.getAccountName());
		assertNotNull(account.getAccountName());
		assertNotNull(account.getAccountNumber());
		assertNotNull(account.getEmail());
		assertEquals("ll.ed@mail.com", account.getEmail());
		assertNull(account.getAccountType());
	}

	@Test
	@ThreadCount(4) // run this unit concurrently
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
