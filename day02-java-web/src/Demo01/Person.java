package Demo01;

import java.util.Objects;

public class Person {
    private String name;
    public int age;

    public Person() {
    }
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
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    private String showNationality(String nationality){
        System.out.println("your nationality is "+ nationality);
        return nationality;
    }
    public void show (){
        System.out.println("nice to meet you, I am a guy");
    }
}
