package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import config.HibernateUtil;
import data.model.Building;

@Repository
public class BuildingDao {
	HibernateUtil hibernateUtil;
	
	public BuildingDao(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public void addBuilding(Building building) {
		Session session = hibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(building);

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public Building getBuilding(int idBuilding) {
		Session session = hibernateUtil.openSession();
		try {
			Building building = (Building) session.get(Building.class, idBuilding);
			return building;
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

	public void updateBuilding(Building building) {
		Session session = hibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(building);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
}
