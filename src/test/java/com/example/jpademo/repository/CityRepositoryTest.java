package com.example.jpademo.repository;

import com.example.jpademo.entity.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryTest {
    @Autowired
    private CityRepository cityRepository;

    @Test
    public void test(){
        List<City> zone = cityRepository.findByZone("110102");
        System.out.println(zone);
    }
}
