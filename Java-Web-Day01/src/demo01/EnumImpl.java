package demo01;

public class EnumImpl {
    public static void main(String ...args){
        Demo[] demo = Demo.values();
        for(Demo ele:demo){
            ele.show();
        }
    }
}
//接口;
interface IDemo{
    public abstract void show();
}
//枚举实现接口
enum Demo implements IDemo{
    //1.提供当前枚举类的对象,多个对象之间用逗号隔开,末尾对象使用分号结束
    SPRING("spring","spring is good"){
        @Override
        public void show() {
            System.out.println("11111");
        }
    },
    SUMMER("summer","summer is good"){
        @Override
        public void show() {
            System.out.println("22222");
        }
    },
    AUTUMN("autumn","autumn is good"){
        @Override
        public void show() {
            System.out.println("333333");
        }
    },
    WINTER("winter","winter is good"){
        @Override
        public void show() {
            System.out.println("4444444");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private Demo(String seasonName,String seasonDesc){
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





