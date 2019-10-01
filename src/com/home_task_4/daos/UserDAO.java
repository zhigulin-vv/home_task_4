package com.home_task_4.daos;

import javax.persistence.*;
import com.home_task_4.entities.*;

public class UserDAO {

    private static EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public void persist(String name, Integer id) {
        beginTransaction();
        User user = new User(name, id);
        entityManager.persist(user);
        commitTransaction();
    }

    public static User find(int id) {
        return entityManager.find(User.class, id);
    }

    public void update(String name, Integer id) {
        beginTransaction();
        User user = entityManager.find(User.class, id);
        user.setName(name);
        user.setid(id);
        entityManager.merge(user);
        commitTransaction();
    }

    public void remove(int id) {
        beginTransaction();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        commitTransaction();
    }

    private void beginTransaction() {
        try {
            entityTransaction.begin();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void commitTransaction() {
        try {
            entityTransaction.commit();
            entityManager.close();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

}
