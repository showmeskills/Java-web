package demo02.Annotation;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest3 {

    @Test
    public void testSum(){
        Calculator calc = new Calculator();
        int num = calc.sum(1,2);
        System.out.println(num);
        Assert.assertEquals(3,num);//断言结果是不是3
    }
    @Before//在@Test方法执行前执行,常用于获取资源
    public void init(){
        System.out.println("before");
    }
    @After//在@Test方法执行后执行，常用于关闭资源
    public void end(){
        System.out.println("after");
    }
}
