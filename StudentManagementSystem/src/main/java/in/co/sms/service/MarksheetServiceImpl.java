package in.co.sms.service;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.sms.dao.ClassesDAOInt;
import in.co.sms.dao.MarksheetDAOInt;
import in.co.sms.dto.MarksheetDTO;
import in.co.sms.exception.DuplicateRecordException;

@Service
public class MarksheetServiceImpl implements MarksheetServiceInt {
	private static Logger log = Logger.getLogger(MarksheetServiceImpl.class.getName());
	@Autowired
	private MarksheetDAOInt dao;

	@Override
	@Transactional
	public long add(MarksheetDTO dto) throws DuplicateRecordException {
		log.info("MarksheetServiceImpl Add method start");
		
		long pk = dao.add(dto);
		log.info("MarksheetServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(MarksheetDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Override
	public MarksheetDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("MarksheetServiceImpl findBypk method start");
		MarksheetDTO dto = dao.findBypk(pk);
		log.info("MarksheetServiceImpl findBypk method end");
		return dto;
	}

	@Override
	public MarksheetDTO findByClassName(String className) {
		// TODO Auto-generated method stub
		MarksheetDTO dto=dao.findByClassName(className);
		return dto;
	}

	@Override
	@Transactional
	public void update(MarksheetDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
			dao.update(dto);
	}

	@Override
	public List<MarksheetDTO> list() {
		// TODO Auto-generated method stub
		log.info("MarksheetServiceImpl list method start");
		List<MarksheetDTO> list = dao.list();
		log.info("MarksheetServiceImpl list method end");
		return list;
	}

	@Override
	public List<MarksheetDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("MarksheetServiceImpl list method start");
		List<MarksheetDTO> list = dao.list(pageNo, pageSize);
		log.info("MarksheetServiceImpl list method end");
		return list;
	}

	@Override
	public List<MarksheetDTO> search(MarksheetDTO dto) {
		// TODO Auto-generated method stub
		log.info("MarksheetServiceImpl search method start");
		List<MarksheetDTO> list = dao.search(dto);
		log.info("MarksheetServiceImpl search method end");
		return list;
	}

	@Override
	public List<MarksheetDTO> search(MarksheetDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("MarksheetServiceImpl search method start");
		List<MarksheetDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("MarksheetServiceImpl search method end");
		return list;
	}

	
}
