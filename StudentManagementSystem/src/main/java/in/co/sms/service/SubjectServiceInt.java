package in.co.sms.service;

import java.util.List;

import in.co.sms.dto.SubjectDTO;
import in.co.sms.exception.DuplicateRecordException;

public interface SubjectServiceInt {

	public long add(SubjectDTO dto) throws DuplicateRecordException;

	public void delete(SubjectDTO dto);	

	public SubjectDTO findBypk(long pk);

	public SubjectDTO findBySubjectName(String subName);

	public void update(SubjectDTO dto) throws DuplicateRecordException;

	public List<SubjectDTO> list();

	public List<SubjectDTO> list(int pageNo, int pageSize);

	public List<SubjectDTO> search(SubjectDTO dto);

	public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize);

}
