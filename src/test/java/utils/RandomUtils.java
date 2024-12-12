package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public  static String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println("-------Test------");
        String randomString = RandomUtils.randomStr(10);
        System.out.println("Random name: " + randomString);
        System.out.println("Random name: " + faker.superhero().name());
        randomStr(8);
        System.out.println("Random email: " + new RandomUtils().randomEmail());
        System.out.println("Random email: " + faker.internet().emailAddress());
        System.out.println("Random mobile: " + faker.phoneNumber());
        System.out.println("Random state: " + new RandomUtils().randomItem(states));
        String inputTime = LocalDateTime.now().toString();
        System.out.println(inputTime);
        System.out.println(inputTime.replaceAll("\\D", ""));
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
