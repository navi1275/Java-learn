package com.navi.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * UserController Class
 *
 * @author navi
 * @date 2019-07-19
 * @since 1.0.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @RequestMapping("/lists")
    public Object lists(){
        return redisTemplate.opsForHash().values("user");
    }


    @RequestMapping("/lists/{id}")
    public Object get(@PathVariable Long id){
        return (User)redisTemplate.opsForHash().get("user", "user_" + id);
    }

    @RequestMapping("/add/{id}")
    public Object add(@PathVariable Long id){

        User user = new User();
        user.setId(id);
        user.setUsername("aaaa_" + id);
        user.setPassword("password_" + id);
        redisTemplate.opsForHash().put("user", "user_"+id, user);
        return (User)redisTemplate.opsForHash().get("user", "user_" + id);
    }
}
