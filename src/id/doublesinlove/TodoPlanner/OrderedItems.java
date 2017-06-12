package id.doublesinlove.TodoPlanner;

/**
 * Created by SpookyBastard on 6/9/2017.
 */
public class OrderedItems {
    private String namaItem;
    private int hargaItem;
    private int jumlahItem;

    public OrderedItems(String nama, int harga, int jumlah) {
        this.namaItem = nama;
        this.hargaItem = harga;
        this.jumlahItem = jumlah;
    }
    
    public OrderedItems(){
    	
    }

    public String getNamaItem() {
        return namaItem;
    }

    public int getHargaItem() {
        return hargaItem;
    }

    public int getJumlahItem() {
        return jumlahItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public void setHargaItem(int hargaItem) {
        this.hargaItem = hargaItem;
    }

    public void setJumlahItem(int jumlahItem) {
        this.jumlahItem = jumlahItem;
    }
}
