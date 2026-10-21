package in.co.sms.dao;

import java.util.List;

import in.co.sms.dto.SubjectDTO;

public interface SubjectDAOInt {
	public long add(SubjectDTO dto);

	public void delete(SubjectDTO dto);

	public SubjectDTO findBypk(long pk);

	public SubjectDTO findBySubjectName(String subName);

	public void update(SubjectDTO dto);

	public List<SubjectDTO> list();

	public List<SubjectDTO> list(int pageNo, int pageSize);

	public List<SubjectDTO> search(SubjectDTO dto);

	public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize);

	

}
