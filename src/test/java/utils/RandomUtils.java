package utils;

import java.security.SecureRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println("---Test---");
        String s = RandomUtils.randomStr(10);
        System.out.println("random name: " + s);
        System.out.println("------------------");
    }

    public static String AB = "asdfghjklzxcvbnmqwertyuiop";
    static SecureRandom rnd = new SecureRandom();

    public static String randomStr(int len){
        StringBuilder sb = new StringBuilder(len);
        for (int i=0;i<len;i++){
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}
