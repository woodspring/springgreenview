package woodspring.springgreenview.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import woodspring.springgreenview.model.F_physician;

public interface PhysicianService {
	Flux<F_physician> listPhysician();
	
	Mono<F_physician> getPhysicianByCpso(String cpso);
	Flux<F_physician> getPhysicianByName(String firstname, String lastname);
	Flux<F_physician> listPhysicianByStatus(String status);
	Mono<F_physician> putPhysician(F_physician physician);
	Mono<F_physician> modifyPhysician(F_physician physician);
	Mono<F_physician> deletePhysician(String empId);

}
