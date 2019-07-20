package com.example.jpademo.repository;

import com.example.jpademo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * 测试多对多关联
     * （1）注意:User和Role的list对象至少有一个要改为延迟加载，否则会报错。报错原因：
     * Hibernate使用sessionFactory来管理session，每进行一次数据库操作时都会新建一个session对象，
     * 当操作完成后，hibernate就会在dao层立即关闭该session。
     * 所以操作类中另一个类的具体属性时，因为session已经关闭，就会报错。
     * （2）双方toString方法容易发生循环引用导致堆栈溢出，需注意
     */
    @Test
    public void testFind(){
        User user = userRepository.findByUserId(3);
        System.out.println(user);
        Optional<User> all = userRepository.findOne(Example.of(new User().setUserId(2)));
        System.out.println(all.get());
    }

    @Test
    public void testQuery(){
        //使用HQL查询
        List<User> users = userRepository.selectByCondity(8, "1");
        System.out.println("使用HQL查询结果");
        users.forEach( user -> System.out.println(user));

        //使用原生SQL查询
        List<User> users2 = userRepository.selectByNativeSql(8, "1");
        System.out.println("使用SQL查询结果");
        users2.forEach( user -> System.out.println(user));


    }

    /**
     * save方法执行的是insert和update操作的混合体。
     * 具体表现为该记录存在就更新，不存在就插入。（可能是根据主键来确定是否存在）
     */
    public void testSave(){
        //使用原生SQL查询
        List<User> users2 = userRepository.selectByNativeSql(8, "1");
        System.out.println("使用SQL查询结果");
        users2.forEach( user -> System.out.println(user));

        User user = users2.get(0);
        user.setUserId(null);
        user.setCreateTime(new Date()).setModifyTime(new Date()).setPhone("1111111111111");
        //save即代表插入记录
        User save = userRepository.save(user);
        System.out.println(save);

        User save2 = userRepository.saveAndFlush(user);
        System.out.println(save2);
    }
}
