
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DataFile {


    public  void processStringMonth(String path, String fileNameMonth, String typeFile, String month) {
        CalculationMonthlyData  calculationMonthlyData = new CalculationMonthlyData();

        ArrayList<MonthlyReport> monthData = new ArrayList<>();

        String fileContents = readFileContentsOrNull(path);
        if (fileContents != null) {
            String[] lines = fileContents.split("\\n");
            for (int i = 1; i < lines.length; i++) {
                String[] lineContents = lines[i].split(",");
                monthData.add(new MonthlyReport(lineContents[0],
                                                Boolean.parseBoolean(lineContents[1]),
                                                Integer.parseInt(lineContents[2]),
                                                Double.parseDouble(lineContents[3])));
            }
        } else {
            System.out.println("Отсутствуют записи в файле " + fileNameMonth + typeFile + ".");
        }
        calculationMonthlyData.loadDataMonth(month,monthData);
    }

    public void processStringYear(String path, String fileNameYear, String typeFile, String[]nameMonth) {
        CalculationYearData calculationYearData = new CalculationYearData();

        String fileContents = readFileContentsOrNull(path);
        ArrayList<YearlyReport> yearList = new ArrayList<>();
        if (fileContents != null) {
            String[] lines = fileContents.split("\\n");
            for (int i = 1; i < lines.length; i++) {
                String[] lineContents = lines[i].split(",");
                yearList.add(new YearlyReport(Integer.parseInt(lineContents[0]),
                        Double.parseDouble(lineContents[1]),
                        Boolean.parseBoolean(lineContents[2])));
            }
        } else {
            System.out.println("Отсутствуют записи в файле " + fileNameYear + typeFile + ".");
        }
        calculationYearData.loadDataYear(nameMonth,yearList);
    }

    static String readFileContentsOrNull (String path){
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. " +
                                "Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}