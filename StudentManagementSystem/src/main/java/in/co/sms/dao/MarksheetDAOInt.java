package in.co.sms.dao;

import java.util.List;

import in.co.sms.dto.MarksheetDTO;

public interface MarksheetDAOInt {
	public long add(MarksheetDTO dto);

	public void delete(MarksheetDTO dto);

	public MarksheetDTO findBypk(long pk);

	public MarksheetDTO findByClassName(String login);

	public void update(MarksheetDTO dto);

	public List<MarksheetDTO> list();

	public List<MarksheetDTO> list(int pageNo, int pageSize);

	public List<MarksheetDTO> search(MarksheetDTO dto);

	public List<MarksheetDTO> search(MarksheetDTO dto, int pageNo, int pageSize);

	

}
