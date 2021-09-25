package Demo02ClassLoder;

import org.junit.Test;

public class ClassLoaderTest {
    @Test
    public void test(){
        System.out.println(A.m);//所以打印100;
    }
}
class A{
    //先执行静态代码块
    static {
        int m = 300;
    }
    //再执行 静态变量
    static int m = 100;
}
