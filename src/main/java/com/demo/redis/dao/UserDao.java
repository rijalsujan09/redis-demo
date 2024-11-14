package com.demo.redis.dao;

import com.demo.redis.models.User;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class UserDao {


    private final RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "USER1";


    // SAVE USER
    public User saveUser(User user) {
        redisTemplate.opsForHash().put(KEY, user.getUserId(), user);
        return user;
    }

    // GET USER
    public User getUser(String userId) {
        return (User) redisTemplate.opsForHash().get(KEY, userId);
    }

    // GET ALL USER
    public List<User> getAll() {
        Map<Object, Object> userObjects = redisTemplate.opsForHash().entries(KEY);

        java.util.Collection<Object> values = userObjects.values();

        return values.stream().map(e -> (User) e).toList();
    }


    // DELETE
    public void deleteUser(String userId) {
        redisTemplate.opsForHash().delete(KEY, userId);
    }


}
