package id.doublesinlove.TodoPlanner;

/**
 * Created by SpookyBastard on 6/9/2017.
 */
public class FinalOrder {
    private String namaPemesan;
    private String pesanan;
    private int total;

    public FinalOrder(String namaPemesan, String pesanan, int total) {
        this.namaPemesan = namaPemesan;
        this.pesanan = pesanan;
        this.total = total;
    }

    public String getNamaPemesan() {
        return namaPemesan;
    }

    public String getPesanan() {
        return pesanan;
    }

    public int getTotal() {
        return total;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public void setPesanan(String pesanan) {
        this.pesanan = pesanan;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
