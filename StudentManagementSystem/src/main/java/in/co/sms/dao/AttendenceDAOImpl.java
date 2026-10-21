package in.co.sms.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.co.sms.dto.AttendenceDTO;



@Repository
public class AttendenceDAOImpl implements AttendenceDAOInt {

	private static Logger log = Logger.getLogger(AttendenceDAOImpl.class.getName());
	@Autowired
	private EntityManager entityManager;
	@Override
	public long add(AttendenceDTO dto) {
		log.info("AttendenceDAOImpl start method started");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long)session.save(dto);
		log.info("AttendenceDAOImpl Add method ends");
		return pk;
	}

	@Override
	public void delete(AttendenceDTO dto) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Query<AttendenceDTO> query = session.createSQLQuery("delete from s_attendence where id = "+dto.getId()+"");
		query.executeUpdate();
	//	entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
	}

	@Override
	public AttendenceDTO findBypk(long pk) {
		log.info("AttendenceDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		AttendenceDTO dto = (AttendenceDTO) session.get(AttendenceDTO.class, pk);
		log.info("AttendenceDAOImpl FindByPk method End");
		return dto;
	}



	@Override
	public void update(AttendenceDTO dto) {
		// TODO Auto-generated method stub
		log.info("AttendenceDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("AttendenceDAOImpl update method End");
	}

	@Override
	public List<AttendenceDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<AttendenceDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("AttendenceDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<AttendenceDTO> query = session.createQuery("from AttendenceDTO", AttendenceDTO.class);
		List<AttendenceDTO> list = query.getResultList();
		log.info("AttendenceDAOImpl List method End");
		return list;
	}

	@Override
	public List<AttendenceDTO> search(AttendenceDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<AttendenceDTO> search(AttendenceDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("AttendenceDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AttendenceDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}	
			
			if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
				
				criteria.add(Restrictions.like("subjectName", dto.getSubjectName() + "%"));
			}
			if (dto.getClassName() != null && dto.getClassName().length() > 0) {
				System.out.println("dt----"+dto.getSubjectName());
				criteria.add(Restrictions.like("className", dto.getClassName() + "%"));
			}
			
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		
		log.info("AttendenceDAOImpl Search method End");
		return criteria.list();
	}
	
	@Override
	public AttendenceDTO findByDateAndStudentId(String date, Long studentId) {
		
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AttendenceDTO.class);
		Criterion c1 = Restrictions.eq("date", date);
	    Criterion c2 = Restrictions.eq("userId", studentId);
	    Criterion c3 = Restrictions.and(c1, c2);
	    criteria.add(c3);
		//criteria.add(Restrictions.disjunction().add(Restrictions.or(Restrictions.eq("taxiName", taxiName)).add(Restrictions.eq("driverId", driverId))));
	    AttendenceDTO dto = (AttendenceDTO) criteria.uniqueResult();
		return dto;
	}
	@Override
	public AttendenceDTO findBySubjectIdAndStudentId(Long subjectId, Long studentId) {
		
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AttendenceDTO.class);
		Criterion c1 = Restrictions.eq("subjectId", subjectId);
	    Criterion c2 = Restrictions.eq("userId", studentId);
	    Criterion c3 = Restrictions.and(c1, c2);
	    criteria.add(c3);
		//criteria.add(Restrictions.disjunction().add(Restrictions.or(Restrictions.eq("taxiName", taxiName)).add(Restrictions.eq("driverId", driverId))));
	    AttendenceDTO dto = (AttendenceDTO) criteria.uniqueResult();
		return dto;
	}
	
	@Override
	@Transactional
	public void markAttendance(AttendenceDTO dto) {
		// TODO Auto-generated method stub
		log.info("AttendanceDAOImpl markAttendance method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<AttendenceDTO> query = session.createQuery("UPDATE AttendenceDTO u SET u.status =:status where u.id =:userid ");
		query.setParameter("status", dto.getStatus());
		query.setParameter("userid", dto.getId());
		int i = query.executeUpdate();
		log.info("AttendanceDAOImpl markAttendance method Ends");
	}

}
