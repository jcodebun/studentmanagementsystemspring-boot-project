package in.co.sms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "s_attendence")
@Setter
@Getter
public class AttendenceDTO extends BaseDTO{

	@ManyToOne
	@JoinColumn(name = "user")
	private UserDTO student;
	
	@Column(name = "user_id")
	private Long userId;
	
	@ManyToOne
	@JoinColumn(name = "subject")
	private SubjectDTO subject;
	
	@Column(name = "subject_id")
	private Long subjectId;
	
	@Column(name = "date",length = 255)
	private String date;
	
	@Column(name = "lecture_title",length = 255)
	private String lectureTitle;
	
	@Column(name = "status",length = 255)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "classes")
	private ClassesDTO classes;
	
	@Column(name = "class_id")
	private Long classId;
	@Column(name = "subject_name")
	private String subjectName;
	
	@Column(name = "class_name")
	private String className;
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
