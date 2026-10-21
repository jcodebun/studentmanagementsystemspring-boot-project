package in.co.sms.dao;

import java.util.List;

import in.co.sms.dto.AttendenceDTO;

public interface AttendenceDAOInt {
	public long add(AttendenceDTO dto);

	public void delete(AttendenceDTO dto);

	public AttendenceDTO findBypk(long pk);

	public void update(AttendenceDTO dto);

	public List<AttendenceDTO> list();

	public List<AttendenceDTO> list(int pageNo, int pageSize);

	public List<AttendenceDTO> search(AttendenceDTO dto);

	public List<AttendenceDTO> search(AttendenceDTO dto, int pageNo, int pageSize);

	AttendenceDTO findByDateAndStudentId(String date, Long studentId);

	AttendenceDTO findBySubjectIdAndStudentId(Long subjectId, Long studentId);

	void markAttendance(AttendenceDTO dto);

	

}
