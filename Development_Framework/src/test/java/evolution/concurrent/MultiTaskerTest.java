package evolution.concurrent;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import evolution.concurrent.MultiTasker.SupplierBeforeJdk8;

public class MultiTaskerTest {
	@Test
	public void test() {
		MultiTasker multiTasker = new MultiTasker();
		RestTemplate restTemplate = new RestTemplate();
		/**
		 * The run() and runBeforeJdk8() have the same performance while run()
		 * applies the concise lambda expression.
		 */
		multiTasker.run(() -> restTemplate.getForObject("/get", String.class));
		/**
		 * You might wonder how runBeforeJdk8() returns Future<String> 
		 * or how is T set as String.
		 * The answer is that new SupplierBeforeJdk8<String>() 
		 * tells SupplierBeforeJdk8<T> that T is String.
		 * This is a typical example of type inference.
		 */
		multiTasker.runBeforeJdk8(new SupplierBeforeJdk8<String>() {
			@Override
			public String get() {
				return restTemplate.getForObject("/get", String.class);
			}
		});
		System.out.println("Done");
	}
}
