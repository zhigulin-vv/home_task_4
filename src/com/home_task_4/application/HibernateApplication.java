package com.home_task_4.application;


import com.home_task_4.daos.UserDAO;
import com.home_task_4.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class HibernateApplication {

    public static void main(String[] args)
    {

        EntityManager entityManager = Persistence
                .createEntityManagerFactory("user-unit")
                .createEntityManager();
        UserDAO userDao = new UserDAO(entityManager);

        Integer i = 1;

        User user = UserDAO.find(i);
        System.out.print("Name : " + user.getName() + " Email : " + user.getid());
    }

}
