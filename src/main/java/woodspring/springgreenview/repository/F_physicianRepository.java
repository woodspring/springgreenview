package woodspring.springgreenview.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import woodspring.springgreenview.model.F_physician;

public interface F_physicianRepository extends  ReactiveMongoRepository< F_physician, Integer> {

	//@Query("{ 'empId': ?0}")
		//Mono<F_physician> findByEmployeeNum(Integer empId);

		//@Query("{ 'samAccountName': ?0}")
		Mono<F_physician> findBySamAccountName(String samAccountName);

		//@Query("{ 'UUID': ?0}")
		Mono<F_physician> findByCpso(String cpso);
	
	   @Query("{firstName:{ $regex : '?0', $options : '' }, lastName: { $regex : '?1', $options : '' }}")
	    Flux<F_physician> findPhysicianByFullName(String firstname, String lastname);

	    Flux<F_physician> findPhysicianByStatus(String status);
}
