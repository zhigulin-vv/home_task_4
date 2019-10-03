package com.home_task_4.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "emails", schema = "db1", catalog = "")
public class EmailsEntity {
    private String email;
    private Integer id;
    private Integer user_id;

    @Basic
    @Column(name = "email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @Basic
    @Column(name = "user_id", nullable = true, length = 100)
    public Integer getUser_Id() {
        return user_id;
    }
    public void setUser_Id(Integer user_id) {
        this.user_id = user_id;
    }


    @Id
    @Column(name = "id", nullable = true)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailsEntity that = (EmailsEntity) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, id);
    }
}
