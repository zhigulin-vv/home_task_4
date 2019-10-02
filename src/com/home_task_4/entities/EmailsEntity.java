package com.home_task_4.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "emails", schema = "db1", catalog = "")
public class EmailsEntity {
    private String email;
    private Integer id;

    @Basic
    @Column(name = "email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
