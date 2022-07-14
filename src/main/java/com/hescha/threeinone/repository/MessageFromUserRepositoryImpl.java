package com.hescha.threeinone.repository;

import com.hescha.threeinone.model.MessageFromUser;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@AllArgsConstructor
public class MessageFromUserRepositoryImpl implements MessageFromUserRepository {

    private final SessionFactory sessionFactory;

    @Override
    public boolean create(MessageFromUser entity) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Transaction transaction = currentSession.getTransaction();
            transaction.begin();
            currentSession.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public MessageFromUser read(Long id) {
        MessageFromUser messageFromUser = sessionFactory.getCurrentSession().find(MessageFromUser.class, id);
        if (messageFromUser == null)
            throw new NoSuchElementException();
        return messageFromUser;
    }

    @Override
    public List<MessageFromUser> readAll() {
        String hql = "FROM MessageFromUser as tbl ORDER BY tbl.id";
        return (List<MessageFromUser>) sessionFactory.getCurrentSession().createQuery(hql).getResultList();
    }

    @Override
    public boolean update(MessageFromUser entity) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Transaction transaction = currentSession.getTransaction();
            transaction.begin();
            sessionFactory.getCurrentSession().update(entity);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.getTransaction();
        transaction.begin();
        sessionFactory.getCurrentSession().remove(read(id));
        transaction.commit();
    }

    @Override
    public boolean answer(Long id) {
        MessageFromUser old = read(id);
        old.setAnswered(true);
        return update(old);
    }
}
