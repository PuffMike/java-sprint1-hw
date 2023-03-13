public class MonthData {

    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i + 1] + " день: ");
        }
    }

    void printMenu() {
        System.out.println("1 - Количество пройденных шагов по дням:");
        System.out.println("2 - Общее количество шагов за меся:");
        System.out.println("3 - Максимальное количество шагов за месяц:");
        System.out.println("4 - Лучшая серия:");
        System.out.println("5 - Назад.");
    }
}
