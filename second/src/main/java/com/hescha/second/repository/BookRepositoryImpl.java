package com.hescha.second.repository;


import com.hescha.second.model.Book;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@AllArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Book create(Book entity) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Transaction transaction = currentSession.getTransaction();
            transaction.begin();
            Long id = (Long) currentSession.save(entity);
            transaction.commit();
            return read(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Book read(Long id) {
        Book Book = sessionFactory.getCurrentSession().find(Book.class, id);
        if (Book == null)
            throw new NoSuchElementException();
        return Book;
    }

    @Override
    public List<Book> readAll() {
        String hql = "FROM Book as tbl ORDER BY tbl.id";
        return (List<Book>) sessionFactory.getCurrentSession().createQuery(hql).getResultList();
    }

    @Override
    public Book update(Book entity) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Transaction transaction = currentSession.getTransaction();
            transaction.begin();
            sessionFactory.getCurrentSession().update(entity);
            transaction.commit();
            return entity;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.getTransaction();
        transaction.begin();
        sessionFactory.getCurrentSession().remove(read(id));
        transaction.commit();
    }
}
