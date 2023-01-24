package game_number;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Игра начинатеся, нужно угадать число от 0 до 100. Удачи!");

        String playAgain = "";

        int numberOfAttempts = 0;
        do {

            int randomNumber = (int) (Math.random() * 100 - 1);
            //System.out.println(randomNumber);
            int guessNumber = 0;
            guessNumber = scan.nextInt();
            System.out.println("Вы ввели число: " + guessNumber + " продолжаем");

            while (randomNumber != guessNumber) {
                System.out.println("Число должно быть от 0 до 100. Начинайте угадывать...");
                guessNumber = scan.nextInt();
                numberOfAttempts = numberOfAttempts + 1;
                if (guessNumber < randomNumber)
                    System.out.println(guessNumber + " это число меньше. Попробуйте ещё.");
                else if (guessNumber > randomNumber)
                    System.out.println(guessNumber + " это число больше. Попробуйте ещё.");
                else
                    System.out.println(guessNumber + " Правильно! Вы победили!!!");

            }
            System.out.println("Хотите сыграть ещё раз (y/n)?");
            playAgain = scan.next();
        } while (playAgain.equalsIgnoreCase("y"));
        System.out.println("Спасибо, что поиграли с нами. До свиданья!");
        System.out.println("Вы сделали " + numberOfAttempts + " попыток для победы! Хорошая работа!");
        scan.close();
    }
}

