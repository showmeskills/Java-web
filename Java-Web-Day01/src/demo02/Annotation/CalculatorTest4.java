package demo02.Annotation;

import org.junit.*;

public class CalculatorTest4 {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("before class");
    }
    @Before
    public void before(){
        System.out.println("before");
    }
    @Test
    public void start(){
        System.out.println("test");
    }
    @After
    public void after(){
        System.out.println("after");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("after class");
    }
}
