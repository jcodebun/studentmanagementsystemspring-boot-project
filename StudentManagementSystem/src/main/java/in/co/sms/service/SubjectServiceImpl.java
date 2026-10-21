package in.co.sms.service;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.sms.dao.ClassesDAOInt;
import in.co.sms.dao.SubjectDAOInt;
import in.co.sms.dto.SubjectDTO;
import in.co.sms.exception.DuplicateRecordException;

@Service
public class SubjectServiceImpl implements SubjectServiceInt {
	private static Logger log = Logger.getLogger(SubjectServiceImpl.class.getName());
	@Autowired
	private SubjectDAOInt dao;

	@Override
	@Transactional
	public long add(SubjectDTO dto) throws DuplicateRecordException {
		log.info("SubjectServiceImpl Add method start");
		SubjectDTO existdto = dao.findBySubjectName(dto.getSubjectName());
		if (existdto != null)
			throw new DuplicateRecordException("Subject name Already Exist");
		long pk = dao.add(dto);
		log.info("SubjectServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(SubjectDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Override
	public SubjectDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("SubjectServiceImpl findBypk method start");
		SubjectDTO dto = dao.findBypk(pk);
		log.info("SubjectServiceImpl findBypk method end");
		return dto;
	}

	@Override
	public SubjectDTO findBySubjectName(String subName) {
		// TODO Auto-generated method stub
		SubjectDTO dto=dao.findBySubjectName(subName);
		return dto;
	}

	@Override
	@Transactional
	public void update(SubjectDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
			dao.update(dto);
	}

	@Override
	public List<SubjectDTO> list() {
		// TODO Auto-generated method stub
		log.info("SubjectServiceImpl list method start");
		List<SubjectDTO> list = dao.list();
		log.info("SubjectServiceImpl list method end");
		return list;
	}

	@Override
	public List<SubjectDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("SubjectServiceImpl list method start");
		List<SubjectDTO> list = dao.list(pageNo, pageSize);
		log.info("SubjectServiceImpl list method end");
		return list;
	}

	@Override
	public List<SubjectDTO> search(SubjectDTO dto) {
		// TODO Auto-generated method stub
		log.info("SubjectServiceImpl search method start");
		List<SubjectDTO> list = dao.search(dto);
		log.info("SubjectServiceImpl search method end");
		return list;
	}

	@Override
	public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("SubjectServiceImpl search method start");
		List<SubjectDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("SubjectServiceImpl search method end");
		return list;
	}

	
}
