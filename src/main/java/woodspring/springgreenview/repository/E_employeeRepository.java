package woodspring.springgreenview.repository;




import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import woodspring.springgreenview.model.E_employee;


public interface E_employeeRepository extends  ReactiveMongoRepository< E_employee, Integer> {

	//@Query("{ 'empId': ?0}")
	Mono<E_employee> findByEmployeeNum(Integer empId);

	//@Query("{ 'samAccountName': ?0}")
	Mono<E_employee> findBySamAccountName(String samAccountName);

	//@Query("{ 'UUID': ?0}")
	Mono<E_employee> findByUUID(String uuid);
	
	@Query("{status:{ $regex : '?0', $options : '' }}")
    Flux<E_employee> findEmployeeByStatus(String status);
	
    @Query("{firstName:{ $regex : '?0', $options : '' }, lastName: { $regex : '?1', $options : '' }}")
    Flux<E_employee> findEmployeeByFullName(String firstname, String lastname);

}
