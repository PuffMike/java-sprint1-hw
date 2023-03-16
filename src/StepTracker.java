import java.util.Scanner;

public class StepTracker {

    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();

    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepPerDay() {
        System.out.println("Введите номер месяца (от 1 до 12):");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Введено неверное знаечение месяца.");
            return;
        }

        System.out.println("Введите дату (от 1 до 30):");
        int data = scanner.nextInt();
        if (data < 1 || data > 30) {
            System.out.println("Введено неверное значение дата.");
            return;
        }

        System.out.println("Введите колличество шагов:");
        int steps = scanner.nextInt();
        if (steps < 1) {
            System.out.println("Введено неверное количество шагов.");
            return;
        }
            System.out.println("Сохранено!");

        MonthData monthData = monthToData[month - 1];

        monthData.days[data - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель шагов на день:");
        int stepGoal = scanner.nextInt();
        if (stepGoal <= 0) {
            System.out.println("Введено недопустимое значение!");
        } else {
            System.out.println("Сохранено!");
            goalByStepsPerDay = stepGoal;
        }
    }

    void printStatistic() {
        System.out.println("Введите число месяца (от 1 до 12)");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Введено неверное значение.");
            return;
        }

        MonthData monthData = monthToData[month - 1];

        while (true) {
            printMenu();

            int number = scanner.nextInt();

            if (number == 1) {
                monthData.printDaysAndStepsFromMonth();
            } else if (number == 2){
                System.out.println("* Общее количество шагов за месяц: " + monthData.sumStepsFromMonth());
            } else if (number == 3) {
                System.out.println("* Максимальное количество пройденных шагов за месяц: " + monthData.maxSteps());
            } else if (number == 4) {
                System.out.println("* Среднее количесво пройденных шагов за месяц: " + (monthData.sumStepsFromMonth()/monthData.days.length));
            } else if (number == 5) {
                System.out.println("* За месяц вы прошли " + converter.convertToKm(monthData.sumStepsFromMonth()) + " км.");
            } else if (number == 6) {
                System.out.println("* За месяц было сожжено " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()) + " килокалорий");
            } else if (number == 7){
                System.out.println("* Лучшая серия в этом месяце составила: " + monthData.bestSeries(goalByStepsPerDay));
            } else if (number == 8){
                monthData.printDaysAndStepsFromMonth();
                System.out.println("* Общее количество шагов за месяц: " + monthData.sumStepsFromMonth());
                System.out.println("* Максимальное количество пройденных шагов за месяц: " + monthData.maxSteps());
                System.out.println("* Среднее количесво пройденных шагов за месяц: " + (monthData.sumStepsFromMonth()/monthData.days.length));
                System.out.println("* За месяц вы прошли " + converter.convertToKm(monthData.sumStepsFromMonth()) + " км.");
                System.out.println("* За месяц было сожжено " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()) + " килокалорий");
                System.out.println("* Лучшая серия в этом месяце составила: " + monthData.bestSeries(goalByStepsPerDay));
                break;
            } else if (number == 0){
                break;
            } else {
                System.out.println("Извините, такого варианта нет.");
            }

        }
        System.out.println();
    }

    void printMenu() {
        System.out.println("1 - Вывод общей статистики по дням");
        System.out.println("2 - Вывод суммы шагов за месяц");
        System.out.println("3 - Вывод максимального пройденного количества шагов за месяц");
        System.out.println("4 - Вывод среднего пройденного количества шагов за месяц");
        System.out.println("5 - Вывод пройденной за месяц дистанции в км");
        System.out.println("6 - Вывод количества сожжённых килокалорий за месяц");
        System.out.println("7 - Вывод лучшей серии");
        System.out.println("8 - Вывод всей статистики");
        System.out.println("0 - <-- Назад");
    }

}