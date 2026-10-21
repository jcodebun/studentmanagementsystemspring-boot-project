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

import in.co.sms.dto.SubjectDTO;

@Repository
public class SubjectDAOImpl implements SubjectDAOInt {

	private static Logger log = Logger.getLogger(SubjectDAOImpl.class.getName());
	@Autowired
	private EntityManager entityManager;
	@Override
	public long add(SubjectDTO dto) {
		log.info("SubjectDAOImpl start method started");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long)session.save(dto);
		log.info("SubjectDAOImpl Add method ends");
		return pk;
	}

	@Override
	public void delete(SubjectDTO dto) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Query<SubjectDTO> query = session.createSQLQuery("delete from s_subject where id = "+dto.getId()+"");
		query.executeUpdate();
	//	entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
	}

	@Override
	public SubjectDTO findBypk(long pk) {
		log.info("SubjectDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		SubjectDTO dto = (SubjectDTO) session.get(SubjectDTO.class, pk);
		log.info("SubjectDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public SubjectDTO findBySubjectName(String subName) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(SubjectDTO.class);
		criteria.add(Restrictions.eq("subjectName", subName));
		SubjectDTO dto = (SubjectDTO) criteria.uniqueResult();
		return dto;
	}

	@Override
	public void update(SubjectDTO dto) {
		// TODO Auto-generated method stub
		log.info("SubjectDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("SubjectDAOImpl update method End");
	}

	@Override
	public List<SubjectDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<SubjectDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("SubjectDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<SubjectDTO> query = session.createQuery("from SubjectDTO", SubjectDTO.class);
		List<SubjectDTO> list = query.getResultList();
		log.info("SubjectDAOImpl List method End");
		return list;
	}

	@Override
	public List<SubjectDTO> search(SubjectDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("SubjectDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(SubjectDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
				criteria.add(Restrictions.like("subjectName", dto.getSubjectName() + "%"));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("SubjectDAOImpl Search method End");
		return criteria.list();
	}

}
