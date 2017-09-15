import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StockData {
    private ArrayList<StockRecord> records;

    public StockData() {
        records = new ArrayList<>();
    }

    public StockRecord getRecordNumber(int i){
        return records.get(i);
    }

    public int getNumberOfRecords(){
        return records.size();
    }

    public void loadDataFrmFile(String filePath) {
        try {
            Scanner scanner = new Scanner(new FileReader(filePath));
            String line;
            StockRecord record;

            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                String results[] = line.split(",");
                double jan = Double.parseDouble(results[1]);
                double feb = Double.parseDouble(results[2]);
                double mar = Double.parseDouble(results[3]);
                double apr = Double.parseDouble(results[4]);
                double may = Double.parseDouble(results[5]);
                double jun = Double.parseDouble(results[6]);
                double jul = Double.parseDouble(results[7]);
                double aug = Double.parseDouble(results[8]);
                double sep = Double.parseDouble(results[9]);
                double oct = Double.parseDouble(results[10]);
                double nov = Double.parseDouble(results[11]);
                double dec = Double.parseDouble(results[12]);

               record = new StockRecord(results[0],jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec);
               records.add(record);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
