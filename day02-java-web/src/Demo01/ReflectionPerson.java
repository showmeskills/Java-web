package Demo01;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionPerson {
    @Test
    public void test(){
        Person person = new Person();
        person.age = 50;
        person.setName("Terrance");
        person.show();
        System.out.println(person);
    }
    //反射之后 对于Person的操作
    /*
    java.lang.Class理解
    1、类加载过程
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程我们就称为类的加载。加载到内存中的内，我们就称为运行是类，此类
    运行时类，就作为Class的一个实例
    2.换句话说，Class的实例就对应着一个运行时类。
    3.加载到内存的运行时类，会缓存一定的时间，在此时间内，我们就可以通过不同的方式
    来获取此运行时类
     */
    @Test
    public void reflectionTest() throws Exception {
        // Class<T>  class
        Class<Person> PersonClass = Person.class;
        //1、通过反射，创建Person类对象(反射都是通过字节码文件来操控)
        Constructor<Person> constructor = PersonClass.getConstructor(String.class,int.class);
        Object obj = constructor.newInstance("Terry",18);
        Person person = (Person)obj;
        System.out.println(person.toString());
        //2、通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = PersonClass.getDeclaredField("age");
        age.set(person,10);//Object value
        System.out.println(person.toString());
        //调用方法
        System.out.println("************method****************");

        //通过反射，可以调用Person类的私有结构，比如：构造器，方法，属性
        Method show = PersonClass.getDeclaredMethod("show");
        show.invoke(person);//call Person show method
        //调用私有的构造方法
        Constructor<Person> declaredConstructor = PersonClass.getDeclaredConstructor(String.class);
        //设置暴力反射
        declaredConstructor.setAccessible(true);
        Object objectAccessiblePerson = declaredConstructor.newInstance("Terrance");
        Person person1 = (Person)objectAccessiblePerson;
        //调用私有属性
        Field name = PersonClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1,"Terrance12345");
        System.out.println(person1);
        //调用私有方法 (如何方法还有参数需要添加参数)
        Method showNationality = PersonClass.getDeclaredMethod("showNationality",String.class);
        showNationality.setAccessible(true);
        //获取私有方法的返回值
        String nationality = (String)showNationality.invoke(person1, "China");
        System.out.println(nationality);
    }
    @Test
    public void test2(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        //只要数组的维度是一样的,就是同一个Class
        int[] a = new int[10];
        int[] b= new int[100];
        Class aClass = a.getClass();
        Class bClass = b.getClass();
        System.out.println(aClass.equals(bClass));//true
        Class c4Class = c4.getClass();
        System.out.println(aClass.equals(c4Class));//false
        String[] c = new String[10];
        Class cClass = c.getClass();
        System.out.println(cClass.equals(c3));//true;
    }
    @Test
    public void test3() throws ClassNotFoundException {
        //获取实例的方式(4种)
        //方式一:调用运行时的属性
        Class clazz1 = Person.class;
        System.out.println(clazz1);//class Demo01.Person
        //方式二:通过运行时类的对象，调用getClass()
        Class clazz2 = new Person().getClass();
        System.out.println(clazz2);//class Demo01.Person
        //方式三:调用Class的静态方法:forName(String classpath) src下的路径
        Class clazz3 = Class.forName("Demo01.Person");//throws ClassNotFoundException
        System.out.println(clazz3);//class Demo01.Person
        //方式四:使用类的加载器:ClassLoader(了解)
        ClassLoader classLoader = ReflectionPerson.class.getClassLoader();//当前reflection类.class.getClassLoader()
        Class clazz4 = classLoader.loadClass("Demo01.Person");//classpath
        System.out.println(clazz4);//class Demo01.Person
    }
}
