package woodspring.springgreenview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import woodspring.springgreenview.common.Status;
import woodspring.springgreenview.controller.EmployeeController;
import woodspring.springgreenview.model.F_physician;
import woodspring.springgreenview.repository.F_physicianRepository;
import woodspring.springgreenview.repository.F_physicianRepository;
import woodspring.springgreenview.service.PhysicianService;


@Service
@Slf4j
public class PhysicianServiceImpl implements PhysicianService {
	@Autowired
	F_physicianRepository physicianRepo;
	
	@Override
	public Flux<F_physician> listPhysician() {
		Flux<F_physician> empList = physicianRepo.findAll();
		return empList;
	}

	@Override
	public Mono<F_physician> getPhysicianByCpso(String cpso) {
		Mono<F_physician> aEmp = physicianRepo.findByCpso(cpso);
		return aEmp;
	}

	@Override
	public Flux<F_physician> getPhysicianByName(String firstname, String lastname) {
		Flux<F_physician> empList = physicianRepo.findPhysicianByFullName(firstname, lastname);
		return empList;
	}

	@Override
	public Flux<F_physician> listPhysicianByStatus(String status) {
		Flux<F_physician> empList = physicianRepo.findPhysicianByStatus(status);
		return empList;
	}

	@Override
	public Mono<F_physician> putPhysician(F_physician Physician) {
		Physician.setStatus(Status.ACTIVE.state());
		Mono<F_physician> retEmpl = physicianRepo.save( Physician);
		return retEmpl;
	}

	@Override
	public Mono<F_physician> modifyPhysician(F_physician Physician) {
		Mono<F_physician> retEmpl = physicianRepo.save( Physician);
		return retEmpl;
	}

	@Override
	public Mono<F_physician> deletePhysician(String cpso) {
		Mono<F_physician> aEmp = physicianRepo.findByCpso( cpso);
		F_physician theEmpl = aEmp.block();
		theEmpl.setStatus(Status.DISABLE.toString());
		Mono<F_physician> retEmpl = physicianRepo.save( theEmpl);
		return retEmpl;
	}

}
