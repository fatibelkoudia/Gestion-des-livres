package com.tima.tp1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tima.tp1.model.Livre;
import com.tima.tp1.utils.HibernateUtil;

public class LivreDao implements IGenericDao<Livre> {

	@Override
	public Livre findOne(Long id) {
		Transaction transaction = null;
		Livre livre = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			livre = session.get(Livre.class, id);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return livre;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livre> findAll() {
		Transaction transaction = null;
        List < Livre > list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            list = session.createQuery("from Livre").getResultList();
            transaction.commit();
        } catch (Exception e) {
        	e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return list;
	}

	@Override
	public void create(Livre entity) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
        	e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}

	@Override
	public void update(Livre entity) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
        	e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}

	@Override
	public void delete(Long id) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Livre livre = session.get(Livre.class, id);
            if (livre != null) {
                session.delete(livre);
                System.out.println("Livre: " + livre + " a été supprimé");
            }
            transaction.commit();
        } catch (Exception e) {
        	e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
	}

}
