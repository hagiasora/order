package id.doublesinlove.TodoPlanner;

/**
 * @file    	: Minuman.java
 * @author 		: Novia Ismi Nuqoyati
 * @date		: 4 Jun 2017
 */
public class Minuman {
    private String namaMinuman;
    private int hargaMinuman;

    public Minuman() {}
    public Minuman(String nama, int harga) {
        this.namaMinuman = nama;
        this.hargaMinuman = harga;
    }

    public String getNamaMinuman() {
        return namaMinuman;
    }

    public int getHargaMinuman() {
        return hargaMinuman;
    }

    public void setNamaMinuman(String namaMinuman) {
        this.namaMinuman = namaMinuman;
    }

    public void setHargaMinuman(int hargaMinuman) {
        this.hargaMinuman = hargaMinuman;
    }
}
