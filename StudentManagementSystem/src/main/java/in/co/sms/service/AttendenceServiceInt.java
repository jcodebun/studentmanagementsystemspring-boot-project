package in.co.sms.service;

import java.util.List;

import in.co.sms.dto.AttendenceDTO;
import in.co.sms.exception.DuplicateRecordException;

public interface AttendenceServiceInt {

	public long add(AttendenceDTO dto) throws DuplicateRecordException;

	public void delete(AttendenceDTO dto);	

	public AttendenceDTO findBypk(long pk);

	

	public void update(AttendenceDTO dto) throws DuplicateRecordException;

	public List<AttendenceDTO> list();

	public List<AttendenceDTO> list(int pageNo, int pageSize);

	public List<AttendenceDTO> search(AttendenceDTO dto);

	public List<AttendenceDTO> search(AttendenceDTO dto, int pageNo, int pageSize);

	void markAttendance(AttendenceDTO dto);

}
