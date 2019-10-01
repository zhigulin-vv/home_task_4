package com.home_task_4.entities;

import javax.persistence.*;

@Entity
@Table(name = "home_task_4")

public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String user_name;


        public User() {}

        public User(String name, Integer id) {
            this.setName(user_name);
            this.setid(id);
        }

        // getters and setters for name and email
        public void setName(String name)
        {this.user_name = name;}

        public void setid(Integer id)
        {this.id = id;}

        public String getName()
        {return this.user_name;}

        public Integer getid()
        {return this.id;}


}
