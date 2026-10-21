package in.co.sms.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "s_subject")
@Setter
@Getter
public class SubjectDTO extends BaseDTO{

	@Column(name = "subject_name")
	private String subjectName;
	@Column(name = "subject_description", length = 555)
	private String subjectDescription;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	private List<AttendenceDTO> listOfAttendence = new ArrayList<AttendenceDTO>();
	
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
