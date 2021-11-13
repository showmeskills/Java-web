package com.example.javawebday17redis.Jedis.Test;

import com.example.javawebday17redis.Jedis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    /*
    * string 结构
    * */
    @Test
    public void test(){
        //1.获取链接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        //存储
        jedis.set("username","terrance");
        //查询
        String username = jedis.get("username");
        System.out.println(username);
        //修改
        jedis.set("username","terry");
        String userName = jedis.get("username");
        System.out.println(userName);
        //删除
        Long isDel = jedis.del("username");
        System.out.println(isDel);//返回 1 就是被删除了
        //3.关闭连接
        jedis.close();
    }
    /*
    * String 结构 存储方法2
    * */
    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost",6379);
        //存储方法2:setex()方法存储可以指定过期时间的 key value
        //将activecode：hehe键值对存入redis，并且20秒后自动删除该键值对
        jedis.setex("activecode",20,"hehe");
        String code = jedis.get("activecode");
        System.out.println(code);
        jedis.close();
    }
    //hash 数据结构 set
    @Test
    public void test2(){
        //1.链接如果是空参就是默认端口
        Jedis jedis = new Jedis();
        //2.操作
        //存储hash
        jedis.hset("user","name","Terry");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","female");
        //获取hash
        String name = jedis.hget("user","name");
        String age = jedis.hget("user","age");
        String gender = jedis.hget("user","gender");

        //System.out.println(name+" "+age+" "+gender);
        //遍历所有
        Map<String,String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for(String key:keySet){
            String value = user.get(key);
            System.out.println(key+":"+value);
        }
        //3.关闭
        jedis.close();
    }

    //list 数据结构操作 列表集合
    @Test
    public void test3(){
        //1.获取连接
        Jedis jedis = new Jedis();
        //2.操作
        jedis.lpush("mylist","a","b","c");//从左边存
        jedis.rpush("mylist","e","f","g");//从右边存
        //获取
        List<String> myList = jedis.lrange("mylist",0,-1);
        System.out.println(myList);//[c, b, a, c, b, a, e, f, g, e, f, g]
        //删除
        jedis.lpop("mylist");
        jedis.rpop("mylist");
        //获取
        List<String> myList1 = jedis.lrange("mylist",0,-1);
        System.out.println(myList1);//[b, a, c, b, a, e, f, g, e, f]
        //3.关闭操作
        jedis.close();
    }

    //set 数据结构 无须不可以重复
    @Test
    public void test4(){
        //1. 获取连接
        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
        //2. 操作

        // set 存储
        jedis.sadd("myset","java","php","c++");

        // set 获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        jedis.srem("myset","java","php","c++");
        // set 获取
        Set<String> myset1 = jedis.smembers("myset");
        System.out.println(myset1);
        //3. 关闭连接
        jedis.close();
    }
    //sortedset 有序不可以重复
    @Test
    public void test5(){
        //1. 获取连接
        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
        //2. 操作
        // sortedset 存储
        jedis.zadd("mysortedset",3,"亚瑟");
        jedis.zadd("mysortedset",30,"后裔");
        jedis.zadd("mysortedset",55,"孙悟空");

        // sortedset 获取
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);

        System.out.println(mysortedset);

        jedis.zrem("mysortedset","亚瑟","后裔","孙悟空");
        Set<String> mysortedset1 = jedis.zrange("mysortedset", 0, -1);

        System.out.println(mysortedset1);
        //3. 关闭连接
        jedis.close();
    }
    //jedis 连接池使用
    @Test
    public void test6(){
        //1.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //2.创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        //3.获取连接
        Jedis jedis = jedisPool.getResource();
        //4. 使用
        jedis.set("hehe","heihei");
         //获取
        String name = jedis.get("hehe");
        System.out.println(name);
        //5. 关闭 归还到连接池中
        jedis.close();;
    }
    //jedis 连接池工具类使用
    @Test
    public void test7(){
        //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();
        //3. 使用
        jedis.set("utils","ok");
        String name = jedis.get("utils");
        System.out.println(name);
        //4. 关闭 归还到连接池中
        jedis.close();
    }
}
