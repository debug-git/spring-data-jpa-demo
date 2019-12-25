package com.example.jpademo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author mybatis-plus
 * @since 2019-06-05
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity
@Table(name = "role")
@Proxy(lazy = false)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Date createTime;

    private Date updateTime;

    @ManyToMany(mappedBy = "rolesList", fetch = FetchType.EAGER)
    private List<User> users;

//    @Override
//    public String toString() {
//        return "Role{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", createTime=" + createTime +
//                ", updateTime=" + updateTime +
//                ", users=" + users +
//                '}';
//    }
}
