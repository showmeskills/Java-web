package demo01;

public class SeasonDemo01 {
    /*
     1、枚举的使用
     1、枚举类的理解：类的东西是有有限个，确定的。我们称此为枚举类
     2、当需要定义一组常量的时候，强烈建议大家去使用枚举类
     3、如果枚举类中只有一个对象，则可以作为单例模式的实现方式

     2、自定义枚举类
     方式一：JDK5之前，自定义枚举类
     方式二：JDK5之后，可以使用enum关键字定义枚举类

     三、
  */
    public static void main(String ...args){
        Season spring = Season.SPRING;
        Season summer = Season.SUMMER;
        Season autumn = Season.AUTUMN;
        Season winter = Season.WINTER;
        System.out.println(spring.getSeasonName());
    }
}
//customized enum class
class Season{
    //1.声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;
    //2.私有化构造器,并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }
    //3.提供当前枚举类的多个对象:public static final;constant variables have to up case
    public static final Season SPRING = new Season("spring","spring is good");
    public static final Season SUMMER = new Season("summer","summer is good");
    public static final Season AUTUMN = new Season("autumn","autumn is good");
    public static final Season WINTER = new Season("winter","winter is good");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
