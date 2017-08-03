package evolution.service.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import org.springframework.web.client.RestTemplate;

public class MultiTasker {
	ExecutorService executorService;
	
	public MultiTasker() {
		executorService = Executors.newCachedThreadPool();
	}
	
	public interface SupplierBeforeJdk8<T> {
		public T get();
	}
	
	public <T> Future<T> run(final Supplier<T> supplier) {// A supplier takes no argument and returns one result.
		return executorService.submit(new Callable<T>() {
			@Override
			public T call() throws Exception {
				return supplier.get();
			}
		});
	}
	
	public <T> Future<T> runBeforeJdk8(final SupplierBeforeJdk8<T> supplier) {// A supplier takes no argument and returns one result.
		return executorService.submit(new Callable<T>() {
			@Override
			public T call() throws Exception {
				return supplier.get();
			}
		});
	}
	
	public static void main(String[] args) {
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
