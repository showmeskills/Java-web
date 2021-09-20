package demo03.customAnnotation;

import java.util.Date;
import java.util.Objects;

public class AnnotationTest {
    public static void main(String ...args){
        //如果只有一个参数的时候可以不写，如果有多个参数需要写
        //@MyAnnotation(value="",values={})
        @MyAnnotation()//如果有默认值就可以暂时不用给值
        Date date = new Date();
    }
}
@MyAnnotation(value="",values={})
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @MyAnnotation(value = "",values={"2243"})
    public void walk(){
        System.out.println("person is walking");
    }

    @MyAnnotation(value="",values = {})
    public void eat(){
        System.out.println("person is eating");
    }
}

interface IPerson{
    void show();
}

class Student extends Person implements IPerson {
    //子类继承父类后，间接使用自定义的注解
    @Override
    public void walk(){
        System.out.println("student is walking");
    }
    @Override
    public void show(){
        System.out.println("show is override in student class");
    }
}

