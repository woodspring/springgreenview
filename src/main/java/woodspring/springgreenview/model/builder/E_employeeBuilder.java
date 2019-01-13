package woodspring.springgreenview.model.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import woodspring.springgreenview.model.E_employee;


@Slf4j
public class E_employeeBuilder {
	private static ObjectMapper mapper = new ObjectMapper();
	private E_employee eEmployee = new E_employee();
							
	public E_employee build() {
		return eEmployee;
	}

	public E_employeeBuilder setFphId(Integer empId) {
		eEmployee.setEmpId(empId);
		return this;
	}

	public E_employeeBuilder setName(String name) {
		eEmployee.setName( name);
		return this;
	}


	public E_employeeBuilder setLastname(String lastname) {
		eEmployee.setLastname( lastname);
		return this;
	}

	public E_employeeBuilder setFirstname(String firstname) {
		eEmployee.setFirstname(firstname);
		return this;
	}

	public E_employeeBuilder setSamAccountName(String samAccountName) {
		eEmployee.setSamAccountName(samAccountName);
		return this;
	}

	public E_employeeBuilder setDepartment(String department) {
		eEmployee.setDepartment(department);
		return this;
	}

	public E_employeeBuilder setTitle(String title) {
		eEmployee.setTitle(title);
		return this;
	}

	public E_employeeBuilder setEmail(String email) {
		eEmployee.setEmail(email);
		return this;
	}
	
	public E_employeeBuilder setDialNumber(String dailNumbr) {
		eEmployee.setDialNumber(dailNumbr);
		return this;
	}

	public E_employeeBuilder setDirectDialNumber(String directDailNumbr) {
		eEmployee.setDirectDialNumber(directDailNumbr);
		return this;
	}
	
	public E_employeeBuilder setAlternateNumber(String alternateNumbr) {
		eEmployee.setAlternateNumber(alternateNumbr);
		return this;
	}

	public E_employeeBuilder setHomePhone(String homePhone) {
		eEmployee.setHomePhone(homePhone);
		return this;
	}

	public E_employeeBuilder setMobilePhone(String mobilePhone) {
		eEmployee.setMobilePhone(mobilePhone);
		return this;
	}

	public E_employeeBuilder setFaxPhone(String faxPhone) {
		eEmployee.setFaxPhone(faxPhone);
		return this;
	}

	public E_employeeBuilder setWorkPhone(String workPhone) {
		eEmployee.setWorkPhone(workPhone);
		return this;
	}

	public E_employeeBuilder setPaging(String paging) {
		eEmployee.setPaging( paging);
		return this;
	}

	public E_employeeBuilder setManager(String manager) {
		eEmployee.setManager(manager);
		return this;
	}


	public E_employeeBuilder setOfficePhone(String officePhone) {
		eEmployee.setOfficePhone(officePhone);
		return this;
	}

	public E_employeeBuilder setStatus(String status) {
		eEmployee.setStatus(status);
		return this;
	}
	public E_employeeBuilder setEmployeeNum(String employeeNum) {
		eEmployee.setEmployeeNum(employeeNum);
		return this;
	}


	public E_employeeBuilder setUUID(String uuid) {
		eEmployee.setUUID(uuid);
		return this;
	}


	public E_employeeBuilder setDepCode(String depCode) {
		eEmployee.setDepCode(depCode);
		return this;
	}

	public E_employeeBuilder setLocation(String location) {
		eEmployee.setLocation(location);
		return this;
	}

	
//	public E_employeeBuilder cloneFromPhysicianContact(Physician_Contact pc) {
//
//		eEmployee.setFirstname(pc.getFirstname());
//		eEmployee.setLastname(pc.getLastname());
//		eEmployee.setName(pc.getName());
//		eEmployee.setHomePhone(pc.getHomePhone());
//		eEmployee.setWorkPhone(pc.getWorkPhone());
//		eEmployee.setMobilePhone(pc.getMobilePhone());
//		eEmployee.setOfficePhone(pc.getOfficePhone());
//		eEmployee.setFaxPhone(pc.getFaxPhone());
//		eEmployee.setPaging(pc.getPaging());
//		eEmployee.setDepartment(pc.getDepartment());
//		eEmployee.setTitle(pc.getTitle());
//		
//		//eEmployee.setDepCode(pc.depCode);
//		eEmployee.setUUID("P"+pc.getCpso());
//		eEmployee.setLocation(pc.getLastname());
//		eEmployee.setStatus(Status.PENDING.state());
//		return this;
//	}

	@Override
	public String toString() {
		return "E_employeeBuilder E_employee:[" + eEmployee.toString()+ "]";
	}


	public static String toJsonString(E_employee E_employee) {
		String retStr = null;
		try {
			retStr = mapper.writeValueAsString(E_employee);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("E_employee::toJsonString, exception:"+ e.getMessage());
		}
		
		return retStr;
		
	}

}
