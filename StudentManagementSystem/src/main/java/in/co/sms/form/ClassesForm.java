package in.co.sms.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import in.co.sms.dto.BaseDTO;
import in.co.sms.dto.ClassesDTO;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ClassesForm extends BaseForm {


	@NotEmpty(message = "Class Name is required")
	private String className;
	@NotEmpty(message = "Class Description is required")
	private String classDescription;
	@Override
	public BaseDTO getDTO() {
		ClassesDTO bean = new ClassesDTO();
		bean.setId(id);
		bean.setClassName(className);
		bean.setClassDescription(classDescription);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		ClassesDTO bean = (ClassesDTO)bDto;
		id = bean.getId();
		className = bean.getClassName();
		classDescription = bean.getClassDescription();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
