package evolution.spring;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.springframework.util.Assert;

public class AssertDemo {
	@Test
	public void testNotNull() {
		String string = null;
		Assert.notNull(string, "The string must not be null.");
	}
	
	@Test
	public void testNotEmpty() {
		List<String> strings = new LinkedList<>();
		Assert.notEmpty(strings, "The list must not be empty.");
	}
}
