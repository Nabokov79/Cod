package home.serg.struct;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Поехали!
        Scanner scanner = new Scanner(System.in);
        String[] nameMonth = {"Январь", "Февраль", "Март"};
        Commander commander = new Commander();
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                commander.command1();
            } else if (command == 2) {
                commander.command2();
            } else if (command == 3) {
                commander.command3();
            } else if (command == 4) {
               commander.command4();
            } else if (command == 5) {
                commander.command5();
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
}
