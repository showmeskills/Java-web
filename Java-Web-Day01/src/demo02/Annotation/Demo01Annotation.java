package demo02.Annotation;

import java.util.Date;

public class Demo01Annotation {
    public static void main(String ...args){
        @SuppressWarnings("unsed")
        Date date = new Date();
    }

    /**
     * @author Terrance,Terry
     * @param a this is number param
     * @param args this is for series String
     * @return String;
     */
    public static String method(int a ,String ...args){

        return "";
    }
}
