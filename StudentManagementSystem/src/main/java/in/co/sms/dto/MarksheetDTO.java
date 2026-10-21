package in.co.sms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "s_marksheet")
@Setter
@Getter
public class MarksheetDTO extends BaseDTO {

	@Column(name = "user_id")
	private Long userId;
	@ManyToOne()
	@JoinColumn(name = "user")
	private UserDTO user;
	@Column(name = "roll_no", length = 255)
	private String rollNo;
	@Column(name = "physics", length = 255)
	private Long physics;
	@Column(name = "chemistry", length = 255)
	private Long chemistry;
	@Column(name = "maths", length = 255)
	private Long maths;
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
