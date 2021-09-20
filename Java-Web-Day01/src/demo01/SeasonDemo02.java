package demo01;
import org.jetbrains.annotations.NotNull;

import java.lang.Enum;
public class SeasonDemo02 {
    public static void main(String ...args){
        SeasonEnum spring =  SeasonEnum.SPRING;
        //toString 返回常量名
        System.out.println(spring.toString());//SPRING
        String name = "SPRING";
        boolean result = spring.toString().equals(name);
        System.out.println(result);//true
        System.out.println(SeasonEnum.class.getSuperclass());//class java.lang.Enum
        //values 方法 返回枚举类型的对象数组
        SeasonEnum[] values = SeasonEnum.values();
        for(SeasonEnum value:values) {
            System.out.println(value.toString());
        }
        System.out.println("************************");
        //获取当前有多少个线程
        Thread.State[] threadValues = Thread.State.values();
        for(Thread.State threadValue:threadValues) {
            System.out.println(threadValue);
        }
        System.out.println("************************");
        //valueOf:返回枚举类中对象名是objName的对象名的字符串;如果没有就会报错
        SeasonEnum winter = SeasonEnum.valueOf("WINTER");
        System.out.println(winter);//WINTER
    }
    public static String seasonName (SeasonEnum value){
        String name = "";
        switch (value.toString()){
            case "SPRING":
            case "SUMMER":
            case "AUTUMN":
            case "WINTER":
                return name = value.toString();
            default:
                return name = "there are no name";
        }
    }
}
enum SeasonEnum{
    //1.提供当前枚举类的对象,多个对象之间用逗号隔开,末尾对象使用分号结束
    SPRING("spring","spring is good"),
    SUMMER("summer","summer is good"),
    AUTUMN("autumn","autumn is good"),
    WINTER("winter","winter is good");

    private final String seasonName;
    private final String seasonDesc;

    private SeasonEnum(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}

