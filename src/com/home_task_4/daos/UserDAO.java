package com.home_task_4.daos;

import com.home_task_4.entities.EmailsEntity;
import com.home_task_4.entities.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {

    public List<UsersEntity> RertiveAll() {
        List<UsersEntity> users = (List<UsersEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From UsersEntity ").list();
        return users;
    }

    public List<EmailsEntity> RertiveUserEmails(Integer id) {
        List<EmailsEntity> emails = (List<EmailsEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From EmailsEntity where user_id = :id").setParameter("id", id).list();
        return emails;
    }

    public void AddUserEmail(UsersEntity user, EmailsEntity email)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        session.save(email);
        tx1.commit();
        session.close();
    }


}
