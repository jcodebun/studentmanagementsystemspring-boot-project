package in.co.sms.service;

import java.util.List;

import in.co.sms.dto.ClassesDTO;
import in.co.sms.exception.DuplicateRecordException;

public interface ClassesServiceInt {

	public long add(ClassesDTO dto) throws DuplicateRecordException;

	public void delete(ClassesDTO dto);	

	public ClassesDTO findBypk(long pk);

	public ClassesDTO findByClassName(String login);

	public void update(ClassesDTO dto) throws DuplicateRecordException;

	public List<ClassesDTO> list();

	public List<ClassesDTO> list(int pageNo, int pageSize);

	public List<ClassesDTO> search(ClassesDTO dto);

	public List<ClassesDTO> search(ClassesDTO dto, int pageNo, int pageSize);

}
