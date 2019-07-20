package com.example.jpademo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
//    @GenericGenerator(name = "idGenerator", strategy = "native")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "userName", unique = false, nullable = true, length = 255)
    private String userName;

    @Column(name = "password", unique = false, nullable = true, length = 255)
    private String password;

    @Column(name = "phone", unique = false, nullable = true, length = 255, insertable = false)
    private String phone;

    @Column(name = "modifyTime", unique = false, nullable = true)
    private Date modifyTime;

    @Column(name = "createTime", unique = false, nullable = true)
    private Date createTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userRole", joinColumns = @JoinColumn(name = "userId"),
    inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> rolesList;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", modifyTime=" + modifyTime +
                ", createTime=" + createTime +
                ", rolesList=" + rolesList +
                '}';
    }
}

