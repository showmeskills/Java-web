package com.example.javawebday17redis.Jedis.services.Impl;

import com.example.javawebday17redis.Jedis.Domain.Province;
import com.example.javawebday17redis.Jedis.modal.IProvince;
import com.example.javawebday17redis.Jedis.modal.Impl.ProvinceImpl;
import com.example.javawebday17redis.Jedis.services.Services;
import com.example.javawebday17redis.Jedis.utils.JedisPoolUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ServicesImpl implements Services {
    //声明modal
    private IProvince iProvince = new ProvinceImpl();
    @Override
    public List<Province> findAll(){
        return this.iProvince.findAll();
    }
    //声明redis 缓存
    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        //1.1 获取redis客户端链接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        if(province_json == null || province_json.length() == 0){
           try{
               //redis 中没有数据
               System.out.println("redis 没有数据,查询数据库");
               List<Province> province = this.iProvince.findAll();
               //将List序列化为json
               ObjectMapper mapper = new ObjectMapper();
               province_json = mapper.writeValueAsString(province);
               //将json数据存入redis
               jedis.set("province",province_json);
               //归还连接
               jedis.close();
           } catch (JsonProcessingException e) {
               e.printStackTrace();
           }
        }else{
            //redis 中有数据
            System.out.println("redis 有数据,查询缓存");
        }
        return province_json;
    }
}
