package com.example.javawebday17redis.Jedis.modal.Impl;

import com.example.javawebday17redis.Jedis.Domain.Province;
import com.example.javawebday17redis.Jedis.modal.IProvince;
import com.example.javawebday17redis.Jedis.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

public class ProvinceImpl implements IProvince {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll(){
        //1.定义sql
        String sql = "select * from province";
        //2.执行sql
        List<Province> provinces = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return provinces;
    }
}
