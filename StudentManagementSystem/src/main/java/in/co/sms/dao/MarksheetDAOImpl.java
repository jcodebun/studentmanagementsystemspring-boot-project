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

import in.co.sms.dto.MarksheetDTO;

@Repository
public class MarksheetDAOImpl implements MarksheetDAOInt {

	private static Logger log = Logger.getLogger(MarksheetDAOImpl.class.getName());
	@Autowired
	private EntityManager entityManager;
	@Override
	public long add(MarksheetDTO dto) {
		log.info("MarksheetDAOImpl start method started");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long)session.save(dto);
		log.info("MarksheetDAOImpl Add method ends");
		return pk;
	}

	@Override
	public void delete(MarksheetDTO dto) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Query<MarksheetDTO> query = session.createSQLQuery("delete from s_classes where id = "+dto.getId()+"");
		query.executeUpdate();
	//	entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
	}

	@Override
	public MarksheetDTO findBypk(long pk) {
		log.info("MarksheetDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		MarksheetDTO dto = (MarksheetDTO) session.get(MarksheetDTO.class, pk);
		log.info("MarksheetDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public MarksheetDTO findByClassName(String className) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MarksheetDTO.class);
		criteria.add(Restrictions.eq("className", className));
		MarksheetDTO dto = (MarksheetDTO) criteria.uniqueResult();
		return dto;
	}

	@Override
	public void update(MarksheetDTO dto) {
		// TODO Auto-generated method stub
		log.info("MarksheetDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("MarksheetDAOImpl update method End");
	}

	@Override
	public List<MarksheetDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<MarksheetDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("MarksheetDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<MarksheetDTO> query = session.createQuery("from MarksheetDTO", MarksheetDTO.class);
		List<MarksheetDTO> list = query.getResultList();
		log.info("MarksheetDAOImpl List method End");
		return list;
	}

	@Override
	public List<MarksheetDTO> search(MarksheetDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<MarksheetDTO> search(MarksheetDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("MarksheetDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MarksheetDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getRollNo()!= null && dto.getRollNo().length() > 0) {
				criteria.add(Restrictions.like("rollNo", dto.getRollNo() + "%"));
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("MarksheetDAOImpl Search method End");
		return criteria.list();
	}

}
