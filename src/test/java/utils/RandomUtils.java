package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public  static String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    public static void main(String[] args) {
        System.out.println("-------Test------");
        String randomString = RandomUtils.randomStr(10);
        System.out.println("Random name: " + randomString);
        randomStr(8);
        System.out.println("Random email: " + new RandomUtils().randomEmail());
        System.out.println("Random state: " + new RandomUtils().randomItem(states));
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

    public  String randomEmail(){
        return randomStr(5) + "@mail.ru";
    }

    public  static int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public  String randomItem(String[] values){
        int index = randomInt(0, values.length-1);
        return values[index];
    }
}
