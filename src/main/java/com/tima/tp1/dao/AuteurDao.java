package com.tima.tp1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tima.tp1.model.Auteur;
import com.tima.tp1.utils.HibernateUtil;

public class AuteurDao implements IGenericDao<Auteur> {
	
	@Override
	public Auteur findOne(Long id) {
		Transaction transaction = null;
		Auteur auteur = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			auteur = session.get(Auteur.class, id);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			
		}
		return auteur;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Auteur> findAll() {
		Transaction transaction = null;
        List <Auteur> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            list = session.createQuery("from Auteur").getResultList();
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
	public void create(Auteur entity) {
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
	public void update(Auteur entity) {
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
            Auteur auteur = session.get(Auteur.class, id);
            if (auteur != null) {
                session.delete(auteur);
                System.out.println("Auteur: " + auteur + " a été supprimé");
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
