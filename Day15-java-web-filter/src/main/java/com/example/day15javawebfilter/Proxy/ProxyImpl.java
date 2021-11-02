package com.example.day15javawebfilter.Proxy;

public class ProxyImpl implements IProxy{
    @Override
    public String sale(double money){
        System.out.println("花了"+money+"买一个台电脑");
        return "Mac pro";
    }
    @Override
    public void show(){
        System.out.println("展示电脑");
    }
}
