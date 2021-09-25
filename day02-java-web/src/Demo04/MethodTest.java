package Demo04;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.SQLOutput;

public class MethodTest {
    @Test
    public void test() {
        Class<Person> clazz = Person.class;
        //getMethods:获取当前运行时类及其父类所有父类中声明的public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        //获取getDeclaredMethods获取当前运行时类中声明的所有方法(不包含父类中声明的方法)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    //权限修饰符 方法返回值 方法名 参数 异常
    @Test
    public void test2() {
        Class personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            //1.获取方法声明的注解
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);//@Demo04.MyAnnotation(value=hello)
            }
            //权限修饰符
            System.out.print(Modifier.toString(method.getModifiers()) + "\t");
            //3.返回值类型
            System.out.print(method.getReturnType().getName() + "\t");
            //方法名
            System.out.print(method.getName());
            System.out.print("(");
            //形参列表
            Class[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes == null) && parameterTypes.length != 0) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + " arg_"+ i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " arg_" + i + ",");
                }
            }
            System.out.print(")");
            //获取抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName());
                }
            }
            System.out.println();
        }
    }
    //获取构造方法
    @Test
    public void test3(){
        Class clazz = Person.class;
        //getConstructors():获取当前运行类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constructor:constructors){
            System.out.println(constructor);
        }
        System.out.println();
        //getDeclaredConstructors():获取当前运行类中声明的所有的构造器
        Constructor[] cs = clazz.getDeclaredConstructors();
        for(Constructor c:cs){
            System.out.println(c);
        }
    }
}
