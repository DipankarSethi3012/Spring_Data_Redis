package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    //RedisConnectionFactory is an interface in Spring Data Redis. It provides the actual connection to the Redis Server.
    //Think of it like a DataSource for Redis, just like how JDBC needs DataSource to connect to a database.
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(); //Open and manages the TCP connections to the Redis
        //LettuceConnectionFactory is a default implementation of RedisConnectionFactory that uses Lettuce Redis Client under the hood.
        //Responsible for creating connections to the redis server using thr Lettuce Redis Client.
    }

//core class in spring data redis used to interact with a Redis data store in a type-safe and high -level manner
    @Bean
    public RedisTemplate<String, Object> redisTemplate () {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        //connection Factory
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        //key serializer
        redisTemplate.setKeySerializer(new StringRedisSerializer()); //used to convert keys into byte array

        //value serializer
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer()); //used to convert the values into byte array
        return redisTemplate;
    }
}
//RedisTemplate needs a connection to Redis. That Connection is supplied by RedisConnectionFactory. LettuceConnectionFactory is the most common implementation of the factory.
//In Spring Data Redis, when we're working with RedisTemplate. key/value serializers determine how your Java Objects
// are converted to and from binary data before being stored in the redis.

