import java.util.ArrayList;
import java.util.HashMap;

public class CalculationMonthlyData {

    HashMap<String, ArrayList<MonthlyReport>> dataMonths = new HashMap<>();

    public void loadDataMonth(String month, ArrayList<MonthlyReport> monthData) {
        dataMonths.put(month, monthData);
    }

    public void checkMonthsDataTable() {
        if (dataMonths.isEmpty()) {
            findProfitProduct();
        } else {
            System.out.println("Выполните считывание данных.");
        }
    }

    public void findProfitProduct() {
        for (String nameMonth : dataMonths.keySet()) {
            ArrayList<MonthlyReport> values = dataMonths.get(nameMonth);
            double maxProfit = 0;
            String nameProduct = "";
            for (MonthlyReport valueMonth : values) {
                if (!valueMonth.isExpenses) {
                    if (maxProfit < (valueMonth.quantity * valueMonth.sumOne)) {
                        maxProfit = valueMonth.quantity * valueMonth.sumOne;
                        nameProduct = valueMonth.product;
                    }
                }
            }
            System.out.println(nameMonth + ":");
            System.out.println("Самый прибыльный товар:" + "  " + nameProduct + " на сумму " + maxProfit);
            findExpensesProduct(nameMonth);
        }
    }

    public void findExpensesProduct(String name) {
        ArrayList<MonthlyReport> values = dataMonths.get(name);
        double maxExpense = 0;
        String nameProduct = "";

        for (MonthlyReport valueMonth : values) {
            if (valueMonth.isExpenses) {
                if (maxExpense < (valueMonth.quantity * valueMonth.sumOne)) {
                    maxExpense = valueMonth.quantity * valueMonth.sumOne;
                    nameProduct = valueMonth.product;
                }
            }
        }
        System.out.println("Самая большая трата:" + "  " + nameProduct + " на сумму " + maxExpense);
    }
}


