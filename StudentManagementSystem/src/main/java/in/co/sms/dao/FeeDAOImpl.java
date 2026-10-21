package in.co.sms.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sms.dto.FeeDTO;

@Repository
public class FeeDAOImpl implements FeeDAOInt {

	private static Logger log = Logger.getLogger(FeeDAOImpl.class.getName());
	@Autowired
	private EntityManager entityManager;
	@Override
	public long add(FeeDTO dto) {
		log.info("FeeDAOImpl start method started");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long)session.save(dto);
		log.info("FeeDAOImpl Add method ends");
		return pk;
	}

	@Override
	public void delete(FeeDTO dto) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Query<FeeDTO> query = session.createSQLQuery("delete from s_fee where id = "+dto.getId()+"");
		query.executeUpdate();
	//	entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
	}

	@Override
	public FeeDTO findBypk(long pk) {
		log.info("FeeDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		FeeDTO dto = (FeeDTO) session.get(FeeDTO.class, pk);
		log.info("FeeDAOImpl FindByPk method End");
		return dto;
	}



	@Override
	public void update(FeeDTO dto) {
		// TODO Auto-generated method stub
		log.info("FeeDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("FeeDAOImpl update method End");
	}

	@Override
	public List<FeeDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<FeeDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("FeeDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<FeeDTO> query = session.createQuery("from FeeDTO", FeeDTO.class);
		List<FeeDTO> list = query.getResultList();
		log.info("FeeDAOImpl List method End");
		return list;
	}

	@Override
	public List<FeeDTO> search(FeeDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<FeeDTO> search(FeeDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("FeeDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FeeDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("FeeDAOImpl Search method End");
		return criteria.list();
	}

}
