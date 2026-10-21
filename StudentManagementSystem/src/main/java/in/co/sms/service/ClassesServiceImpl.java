package in.co.sms.service;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.sms.dao.ClassesDAOInt;
import in.co.sms.dto.ClassesDTO;
import in.co.sms.exception.DuplicateRecordException;

@Service
public class ClassesServiceImpl implements ClassesServiceInt {
	private static Logger log = Logger.getLogger(ClassesServiceImpl.class.getName());
	@Autowired
	private ClassesDAOInt dao;

	@Override
	@Transactional
	public long add(ClassesDTO dto) throws DuplicateRecordException {
		log.info("ClassesServiceImpl Add method start");
		ClassesDTO existdto = dao.findByClassName(dto.getClassName());
		if (existdto != null)
			throw new DuplicateRecordException("Class name Already Exist");
		long pk = dao.add(dto);
		log.info("ClassesServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(ClassesDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Override
	public ClassesDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("ClassesServiceImpl findBypk method start");
		ClassesDTO dto = dao.findBypk(pk);
		log.info("ClassesServiceImpl findBypk method end");
		return dto;
	}

	@Override
	public ClassesDTO findByClassName(String className) {
		// TODO Auto-generated method stub
		ClassesDTO dto=dao.findByClassName(className);
		return dto;
	}

	@Override
	@Transactional
	public void update(ClassesDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
			dao.update(dto);
	}

	@Override
	public List<ClassesDTO> list() {
		// TODO Auto-generated method stub
		log.info("ClassesServiceImpl list method start");
		List<ClassesDTO> list = dao.list();
		log.info("ClassesServiceImpl list method end");
		return list;
	}

	@Override
	public List<ClassesDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("ClassesServiceImpl list method start");
		List<ClassesDTO> list = dao.list(pageNo, pageSize);
		log.info("ClassesServiceImpl list method end");
		return list;
	}

	@Override
	public List<ClassesDTO> search(ClassesDTO dto) {
		// TODO Auto-generated method stub
		log.info("ClassesServiceImpl search method start");
		List<ClassesDTO> list = dao.search(dto);
		log.info("ClassesServiceImpl search method end");
		return list;
	}

	@Override
	public List<ClassesDTO> search(ClassesDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("ClassesServiceImpl search method start");
		List<ClassesDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("ClassesServiceImpl search method end");
		return list;
	}

	
}
