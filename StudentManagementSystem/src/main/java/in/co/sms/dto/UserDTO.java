package in.co.sms.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "s_user")
@Setter
@Getter
public class UserDTO extends BaseDTO {

	@Column(name = "first_name", length = 255)
	private String firstName;
	@Column(name = "last_name", length = 255)
	private String lastName;
	@Column(name = "gender", length = 255)
	private String gender;
	@Column(name = "contactNo", length = 255)
	private String contactNo;
	@Column(name = "login", length = 255)
	private String login;
	@Column(name = "password", length = 255)
	private String password;
	@Column(name = "role_id", length = 255)
	private Long roleId;
	@Column(name = "dob", length = 255)
	private String dob;
	@Transient
	private String confirmPassword;	
	@Column(name = "ROLE_NAME",length = 225)
	private String roleName;
	@Column(name = "country", length = 255)
	private String country;
	@Column(name = "state", length = 255)
	private String state;
	@Column(name = "city", length = 255)
	private String city;
	@Column(name = "course", length = 255)
	private String course;
	@Column(name = "school", length = 255)
	private String school;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<FeeDTO> listOfFee = new ArrayList<FeeDTO>();
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<AttendenceDTO> listOfAttendence = new ArrayList<AttendenceDTO>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<MarksheetDTO> marksheets = new ArrayList<MarksheetDTO>();
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
