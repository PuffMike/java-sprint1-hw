import java.util.Scanner;

public class StepTracker {

    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

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
        System.out.println("Введите дату (от 1 до 30):");
        int data = scanner.nextInt();
        System.out.println("Введите колличество шагов:");
        int steps = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Введено неверное знаечение месяца.");
            return;
        } else if (data < 1 || data > 30) {
            System.out.println("Введено неверное значение дата.");
            return;
        } else if (steps < 0) {
            System.out.println("Введено неверное количество шагов.");
            return;
        } else {
            System.out.println("Сохранено!");
        }

        MonthData monthData = monthToData[month - 1];

        monthData.days[data] = steps;
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель шагов на день:");
        int stepGoal = scanner.nextInt();
        if (stepGoal <= 0) {
            System.out.println("Введено недопустимое значение!");
            return;
        } else {
            goalByStepsPerDay = stepGoal;
        }
    }

}