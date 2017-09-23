package data;

public class StockRecord {

    private String year;
    private double jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec;

    StockRecord(String year, double jan, double feb, double mar, double apr, double may, double jun, double jul, double aug, double sep, double oct, double nov, double dec) {
        this.year = year;
        this.jan = jan;
        this.feb = feb;
        this.mar = mar;
        this.apr = apr;
        this.may = may;
        this.jun = jun;
        this.jul = jul;
        this.aug = aug;
        this.sep = sep;
        this.oct = oct;
        this.nov = nov;
        this.dec = dec;
    }

    public double getJan() {
        return jan;
    }

    public double getFeb() {
        return feb;
    }

    public double getMar() {
        return mar;
    }

    public double getApr() {
        return apr;
    }

    public double getMay() {
        return may;
    }

    public double getJun() {
        return jun;
    }

    public double getJul() {
        return jul;
    }

    public double getAug() {
        return aug;
    }

    public double getSep() {
        return sep;
    }

    public double getOct() {
        return oct;
    }

    public double getNov() {
        return nov;
    }

    public double getDec() {
        return dec;
    }
}
