import java.util.ArrayList;
import java.util.HashMap;

public class CalculationYearData {

    HashMap<String, ArrayList<YearlyReport>> dataYear = new HashMap<>();

    void loadDataYear(String[] nameMonth, ArrayList<YearlyReport> yearList) {
        for (int i = 1; i < 4; i++) {
            ArrayList<YearlyReport> newYearData = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                YearlyReport data = yearList.get(j);
                if (data.month == (i)) {
                    newYearData.add(data);
                }
            }
            dataYear.put(nameMonth[i - 1], newYearData);
        }
        System.out.println("Данные успешно считаны.");
    }

    public void checkYearDataTable() {
        if (dataYear.isEmpty()) {
            printProfit();
            printAverageConsumption();
            printAverageIncome();
        } else {
            System.out.println("Выполните считывание данных.");
        }
    }

    public void printProfit() {
        for (String month : dataYear.keySet()) {
            ArrayList<YearlyReport> values = dataYear.get(month);
            double amountIncome = 0;
            double amountExpense = 0;
            for (YearlyReport data : values) {
                if (data.isExpense) {
                    amountExpense = data.amount;
                } else {
                    amountIncome = data.amount;
                }
            }
            double profit = amountIncome - amountExpense;
            System.out.println(month + ": прибыль составила " +profit);
        }
    }

    public void printAverageConsumption() {
        double expenses = 0;
        for (ArrayList<YearlyReport> expensesList : dataYear.values()) {
            for (YearlyReport expense : expensesList) {
                if (expense.isExpense) {
                    expenses += expense.amount;
                }
            }
        }
        double averageExpenditure = expenses / dataYear.size();
        String resultExpenses = String.format("%.2f", averageExpenditure);
        System.out.println("Средний расход за все месяцы в году составил " + resultExpenses);
    }

    public void printAverageIncome() {
        double income = 0;

        for (ArrayList<YearlyReport> incomeList : dataYear.values()) {
            for (YearlyReport expense : incomeList) {
                if (!expense.isExpense) {
                    income += expense.amount;
                }
            }
        }
        double averageIncome = income/dataYear.size();
        String resultIncome = String.format("%.2f",averageIncome);
        System.out.println("Средний доход за все месяцы в году составил " + resultIncome);

    }
}