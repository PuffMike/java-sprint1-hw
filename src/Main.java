import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       StepTracker stepTracker = new StepTracker(scanner);
       while (true) {
           printMenu();
           int number = scanner.nextInt();

           if (number == 1) {
               stepTracker.addNewNumberStepPerDay();
               // Вывести кол-во шагов
           } else if (number == 2) {
               stepTracker.changeStepGoal();
               // Изменить цель по кол-ву шагов
           } else if (number == 3) {
               // Напечатать статистику за определенный месяц
           } else if (number == 0) {
               System.out.println("Возвращайтесь!");
               break; // Выходим из цикла
           } else {
               System.out.println("Извините, такого варианта нет.");
           }
       }
    }

    public static void printMenu() {
        System.out.println("Приветствуем Вас в нашем приложении! Чего желаете?");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Изменить цель по количеству шагов в день.");
        System.out.println("3 - Напечатать статистику за определённый месяц");
        System.out.println("4 - Выйти из приложения.");
    }
}

