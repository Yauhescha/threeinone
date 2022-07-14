package com.hescha.threeinone.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class MessageFromUser {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String name;

    private String email;

    @Column(length = 1000)
    private String message;

    private boolean answered;

    @Override
    public String toString() {
        return "MessageFromUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", answered=" + answered +
                '}';
    }
}
