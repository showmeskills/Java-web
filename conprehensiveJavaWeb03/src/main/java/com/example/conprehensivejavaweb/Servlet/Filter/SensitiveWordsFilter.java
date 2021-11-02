package com.example.conprehensivejavaweb.Servlet.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<>();
    @Override
    public void init (FilterConfig filterConfig) throws ServletException{
        try{
            //1.获取文件真实路径
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/sensitiveWords.txt");
            //2.读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            //3.将文件的每一行数据添加到list中
            String line = null;
            while((line = br.readLine())!= null){
                list.add(line);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.创建代理对象,增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(
                servletRequest.getClass().getClassLoader(),
                servletRequest.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) ->{
                try{
                    //增强getParameter方法
                    //判断是否是getParameter方法
                    if(method.getName().equals("getParameter")){
                        System.out.println("1");
                        //增强返回值
                        //获取返回值
                        String value = (String) method.invoke(servletRequest,args);
                        System.out.println(value);
                        if(value != null){
                            for(String str : this.list){
                                if (value.contains(str)) {
                                    value = value.replaceAll(str,"***");
                                }
                            }
                        }
                        return value;
                        //判断方法名是否是getParameterMap
                    }else if(method.getName().equals("getParameterMap")){
                        System.out.println("2");

                        //判断方法名是否是getParameterValue
                    }else if(method.getName().equals("getParameterValue")){
                        System.out.println("3");
                    }

                }catch (Throwable e){
                    e.printStackTrace();
                }
                    return method.invoke(servletRequest,args);
                });
        //2.放行
        filterChain.doFilter(proxy_req,servletResponse);
    }

    @Override
    public void destroy(){}
}
