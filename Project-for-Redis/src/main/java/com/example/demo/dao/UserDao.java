package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "USER"; //key-in which objects are being put.

    public User save(User user) {
        redisTemplate.opsForHash().put(KEY, user.getUserId(), user); //main-key, key, value
        return user;
    }

    public User get(String userId) {
        return (User) redisTemplate.opsForHash().get(KEY, userId);
    }

    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(KEY);
    }


    public void delete(String userId) {
        redisTemplate.opsForHash().delete(KEY, userId);
    }

    public User update(String userId) {
        redisTemplate.opsForHash().put(KEY, userId, "updated_value");
        return get(userId);
    }

}
