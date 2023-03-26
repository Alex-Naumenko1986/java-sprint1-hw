import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    Converter converter;
    MonthData[] monthToData;
    int goalByStepsPerDay;

    StepTracker (Scanner scanner) {
        this.scanner = scanner;
        monthToData = new MonthData[12];
        converter = new Converter();
        goalByStepsPerDay = 10000;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Введен неверный номер месяца. Номер месяца должен быть от 1 до 12 (включительно)");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно):");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Введен неверный номер дня. Номер дня должен быть от 1 до 30 (включительно)");
            return;
        }

        System.out.println("Введите количество шагов:");
        int steps = scanner.nextInt();
            if (steps <= 0) {
                System.out.println("Введено неверное количество шагов. " +
                        "Количество шагов должно быть положительным числом");
                return;
            }

        MonthData monthData = monthToData[month-1];
        monthData.days[day-1] = steps;
        System.out.println("Количество шагов сохранено");
    }

    void changeStepGoal() {
        System.out.println("Введите новое целевое количество шагов:");
        int stepGoal = scanner.nextInt();
        if (stepGoal <= 0) {
            System.out.println("Целевое количество шагов должно быть больше нуля");
            return;
        }
        goalByStepsPerDay = stepGoal;
        System.out.println("Целевое количество шагов обновлено. Новая цель - " + goalByStepsPerDay + " шагов в день");
    }

    void printStatistic() {
        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Введен неверный номер месяца. Номер месяца должен быть от 1 до 12 (включительно)");
            return;
        }

        MonthData monthData = monthToData[month-1];
        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("Количество пройденных шагов по дням:");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Cреднее количество шагов: " +  sumSteps/monthData.days.length);
        System.out.println("Пройденная за месяц дистанция (в км): " + converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых за месяц килокалорий: " +
                converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия (дней): " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
