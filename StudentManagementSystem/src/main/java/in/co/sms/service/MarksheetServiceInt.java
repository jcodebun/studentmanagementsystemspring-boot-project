package in.co.sms.service;

import java.util.List;

import in.co.sms.dto.MarksheetDTO;
import in.co.sms.exception.DuplicateRecordException;

public interface MarksheetServiceInt {

	public long add(MarksheetDTO dto) throws DuplicateRecordException;

	public void delete(MarksheetDTO dto);	

	public MarksheetDTO findBypk(long pk);

	public MarksheetDTO findByClassName(String login);

	public void update(MarksheetDTO dto) throws DuplicateRecordException;

	public List<MarksheetDTO> list();

	public List<MarksheetDTO> list(int pageNo, int pageSize);

	public List<MarksheetDTO> search(MarksheetDTO dto);

	public List<MarksheetDTO> search(MarksheetDTO dto, int pageNo, int pageSize);

}
