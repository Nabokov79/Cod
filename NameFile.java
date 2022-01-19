import java.nio.file.FileSystems;

public class NameFile {
    String directoryName = "resources";
    String typeFile = ".csv";
    String fileNameMonth = "m.20210";
    String fileNameYear = "y.2021";
    String fileSeparator = FileSystems.getDefault().getSeparator();
    DataFile dataFile = new DataFile();

    public  void doFileNameMonth(String[] nameMonth) {
            for (int i = 1; i < 4; i++) {
                String path = directoryName + fileSeparator + fileNameMonth + i + typeFile;
                dataFile .processStringMonth(path, fileNameMonth, typeFile, nameMonth[i - 1]);
            }
        System.out.println("Данные успешно считаны.");
    }

    public void doFileNameYear(String[] nameMonth) {
        String path = directoryName + fileSeparator + fileNameYear + typeFile;
        dataFile.processStringYear(path, fileNameYear, typeFile, nameMonth);
    }
}