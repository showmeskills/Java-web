package Demo04;

import java.util.Objects;
@MyAnnotation(value="hi")
public class Person extends Creature<String> implements MyInterface,Comparable<String> {
    private String name;
    public int age;
    @MyAnnotation(value="abcd")
    public Person() {}
    private Person (String name){
        this.name = name;
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
        Demo03CommonMethod.Person person = (Demo03CommonMethod.Person) o;
        return age == person.age && Objects.equals(name, person.getName());
    }
    @Override
    public void info(){
        System.out.println("我是一个人");
    }
    @Override
    public int compareTo(String o) {
        return 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    @MyAnnotation
    private String showNationality(String nationality){
        System.out.println("your nationality is "+ nationality);
        return nationality;
    }

    public void show (){
        System.out.println("nice to meet you, I am a guy");
    }

    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }

    public String display(String interests, int age) throws NullPointerException,ClassCastException{
        return interests + age;
    }
}
