package Demo04;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {
    @Test
    public void test(){
        //获取实例
        Class<Person> clazz = Person.class;
        //获取属性结构
        //getField:获取当前运行时及其父类中声明的public访问权限属性
        Field[] fields = clazz.getFields();
        for(Field f:fields){
            System.out.println(f);//这个会打印出父类和当前类的 public属性
            //public int Demo04.Person.age
            //public double Demo04.Creature.weight
        }

        System.out.println("*********************");

        //getDeclaredFields:获取当前运行时类中所声明的所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f:declaredFields){
            //private java.lang.String Demo04.Person.name
            //public int Demo04.Person.age
            System.out.println(f);//当前运行类的所有属性
        }
    }
    @Test
    public void test1(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            //获取权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier)+"\t");//private public

            //获取数据类型
            Class type = f.getType();
            System.out.print(type.getName()+"\t");//class java.lang.String int

            //获取变量名
            String name = f.getName();
            System.out.println(name);
        }
    }
}
