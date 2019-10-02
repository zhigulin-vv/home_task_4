package com.home_task_4.application;


import com.home_task_4.daos.UserDAO;
import com.home_task_4.entities.EmailsEntity;
import com.home_task_4.entities.UsersEntity;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class HibernateApplication {

    private final UserDAO userDAO;

    public HibernateApplication(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public static void main(String[] args)  throws Exception
    {

        UserDAO userDao = new UserDAO();

        Integer id = 1;
        String name = "tony@ya.org";

        //new HibernateApplication(userDao).insertEmail(id, name);
        new HibernateApplication(userDao).fetchData(1);

    }


    private void fetchData(Integer id) throws IOException
    {
        //UsersEntity user = userDAO.find(id);
        List<UsersEntity> users = userDAO.RertiveAll();

        StringBuilder b = new StringBuilder();

        for (Iterator<UsersEntity> iterator = users.iterator(); iterator.hasNext();)
            {
                UsersEntity list_users = (UsersEntity)iterator.next();
                b.append(list_users.getUserName() + " " + getUserEmails(list_users.getId()) + System.lineSeparator());
                //System.out.println(list_emails.getUserName());
            }

        System.out.print(b.toString());

    }

    private String getUserEmails(Integer Id)
    {
        List<EmailsEntity> emails = userDAO.RertiveUserEmails(Id);

        StringBuilder b = new StringBuilder();

        for (Iterator<EmailsEntity> iterator = emails.iterator(); iterator.hasNext();)
        {
            EmailsEntity list_emails = (EmailsEntity)iterator.next();
            b.append(list_emails.getEmail() + "\t");
            //System.out.println(list_emails.getUserName());
        }

        return b.toString();

    }


}
