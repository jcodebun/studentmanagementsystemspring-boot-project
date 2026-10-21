package in.co.sms.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import in.co.sms.dto.BaseDTO;
import in.co.sms.dto.ClassesDTO;
import in.co.sms.dto.SubjectDTO;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class SubjectForm extends BaseForm {


	@NotEmpty(message = "Subject Name is required")
	private String subjectName;
	@NotEmpty(message = "Subject Description is required")
	private String subjectDescription;
	@Override
	public BaseDTO getDTO() {
		SubjectDTO bean = new SubjectDTO();
		bean.setId(id);
		bean.setSubjectName(subjectName);
		bean.setSubjectDescription(subjectDescription);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		SubjectDTO bean = (SubjectDTO)bDto;
		id = bean.getId();
		subjectName = bean.getSubjectName();
		subjectDescription = bean.getSubjectDescription();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
