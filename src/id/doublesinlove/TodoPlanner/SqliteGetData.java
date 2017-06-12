package id.doublesinlove.TodoPlanner;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @file    	: SqliteConnnection.java
 * @author 		: Novia Ismi Nuqoyati
 * @date		: 8 Jun 2017
 */
public class SqliteGetData {
    public ArrayList<Makanan> getData() throws Exception {
        ArrayList<Makanan> listMakanan = new ArrayList<>();
        Connection connection = SqliteConnnection.dbConnector();
        String query = "SELECT Nama,Harga FROM ListMakanan";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String namaMakanan = resultSet.getString("Nama");
            int hargaMakanan = resultSet.getInt("Harga");
            Makanan makanan = new Makanan(namaMakanan, hargaMakanan);
            listMakanan.add(makanan);
        }
        return listMakanan;
    }

    public ArrayList<Minuman> getDataMinuman() throws Exception {
        ArrayList<Minuman> listMinuman = new ArrayList<>();
        Connection connection = SqliteConnnection.dbConnector();
        String query = "SELECT Nama,Harga FROM ListMinuman";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String namaMinuman = resultSet.getString("Nama");
            int hargaMinuman = resultSet.getInt("Harga");
            Minuman minuman= new Minuman(namaMinuman, hargaMinuman);
            listMinuman.add(minuman);
        }
        return listMinuman;
    }
}
