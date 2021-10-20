package com.nero.springRedis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 23/9/2021 下午9:38
 * @company https://nero-cx.ltd
 */
@SpringBootConfiguration
@PropertySource("classpath:redis.properties")
public class RedisConfiguration {

    @Value("${redis.node.maxTotal}")
    private Integer maxTotal;

    @Value("${redis.node.host}")
    private String host;

    @Value("${redis.node.port}")
    private Integer port;

    //这个是修改redis性能的时候需要的对象
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        return jedisPoolConfig;
    }

    //这个注解注入工厂的名称是方法名
    @Bean
    public JedisPool jedisPool(){
        JedisPoolConfig jedisPoolConfig = jedisPoolConfig();
        return new JedisPool(jedisPoolConfig,host,port);
    }

}
