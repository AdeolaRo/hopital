package org.example.hopital.dao;

import org.example.hopital.model.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import org.example.hopital.util.HibernateUtil;

public class PatientDAO {

        public void create(Patient patient) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.save(patient);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public List<Patient> findAll() {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.createQuery("FROM Patient", Patient.class).list();
            }
        }

        public Patient find(Long id) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.get(Patient.class, id);
            }
        }


    }




