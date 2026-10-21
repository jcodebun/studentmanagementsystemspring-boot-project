package in.co.sms.form;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.sms.dto.BaseDTO;
import in.co.sms.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$", message = "First Name is Invalid")
	private String firstName;
	@NotEmpty(message = "Last Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$", message = "First Name is Invalid")
	private String lastName;
	@NotEmpty(message = "Gender is required")
	private String gender;
	@NotEmpty(message = "Phone No is required")
	@Pattern(regexp = "(^[7-9][0-9]{9})*$", message = "MobileNo is Invalid")
	private String contactNo;
	@NotEmpty(message = "Email Id is required")
	@Pattern(regexp = "(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$", message = "Email id is invalid")
	private String login;
	@NotEmpty(message = "Password is required")
	private String password;

	private Long roleId;
	@NotEmpty(message = "DOB is required")
	private String dob;

	private String roleName;
	@NotEmpty(message = "Country is required")
	private String country;
	@NotEmpty(message = "State is required")
	private String state;
	@NotEmpty(message = "City is required")
	private String city;
	@NotEmpty(message = "School Name is required")
	private String school;
	@NotEmpty(message = "Course is required")
	private String course;

	@Override
	public BaseDTO getDTO() {
		UserDTO bean = new UserDTO();
		bean.setId(id);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setLogin(login);
		bean.setPassword(password);
		bean.setConfirmPassword(password);
		bean.setContactNo(contactNo);
		bean.setRoleId(roleId);
		bean.setRoleName(roleName);
		bean.setDob(dob);
		bean.setGender(gender);
		bean.setCountry(country);
		bean.setCity(city);
		bean.setState(state);
		bean.setSchool(school);
		bean.setCourse(course);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		UserDTO bean = (UserDTO) bDto;
		id = bean.getId();
		firstName = bean.getFirstName();
		lastName = bean.getLastName();
		login = bean.getLogin();
		gender = bean.getGender();
		contactNo = bean.getContactNo();
		password = bean.getPassword();
		roleId = bean.getRoleId();
		roleName = bean.getRoleName();
		dob = bean.getDob();
		country = bean.getCountry();
		city = bean.getCity();
		state = bean.getState();
		school = bean.getSchool();
		course = bean.getCourse();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
