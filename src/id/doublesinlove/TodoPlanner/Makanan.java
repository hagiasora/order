package id.doublesinlove.TodoPlanner;

/**
 * @file    	: Makanan.java
 * @author 		: Novia Ismi Nuqoyati
 * @date		: 4 Jun 2017
 */
public class Makanan{
	private String namaMakanan;
	private int hargaMakanan;

	public Makanan() {}
	public Makanan(String nama, int harga) {
	    this.namaMakanan = nama;
	    this.hargaMakanan = harga;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public int getHargaMakanan() {
        return hargaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    public void setHargaMakanan(int hargaMakanan) {
        this.hargaMakanan = hargaMakanan;
    }
}
