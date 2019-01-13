package woodspring.springgreenview.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import woodspring.springgreenview.common.Status;
import woodspring.springgreenview.controller.EmployeeController;
import woodspring.springgreenview.model.E_employee;
import woodspring.springgreenview.model.builder.E_employeeBuilder;
import woodspring.springgreenview.repository.E_employeeRepository;
import woodspring.springgreenview.service.EmployeeService;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	E_employeeRepository employeeRepo;
	
	@Override
	public Flux<E_employee> listEmployee() {
		Flux<E_employee> empList = employeeRepo.findAll();
		return empList;
	}

	@Override
	public Mono<E_employee> getEmployeeById(String empId) {
		Mono<E_employee> aEmp = employeeRepo.findByEmployeeNum( Integer.valueOf( empId));
		return aEmp;
	}

	@Override
	public Flux<E_employee> getEmployeeByName(String firstname, String lastname) {
		Flux<E_employee> empList = employeeRepo.findEmployeeByFullName(firstname, lastname);
		return empList;
	}

	@Override
	public Flux<E_employee> listEmployeeByStatus(String status) {
		Flux<E_employee> empList = employeeRepo.findEmployeeByStatus(status);
		return empList;
	}

	@Override
	public Mono<E_employee> putEmployee(E_employee employee) {
		employee.setStatus(Status.ACTIVE.state());
		Mono<E_employee> retEmpl = employeeRepo.save( employee);
		return retEmpl;
	}

	@Override
	public Mono<E_employee> modifyEmployee(E_employee employee) {
		Mono<E_employee> retEmpl = employeeRepo.save( employee);
		return retEmpl;
	}

	@Override
	public Mono<E_employee> deleteEmployee(String empId) {
		Mono<E_employee> aEmp = employeeRepo.findByEmployeeNum( Integer.valueOf( empId));
		E_employee theEmpl = aEmp.block();
		theEmpl.setStatus(Status.DISABLE.toString());
		Mono<E_employee> retEmpl = employeeRepo.save( theEmpl);
		return retEmpl;
	}

	@Override
	public Mono<Integer> loadE_Employee(String filename) {
	    int recNo = 0;
			  File file = new File(filename);
			  //File file = new File("C://NYGH//"+filename);
		        try {
		            // Create a new Scanner object which will read the data
		            // from the file passed in. To check if there are more 
		            // line to read from it we check by calling the 
		            // scanner.hasNextLine() method. We then read line one 
		            // by one till all lines is read.
		            Scanner scanner = new Scanner(file);
		            while (scanner.hasNextLine()) {
		                String line = scanner.nextLine();
		                System.out.println(line);
		                if (line.contains("##")) continue;
		                if (line.contains("|||||||||||||||||||")) continue;
		                //if (line.length() < 3) return;
						String[] fields = line.split("\\|");
						if (fields[0] == null) continue; 
						if (fields[0].isEmpty()  || fields[0].contains("##") ) {}
						else {
							//if (fields.length < 13 )
								//System.out.println("short List for :["+ line+"] field length:["+fields.length+"]");
						System.out.println(" recNo:"+ recNo+" line:["+ line+"]");		
							//System.out.println("short List for :["+ line+"] fields no:["+ fields.length+"]");
							// 0          | 1        |     2    |  3  |     4     |    5   |          6       |      7     |         8      |          9      |      10   |    11      |         12  |      13  |        14  | 15           | 16    | 17 | 18        |  19  | 20                      
							//## Last Name|First Name|Department|Title|Dial Number|Location|Direct Dial Number|OfficeNumber|Alternate Number|Cell Phone Number|Home Number|	Fax Number |Pager Number |PagingType|Instructions|SamAccountName|Manager|UUID|EmployeeNum| Email|Cost Center
						
						//## Last Name|First Name|Department|Job Title|Dial Number|Location|Direct Dial Number|Office Number|Alternate Number|Cell Phone Number|Home Number|Pager Number|Paging Vendor/Type|Instructions|Network Username or 3-4 ID|Email |CPSO ( College of Physicians & Surgeons of Ontario) Number|| 
							E_employee employee = new E_employeeBuilder()
														//.setName(fields[0])
										.setLastname(fields[ 0])
										.setFirstname(fields[ 1])
										.setName(fields[0]+", "+ fields[ 1])
										.setDepartment(fields[ 2])
										.setTitle((fields.length < 4 ) ? "":  (fields[ 3 ] == null || fields[ 3 ].isEmpty() ) ?"-" : fields[ 3])
										.setDialNumber( (fields.length < 5 ) ? "":  (fields[ 4 ] == null || fields[ 4 ].isEmpty() ) ?"-" : fields[ 4])
										.setLocation((fields.length < 6 ) ? "":  (fields[ 5 ] == null || fields[ 5 ].isEmpty() ) ?"-" : fields[ 5])
										.setDirectDialNumber( (fields.length < 7) ? "":  (fields[ 6 ] == null || fields[ 6 ].isEmpty() ) ?"-" : fields[ 6])
										.setOfficePhone( (fields.length < 8) ? "":  (fields[ 7 ] == null || fields[ 7 ].isEmpty() ) ?"-" : fields[ 7])
										.setAlternateNumber( (fields.length < 9) ? "":  (fields[ 8 ] == null || fields[ 8 ].isEmpty() ) ?"-" : fields[ 8])
										.setMobilePhone( (fields.length < 10) ? "":  (fields[ 9] == null || fields[ 9 ].isEmpty() ) ?"-" : fields[ 9])
										.setHomePhone( (fields.length < 11) ? "":  (fields[ 10 ] == null || fields[ 10 ].isEmpty() ) ?"-" : fields[ 10])
										.setFaxPhone((fields.length < 12) ? "":  (fields[11] == null || fields[11].isEmpty() ) ?"-" : fields[11])
										.setPaging( (fields.length < 13) ? "":  (fields[12] == null || fields[12].isEmpty() ) ?"-" : fields[12]) 
										.setSamAccountName( (fields.length < 16) ? "":  (fields[15] == null || fields[15].isEmpty() ) ?"-" : fields[15]) 
										.setManager( (fields.length < 17) ? "":  (fields[16] == null || fields[16].isEmpty() ) ?"-" : fields[16]) 
										//.setCpso( (fields.length < 17) ? "":  (fields[16] == null || fields[16].isEmpty() ) ?"-" : fields[16]) 
										.setUUID( (fields.length < 18) ? "":  (fields[17] == null || fields[17].isEmpty() ) ? "-" : fields[17])
										.setEmployeeNum( (fields.length < 19) ? "":  (fields[18] == null || fields[18].isEmpty() ) ? "-" : fields[18].trim())
										.setEmail( (fields.length < 20) ? "":  (fields[19] == null || fields[19].isEmpty() ) ? "-" : fields[19])
										.setDepCode( (fields.length < 21) ? "":  (fields[20] == null || fields[20].isEmpty() ) ? "-" : fields[20]) 
										.setStatus("ACTIVE")
										.build();
							Mono<E_employee> theEmp = employeeRepo.save( employee );
							//Mono<E_employee> empList = employeeRepo.findByEmployeeNum( Integer.valueOf( emplyee.getEmployeeNum() ) ) ;
							//List<E_employee> fPhList = fPhysicianRepository.findByName(fPhContact.getFirstname(),  fPhContact.getLastname());
//							empList.doOnError( item -> {
//								
//							})
//							.switchIfEmpty( () -> {
//								
//							})
//							
//									)!= null && !empList.isEmpty()) {
//								E_employee theEmp = empList.get(0);
//								//theEmp = checkModify( theFPh, fPhContact);
//								eEmployeeRepository.saveAndFlush(theEmp);
//								log.info(" E_employee find one and updated");
//							} else {
//								eEmployeeRepository.saveAndFlush(emplyee);
//								log.info(" E_employee new record");
//								System.out.println(" E_employee new record current:"+ recNo);
//							}
//							employeeRepo.save( employee);
							recNo++;
						}
		            }
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        }
			

		return Mono.just(Integer.valueOf(recNo));
	}
}
