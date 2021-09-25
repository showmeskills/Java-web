package Demo03CommonMethod;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class CommonMethod {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //创建运行时的类
        Class PersonClass = Person.class;
        //获取空参构造器
        Constructor PersonClassConstructor =PersonClass.getConstructor();
        //newInstance()调用此方法，创建对于的运行时类对象。内部调用了运行时类的空参构造方法
        Object obj = PersonClassConstructor.newInstance();
        //转换Person类
        Person person = (Person) obj;
        System.out.println(person);//Person{name='null', age=0}
    }
    //体会反射的动态性
    @Test
    public void test2(){
        for(int i=0; i < 3; i++){
            int num = new Random().nextInt(3);
            String classpath = "";
            switch (num){
                case 0:
                    classpath = "java.util.Date";
                    break;
                case 1:
                    classpath = "java.lang.Object";
                    break;
                case 2:
                    classpath = "Demo03CommonMethod.Person";
                    break;

            }
            try{
                Object obj = this.getInstance(classpath);
                System.out.println(obj);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }


    /*
        创建一个指定类的对象
        classpath：指定类的全类名
     */
    public Object getInstance(String classpath)throws Exception{
        Class clazz = Class.forName(classpath);
        return clazz;
    }
}
