
import java.util.ArrayList;

public class Comparison {

    CalculationYearData calculationYearData = new CalculationYearData();
    CalculationMonthlyData calculationMonthlyData = new CalculationMonthlyData();


    void compareData() {
        int sumRevenue = 0;
        int sumExpenses = 0;

        for (String month : calculationMonthlyData.dataMonths.keySet()) {
            ArrayList<MonthlyReport> valueMonth = calculationMonthlyData.dataMonths.get(month);
            for (MonthlyReport value : valueMonth) {
                if (!value.isExpenses) {
                    sumRevenue += value.quantity * value.sumOne;
                } else {
                    sumExpenses += value.quantity * value.sumOne;
                }
            }
            ArrayList<YearlyReport> valueYear = calculationYearData.dataYear.get(month);
            for (YearlyReport values : valueYear) {
                if (!values.isExpense) {
                    values.amount = sumRevenue;
                } else {
                    values.amount = sumExpenses;
                }
            }
        }
    }
}