package Demo05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 *
 * 当主方法执行后，会自动自行被检测的所有方法(加了Check注解的方法)，判断方法是否有异常，记录到文件中
 */
public class TestCheck {
    public static void main(String... args) throws IOException {
        //1.创建计算器对象
        Calculator calc = new Calculator();
        //2.获取字节码文件对象
        Class cls = calc.getClass();
        //3.获取所有方法
        Method[] methods = cls.getMethods();

        int number = 0; //出现异常的次数
        //写入异常文件
        File path = new File(new File("").getAbsolutePath(),"src/bug.txt");
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);

        for(Method method:methods){
            //4。判断方法上是否有Check注解
            if(method.isAnnotationPresent(Check.class)){
                //5.有=>执行
                try{
                    method.invoke(calc);
                }catch (Exception e){
                    //6.捕获异常
                    //记录到文件中
                    number++;

                    bw.write(method.getName()+"方法出现异常");
                    bw.newLine();
                    bw.write("异常的名称:"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("------------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现 "+number+" 次异常");
        bw.flush();
        bw.close();
    }
}
