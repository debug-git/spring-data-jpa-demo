package com.example.jpademo.repository;

import com.example.jpademo.entity.User;
import org.hibernate.validator.constraints.EAN;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(Integer userId);

    /**
     * 使用HQL查询
     * @param userId
     * @param userName
     * @return
     */
    @Query("select u from User u where u.userId= :userId and u.userName like %:userName%")
    List<User> selectByCondity(@Param("userId") Integer userId, @Param("userName") String userName);

    /**
     * 使用原生SQL查询
     * @param userId
     * @param userName
     * @return
     */
    @Query(value = "select * from user u where u.userId= :userId and u.userName like  %:userName%", nativeQuery = true)
    List<User> selectByNativeSql(@Param("userId") Integer userId, @Param("userName") String userName);


}
