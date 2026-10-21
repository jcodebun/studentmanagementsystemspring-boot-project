package in.co.sms.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "s_fee")
@Setter
@Getter
public class FeeDTO extends BaseDTO{

	@Column(name = "month", length = 255)
	private String month;
	@Column(name = "amount", length = 255)
	private BigDecimal amount;
	@Column(name = "totalFee", length = 255)
	private BigDecimal totalFee;
	@Column(name = "paidFee", length = 255)
	private BigDecimal paidFee;
	@Column(name = "balanceFee", length = 255)
	private BigDecimal balanceFee;
	@Column(name = "date", length = 255)
	private String date;
	@Column(name = "userId")
	private Long userId;
	
	
	@ManyToOne
	@JoinColumn(name = "user", nullable = false)
	private UserDTO user;
	
	
	
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
