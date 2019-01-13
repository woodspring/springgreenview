package woodspring.springgreenview.model;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection="e_employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class E_employee implements Serializable {
	
	@Id
	public ObjectId _id;
	
	@Indexed(unique=true)
	private Integer empId;
	
	private String name;

	private String lastname;

	private String firstname;
	
	private String samAccountName;

	private String department;
	
	private String title;
	
	private String email;
	
	private String dialNumber ;
	
	private String directDialNumber ;
	
	private String alternateNumber ;
	
	private String homePhone;
	
	private String mobilePhone;
	
	private String faxPhone;

	private String workPhone;
	
	private String paging;
		
	private String manager;

	private String officePhone;
	
	private String employeeNum;

	private String UUID;

	private String depCode;

	private String location;
	
	private String status;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdDate;


}
