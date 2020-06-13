package helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Created by Hmayak Atayan on  13, Jun, 2020
 */
public class CommonHelpers {
    final static String TEXT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getCurrentDate(String format) {
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate.format(DateTimeFormatter.ofPattern(format));
    }

    public static void main(String[] args) {
//        System.out.println(getCurrentDate("dd/MM/YY"));
        System.out.println(getRandomString(TEXT, 10));
    }

    public static String getRandomString(String charactersList, int length) {
        int size = charactersList.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (length-- != 0) {
            stringBuilder.append(charactersList.charAt(new Random().nextInt(size)));
        }
        return stringBuilder.toString();
    }
}
