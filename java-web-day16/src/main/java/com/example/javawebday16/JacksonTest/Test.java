package com.example.javawebday16.JacksonTest;

import com.example.javawebday16.JacksonJar.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.util.*;

public class Test {

    //java 对象专为json字符串
    public String test () throws Exception{
        //1.创建Person对象
        Person person = new Person();
        person.setName("Terry");
        person.setAge(18);
        person.setGender("男");
        person.setBirthday(new Date());
        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        /*
        * 转换方法:
        *   writeValue(参数1,obj);
        *   参数1:
        *       File:将obj对象转换为JSON字符串，并保存到指定的文件中
        *       Writer:将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
        *       OutputStream:将obj对象转换JSON字符串,并将json数据填充到字节输出流中
        *       writeValueAsString(obj):将对象转为json字符串(常用方法)
        * */
        String json = mapper.writeValueAsString(person);
        System.out.println(json);

        //writeValue，将数据写到文件中
        //mapper.writeValue(new File("/Users/yantinglong/Documents/java/java/Java-Web/java-web-day16/target/classes/person.json"),person);

        //writeValue.将数据关联到Writer中 把json写入txt/json文件中
        mapper.writeValue(new FileWriter("/Users/yantinglong/Documents/java/java/Java-Web/java-web-day16/target/classes/person.json"),person);
        return json;//返回json 然后通过resp.getWrite().write(json) 发送到前端
    }
    public String test2() throws JsonProcessingException {

        Person person = new Person();
        person.setName("Terry");
        person.setAge(18);
        person.setGender("男");
        Person person1 = new Person();
        person1.setName("Terry1");
        person1.setAge(19);
        person1.setGender("男");
        Person person2 = new Person();
        person2.setName("Terry2");
        person2.setAge(20);
        person2.setGender("男");
        //创建数组
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);
        list.add(person2);
        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        return json;
    }
    public String test3() throws JsonProcessingException {
        Person person = new Person();
        person.setName("Terry");
        person.setAge(19);
        person.setGender("男");
        person.setBirthday(new Date());
        //1.创建map对象
        Map<String,Object> map = new HashMap<>();
        map.put("name",person.getName());
        map.put("age",person.getAge());
        map.put("gender",person.getGender());
        map.put("dob",person.getBirthday());

        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        return json;
    }

    public String test4() throws Exception {
        Person person = new Person();
        person.setName("Terry");
        person.setAge(19);
        person.setGender("男");
        person.setBirthday(new Date());
        //1.创建map对象
        Map<String,Object> map = new HashMap<>();
        map.put("name",person.getName());
        map.put("age",person.getAge());
        map.put("gender",person.getGender());
        map.put("dob",person.getBirthday());
        List<Map<String,Object>> list = new ArrayList();
        list.add(map);
        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        this.test5();
        return json;
    }
    public void test5() throws Exception {
        //1.初始化JSON字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";

        //2.创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //3.转换为Java对象 Person对象
        Person person = mapper.readValue(json, Person.class);

        System.out.println(person);
    }
}
