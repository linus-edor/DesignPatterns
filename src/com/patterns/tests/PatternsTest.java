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
import com.patterns.factory.Client;
import com.patterns.factory.FourWheeler;
import com.patterns.factory.FourWheelerFactory;
import com.patterns.factory.TwoWheeler;
import com.patterns.factory.TwoWheelerFactory;
import com.patterns.factory.Vehicle;
import com.patterns.factory.VehicleFactory;
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


	@ThreadCount(1)
	@Test
	public void testFactoryMethodPattern() {
	        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
	        Client twoWheelerClient = new Client(twoWheelerFactory);
	        Vehicle twoWheeler = twoWheelerClient.getVehicle();
	        twoWheeler.printVehicle();

	        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
	        Client fourWheelerClient = new Client(fourWheelerFactory);
	        Vehicle fourWheeler = fourWheelerClient.getVehicle();
	        fourWheeler.printVehicle();
	    
	        assertTrue(twoWheeler != null && twoWheeler instanceof TwoWheeler);
	        assertTrue(fourWheeler != null && fourWheeler instanceof FourWheeler);
	        
	        assertEquals("two wheeler", twoWheeler.printVehicle());
	        assertEquals("four wheeler", fourWheeler.printVehicle());
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
		BankAccount account = new BankAccountBuilder("Linus", "00102993230293")
				.isActive(true).wantsNewsLetter(true)
				.withEmail("ll.ed@mail.com")
				.build();
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
