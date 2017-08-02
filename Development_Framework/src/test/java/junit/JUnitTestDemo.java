package junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitTestDemo {
	@BeforeClass// Runs only once at the start of the program.
	public static void beforeClass() {
		System.out.println("Before class method is run only once.");
	}
	
	@AfterClass// Runs only once at the end of the program.
	public static void afterClass() {
		System.out.println("After class method is run only once.");
	}
	
	@Before// Runs before each one of the test method.
	public void before() {
		System.out.println("Before method has been called.");
	}
	
	@After// Runs after each one of the test method.
	public void after() {
		System.out.println("After method has been called.");
	}
	
	@Test(timeout = 100)// Allows maximum of 100 ms.
	public void testAssertEquals() {
		assertEquals(0, 0);
		assertEquals("0 * anything = 0", 0, 0);
	}
	
	@Test
	public void testAssertNotEquals() {
		assertNotEquals(0, 1);
		assertNotEquals("0 * anything = 0", 0, 1);
	}
	
	@Test
	public void testAssertTrue() {
		assertTrue(true);
		assertTrue("It must be true", true);
	}
	
	@Test
	public void testAssertFalse() {
		assertFalse(false);
		assertFalse("It must be false", false);
	}
	
	@Test
	public void testAssertArrayEquals() {
		assertArrayEquals(new String[] {"Chen", "Li"}, new String[] {"Chen", "Li"});
	}
	
	@Test
	@Ignore// Ignore the test.(Why don't you just delete the @Test annotation?)
	public void testIgnore() {
		System.out.println("The test has been ignored.");
	}
}
