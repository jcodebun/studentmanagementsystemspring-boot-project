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

import in.co.sms.dto.ClassesDTO;

@Repository
public class ClassesDAOImpl implements ClassesDAOInt {

	private static Logger log = Logger.getLogger(ClassesDAOImpl.class.getName());
	@Autowired
	private EntityManager entityManager;
	@Override
	public long add(ClassesDTO dto) {
		log.info("ClassesDAOImpl start method started");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long)session.save(dto);
		log.info("ClassesDAOImpl Add method ends");
		return pk;
	}

	@Override
	public void delete(ClassesDTO dto) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Query<ClassesDTO> query = session.createSQLQuery("delete from s_classes where id = "+dto.getId()+"");
		query.executeUpdate();
	//	entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
	}

	@Override
	public ClassesDTO findBypk(long pk) {
		log.info("ClassesDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		ClassesDTO dto = (ClassesDTO) session.get(ClassesDTO.class, pk);
		log.info("ClassesDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public ClassesDTO findByClassName(String className) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ClassesDTO.class);
		criteria.add(Restrictions.eq("className", className));
		ClassesDTO dto = (ClassesDTO) criteria.uniqueResult();
		return dto;
	}

	@Override
	public void update(ClassesDTO dto) {
		// TODO Auto-generated method stub
		log.info("ClassesDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("ClassesDAOImpl update method End");
	}

	@Override
	public List<ClassesDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<ClassesDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("ClassesDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<ClassesDTO> query = session.createQuery("from ClassesDTO", ClassesDTO.class);
		List<ClassesDTO> list = query.getResultList();
		log.info("ClassesDAOImpl List method End");
		return list;
	}

	@Override
	public List<ClassesDTO> search(ClassesDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<ClassesDTO> search(ClassesDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("ClassesDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ClassesDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getClassName() != null && dto.getClassName().length() > 0) {
				criteria.add(Restrictions.like("className", dto.getClassName() + "%"));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("ClassesDAOImpl Search method End");
		return criteria.list();
	}

}
