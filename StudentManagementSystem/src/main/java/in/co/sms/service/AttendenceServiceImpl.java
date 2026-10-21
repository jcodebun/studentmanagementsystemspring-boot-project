package in.co.sms.service;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.sms.dao.AttendenceDAOInt;
import in.co.sms.dao.ClassesDAOInt;
import in.co.sms.dto.AttendenceDTO;
import in.co.sms.exception.DuplicateRecordException;


@Service
public class AttendenceServiceImpl implements AttendenceServiceInt {
	private static Logger log = Logger.getLogger(AttendenceServiceImpl.class.getName());
	@Autowired
	private AttendenceDAOInt dao;

	@Override
	@Transactional
	public long add(AttendenceDTO dto) throws DuplicateRecordException {
		log.info("AttendenceServiceImpl Add method start");
		AttendenceDTO existDTO = dao.findBySubjectIdAndStudentId(dto.getSubjectId(), dto.getUserId());
		if (existDTO != null)
			throw new DuplicateRecordException("Subject already added for this student");
		long pk = dao.add(dto);
		log.info("AttendenceServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(AttendenceDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Override
	public AttendenceDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("AttendenceServiceImpl findBypk method start");
		AttendenceDTO dto = dao.findBypk(pk);
		log.info("AttendenceServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(AttendenceDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		dao.update(dto);
	}

	@Override
	public List<AttendenceDTO> list() {
		// TODO Auto-generated method stub
		log.info("AttendenceServiceImpl list method start");
		List<AttendenceDTO> list = dao.list();
		log.info("AttendenceServiceImpl list method end");
		return list;
	}

	@Override
	public List<AttendenceDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("AttendenceServiceImpl list method start");
		List<AttendenceDTO> list = dao.list(pageNo, pageSize);
		log.info("AttendenceServiceImpl list method end");
		return list;
	}

	@Override
	public List<AttendenceDTO> search(AttendenceDTO dto) {
		// TODO Auto-generated method stub
		log.info("AttendenceServiceImpl search method start");
		List<AttendenceDTO> list = dao.search(dto);
		log.info("AttendenceServiceImpl search method end");
		return list;
	}

	@Override
	public List<AttendenceDTO> search(AttendenceDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("AttendenceServiceImpl search method start");
		List<AttendenceDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("AttendenceServiceImpl search method end");
		return list;
	}
	
	@Override
	public void markAttendance(AttendenceDTO dto) {
		// TODO Auto-generated method stub
		log.info("AttendenceServiceImpl markAttendance method start");
		dao.markAttendance(dto);
		log.info("AttendenceServiceImpl markAttendance method end");
	}

}
