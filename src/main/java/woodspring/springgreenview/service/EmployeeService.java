package woodspring.springgreenview.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import woodspring.springgreenview.model.E_employee;

public interface EmployeeService {
	
	Flux<E_employee> listEmployee();
	
	Mono<E_employee> getEmployeeById(String empId);
	Flux<E_employee> getEmployeeByName(String firstname, String lastname);
	Flux<E_employee> listEmployeeByStatus(String status);
	Mono<E_employee> putEmployee(E_employee emplyee);
	Mono<E_employee> modifyEmployee(E_employee emplyee);
	Mono<E_employee> deleteEmployee(String empId);
	
	Mono<Integer> loadE_Employee(String filename);

}
