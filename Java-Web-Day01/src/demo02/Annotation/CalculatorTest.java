package demo02.Annotation;

public class CalculatorTest {
    public static void main(String ...args){
        Calculator calc = new Calculator();
        int num = calc.sum(1,2);
        int num1 = calc.time(3,3);
        System.out.println(num);
        System.out.println(num1);
    }
}
