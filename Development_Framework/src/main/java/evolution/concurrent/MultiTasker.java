package evolution.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

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
}
