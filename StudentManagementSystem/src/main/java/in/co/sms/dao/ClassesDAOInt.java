package in.co.sms.dao;

import java.util.List;

import in.co.sms.dto.ClassesDTO;

public interface ClassesDAOInt {
	public long add(ClassesDTO dto);

	public void delete(ClassesDTO dto);

	public ClassesDTO findBypk(long pk);

	public ClassesDTO findByClassName(String login);

	public void update(ClassesDTO dto);

	public List<ClassesDTO> list();

	public List<ClassesDTO> list(int pageNo, int pageSize);

	public List<ClassesDTO> search(ClassesDTO dto);

	public List<ClassesDTO> search(ClassesDTO dto, int pageNo, int pageSize);

	

}
