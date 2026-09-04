package completable.future;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import dataset.Data;
import dataset.Employee;

public class EmployeeProcessor {

	public static void main(String[] args) {
		CompletableFuture<Void> employeeListFuture=CompletableFuture
				.supplyAsync(()->Data.employees)
				.thenApplyAsync(employees->employees.stream().filter(emp->emp.salary()>80000))
				.thenAcceptAsync(employeeStream->employeeStream.forEach(System.out::println));

	}

}
