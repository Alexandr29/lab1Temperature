public class Main {

    public static void main(String[] args) {
        StockData stockData = new StockData();
        stockData.loadDataFrmFile("data.csv");
        System.out.println(stockData.getNumberOfRecords());
    }

}
