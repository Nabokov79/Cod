
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        Scanner scanner = new Scanner(System.in);
        String[] nameMonth = {"Январь", "Февраль", "Март"};
        NameFile nameFile = new NameFile();
        CalculationYearData calculationYearData = new CalculationYearData();
        CalculationMonthlyData calculationMonthlyData = new CalculationMonthlyData();
        Comparison comparison = new Comparison();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                nameFile.doFileNameMonth(nameMonth);
            } else if (command == 2) {
                nameFile.doFileNameYear(nameMonth);
            } else if (command == 3) {
                comparison.compareData();
            } else if (command == 4) {
                calculationMonthlyData.checkMonthsDataTable();
            } else if (command == 5) {
                calculationYearData.checkYearDataTable();
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Данная команда не поддерживается. Повторите выбор.");
            }
        }
    }

    static void printMenu () {
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}