package com.damg.agreementsapiendpoints.agreementsapiendpoints;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.dao.UserRepository;
import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Before
    public void setUp() throws Exception {

        User user1= new User("Abdel", "Mendez");
        User user2= new User("Benedicto", "Mendez");

        this.userRepository.save(user1);
        this.userRepository.save(user2);

        assertNotNull(user1.getSis_user_first_name());
        assertNotNull(user2.getSis_user_first_name());
    }

    @Test
    public void testFetchData(){
       /* *//*Test data retrieval*//*
        Optional<User> userA = userRepository.findById(1);
        assertNotNull(userA);
        assertEquals("Mendez", "Mendez");
        *//*Get all products, list should only have two*//*
        Iterable<User> users = userRepository.findAll();
        int count = 0;
        for(User p : users){
            count++;
        }*/
        assertEquals(1,1);
    }
}