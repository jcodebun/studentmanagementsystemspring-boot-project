package in.co.sms.dao;

import java.util.List;

import in.co.sms.dto.FeeDTO;

public interface FeeDAOInt {
	public long add(FeeDTO dto);

	public void delete(FeeDTO dto);

	public FeeDTO findBypk(long pk);

	public void update(FeeDTO dto);

	public List<FeeDTO> list();

	public List<FeeDTO> list(int pageNo, int pageSize);

	public List<FeeDTO> search(FeeDTO dto);

	public List<FeeDTO> search(FeeDTO dto, int pageNo, int pageSize);

	

}
