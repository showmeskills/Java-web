package demo02.Annotation;


import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest2 {
    /**
     *
     */
    @Test
    public void testSum(){
        Calculator calc = new Calculator();
        int num = calc.sum(1,2);
        System.out.println(num);
        Assert.assertEquals(3,num);//断言结果是不是3
    }
    @Test
    public void testTime(){
        Calculator calc = new Calculator();
        int num1 = calc.time(3,3);
        System.out.println(num1);
        Assert.assertEquals(9,num1);//断言结果是不是9
    }
}
