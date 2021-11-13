package com.example.javawebday17redis.Jedis.services;

import com.example.javawebday17redis.Jedis.Domain.Province;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface Services {
    public List<Province> findAll();
    public String findAllJson() throws JsonProcessingException;
}
