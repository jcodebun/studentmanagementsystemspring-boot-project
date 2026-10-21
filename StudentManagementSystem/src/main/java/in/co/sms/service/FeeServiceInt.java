package in.co.sms.service;

import java.util.List;

import in.co.sms.dto.FeeDTO;
import in.co.sms.exception.DuplicateRecordException;

public interface FeeServiceInt {

	public long add(FeeDTO dto) throws DuplicateRecordException;

	public void delete(FeeDTO dto);	

	public FeeDTO findBypk(long pk);

	public void update(FeeDTO dto) throws DuplicateRecordException;

	public List<FeeDTO> list();

	public List<FeeDTO> list(int pageNo, int pageSize);

	public List<FeeDTO> search(FeeDTO dto);

	public List<FeeDTO> search(FeeDTO dto, int pageNo, int pageSize);

}
