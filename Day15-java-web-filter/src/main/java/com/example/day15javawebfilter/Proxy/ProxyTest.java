package com.example.day15javawebfilter.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] ...args){
            //1.创建真实对象
            ProxyImpl proxyImpl = new ProxyImpl();
            proxyImpl.sale(5000);
            //2.动态代理对象:代理对象是存在内存中的
            ProxyImpl proxy_sale = (ProxyImpl)Proxy.newProxyInstance(
                    proxyImpl.getClass().getClassLoader(),//需要代理的类
                    proxyImpl.getClass().getInterfaces(),//需要代理的类的接口;得到对象里面的所有方法
                    new InvocationHandler() { //处理器
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            //这里写逻辑代码
                            if(method.getName().equals("sale")){
                                //1.增强参数
                                double money = (double) args[0];
                                //2.计算
                                money = money * .85;
                                System.out.println("专车接送");
                                //使用真实对象调用该方法.invoke(真实对象，需要增强的参数);强转与接口类型一致
                                String invoke = (String) method.invoke(proxyImpl,money);
                                System.out.println("免费送货");
                                return invoke + "送鼠标垫";
                            }else{
                                Object invoke = method.invoke(proxyImpl, args);
                                return invoke;
                            }
                        }
                    }
            );
    }
}
