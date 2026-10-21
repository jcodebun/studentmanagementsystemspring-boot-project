package in.co.sms.form;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import in.co.sms.dto.BaseDTO;
import in.co.sms.dto.MarksheetDTO;
import in.co.sms.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class MarksheetForm extends BaseForm{

	@NotNull(message = "Student is required")
	private Long userId;
	
	private UserDTO user;
	@NotEmpty(message = "Roll No is required")
	private String rollNo;
	@NotNull(message = "Physics Marks is required")
	private Long physics;
	@NotNull(message = "Chemistry Marks is required")
	private Long chemistry;
	@NotNull(message = "Maths Marks is required")
	private Long maths;
	@Override
	public BaseDTO getDTO() {
		MarksheetDTO bean = new MarksheetDTO();
		bean.setId(id);
		bean.setRollNo(rollNo);
		bean.setUser(user);
		bean.setUserId(userId);
		bean.setPhysics(physics);
		bean.setChemistry(chemistry);
		bean.setMaths(maths);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		MarksheetDTO bean = (MarksheetDTO)bDto;
		id = bean.getId();
		user = bean.getUser();
		userId = bean.getUserId();
		rollNo = bean.getRollNo();
		physics = bean.getPhysics();
		chemistry = bean.getChemistry();
		maths = bean.getMaths();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
