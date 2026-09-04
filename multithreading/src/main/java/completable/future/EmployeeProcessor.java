package completable.future;

import java.util.concurrent.CompletableFuture;

import dataset.Data;

public class EmployeeProcessor {

	public static void main(String[] args) throws Exception{
		CompletableFuture<Void> employeeListFuture=CompletableFuture
				.supplyAsync(()->Data.employees)
				.thenApplyAsync(employees->employees.stream().filter(emp->emp.salary()>80000))
				.thenAcceptAsync(employeeStream->employeeStream.forEach(System.out::println));

		employeeListFuture.get();
	}

}
