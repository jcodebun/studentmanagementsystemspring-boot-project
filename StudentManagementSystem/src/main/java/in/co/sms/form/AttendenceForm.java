package in.co.sms.form;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import in.co.sms.dto.AttendenceDTO;
import in.co.sms.dto.BaseDTO;
import in.co.sms.dto.ClassesDTO;
import in.co.sms.dto.SubjectDTO;
import in.co.sms.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AttendenceForm extends BaseForm {

	
	private UserDTO user;
	
	@NotNull(message = "Student is required")
	private Long userId;
	
	private ClassesDTO classes;
	@NotNull(message = "Class is required")
	private Long classId;
	
	
	private SubjectDTO subject;
	
	@NotNull(message = "Subject is required")
	private Long subjectId;
	
	@NotEmpty(message = "Attendence date is required")
	private String date;
	
	@NotEmpty(message = "Lecture Title is required")
	private String lectureTitle;
	
	//@NotEmpty(message = "Status is required")
	private String status;
	
	private String subjectName;
	
	private String className;
	
	@Override
	public BaseDTO getDTO() {
		AttendenceDTO bean = new AttendenceDTO();
		bean.setId(id);
		bean.setSubject(subject);
		bean.setSubjectId(subjectId);
		bean.setStudent(user);
		bean.setUserId(userId);
		bean.setDate(date);
		bean.setLectureTitle(lectureTitle);
		bean.setStatus(status);
		bean.setClasses(classes);
		bean.setClassId(classId);
		bean.setSubjectName(subjectName);
		bean.setClassName(className);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		AttendenceDTO bean = (AttendenceDTO)bDto;
		
		id = bean.getId();
		subject = bean.getSubject();
		subjectId = bean.getSubjectId();
		user = bean.getStudent();
		userId = bean.getUserId();
		date = bean.getDate();
		status = bean.getStatus();
		lectureTitle = bean.getLectureTitle();
		classes = bean.getClasses();
		classId = bean.getClassId();
		subjectName = bean.getSubjectName();
		className = bean.getClassName();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
		
		
	}

}
