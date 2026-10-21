package in.co.sms.service;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.sms.dao.ClassesDAOInt;
import in.co.sms.dao.FeeDAOInt;
import in.co.sms.dto.FeeDTO;
import in.co.sms.exception.DuplicateRecordException;

@Service
public class FeeServiceImpl implements FeeServiceInt {
	private static Logger log = Logger.getLogger(FeeServiceImpl.class.getName());
	@Autowired
	private FeeDAOInt dao;

	@Override
	@Transactional
	public long add(FeeDTO dto) throws DuplicateRecordException {
		log.info("FeeServiceImpl Add method start");
		long pk = dao.add(dto);
		log.info("FeeServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(FeeDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Override
	public FeeDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("FeeServiceImpl findBypk method start");
		FeeDTO dto = dao.findBypk(pk);
		log.info("FeeServiceImpl findBypk method end");
		return dto;
	}

	
	@Override
	@Transactional
	public void update(FeeDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
			dao.update(dto);
	}

	@Override
	public List<FeeDTO> list() {
		// TODO Auto-generated method stub
		log.info("FeeServiceImpl list method start");
		List<FeeDTO> list = dao.list();
		log.info("FeeServiceImpl list method end");
		return list;
	}

	@Override
	public List<FeeDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("FeeServiceImpl list method start");
		List<FeeDTO> list = dao.list(pageNo, pageSize);
		log.info("FeeServiceImpl list method end");
		return list;
	}

	@Override
	public List<FeeDTO> search(FeeDTO dto) {
		// TODO Auto-generated method stub
		log.info("FeeServiceImpl search method start");
		List<FeeDTO> list = dao.search(dto);
		log.info("FeeServiceImpl search method end");
		return list;
	}

	@Override
	public List<FeeDTO> search(FeeDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("FeeServiceImpl search method start");
		List<FeeDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("FeeServiceImpl search method end");
		return list;
	}

	
}
