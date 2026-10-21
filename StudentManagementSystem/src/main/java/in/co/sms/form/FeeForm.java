package in.co.sms.form;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import in.co.sms.dto.BaseDTO;
import in.co.sms.dto.FeeDTO;
import in.co.sms.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class FeeForm extends BaseForm {

	@NotEmpty(message = "Month is required")
	private String month;
	@NotNull(message = "Amount is required")
	private BigDecimal amount;
	@NotNull(message = "Total Fee is required")
	private BigDecimal totalFee;
	@NotNull(message = "Paid Fee is required")
	private BigDecimal paidFee;
	@NotNull(message = "Balance Fee is required")
	private BigDecimal balanceFee;
	@NotNull(message = "Date is required")
	private String date;
	
	private Long userId;
	
	private UserDTO userDTO;
	
	
	@Override
	public BaseDTO getDTO() {
		FeeDTO bean = new FeeDTO();
		bean.setId(id);
		bean.setMonth(month);
		bean.setAmount(amount);
		bean.setBalanceFee(balanceFee);
		bean.setDate(date);
		bean.setUserId(userId);
		bean.setTotalFee(totalFee);
		bean.setPaidFee(paidFee);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		bean.setUser(userDTO);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		FeeDTO bean = (FeeDTO)bDto;
		id = bean.getId();
		month = bean.getMonth();
		amount = bean.getAmount();
		totalFee = bean.getTotalFee();
		balanceFee = bean.getBalanceFee();
		paidFee = bean.getPaidFee();
		date = bean.getDate();
		userId = bean.getUserId();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
		userDTO = bean.getUser();
	}

}
