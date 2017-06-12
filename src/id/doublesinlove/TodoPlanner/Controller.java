package id.doublesinlove.TodoPlanner;

import id.doublesinlove.TodoPlanner.Makanan;
import id.doublesinlove.TodoPlanner.Minuman;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * @file    	: Controller.java
 * @author 		: Novia Ismi Nuqoyati
 * @date		: 4 Jun 2017
 */
public class Controller implements Initializable {

	@FXML
	private Text rmsh, textTotal;
	@FXML
	private JFXTextField nama;
	@FXML
	private JFXButton ok1, ok2, order, delete, totalharga;
	@FXML
	private StackPane pane;
	@FXML
	private Spinner<Integer> maQty, miQty;
	@FXML
    private TableView<Makanan> listMakanan;
	@FXML
    private TableColumn<Makanan,String> menuMakanan;
	@FXML
    private TableColumn<Makanan,Integer> hargaMakanan;
	@FXML 
	private TableView<Minuman> listMinuman;
    @FXML
    private TableColumn<Minuman,String> menuMinuman;
    @FXML
    private TableColumn<Minuman,Integer> hargaMinuman;
    @FXML
    private TableView<OrderedItems> keranjangList;
    @FXML
    private TableColumn<OrderedItems,String> orderedMenu;
    @FXML
    private TableColumn<OrderedItems,Integer> columnOrderedHarga, columnOrderedJumlah;
	@FXML
	private Label total;
	@FXML
	private Separator separator;

	private ArrayList<OrderedItems> orderedItemsArrayList = new ArrayList<>();
	
	private static String namaPemesan;
	
	private int totalha = 0;
	
	SqliteGetData sqliteGetData = new SqliteGetData();

	public void setOrderedItemsArrayList(ArrayList<OrderedItems> orderedItemsArrayList) {
	    this.orderedItemsArrayList = orderedItemsArrayList;
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            // Masukin data makanan
            ArrayList<Makanan> listMa = sqliteGetData.getData();
            ObservableList<Makanan> dataMakanan = FXCollections.observableArrayList(listMa);
            menuMakanan.setCellValueFactory(new PropertyValueFactory<Makanan, String>("namaMakanan"));
            hargaMakanan.setCellValueFactory(new PropertyValueFactory<Makanan, Integer>("hargaMakanan"));
            listMakanan.setItems(dataMakanan);

            // Masukin data minuman
            ArrayList<Minuman> listMi = sqliteGetData.getDataMinuman();
            ObservableList<Minuman> dataMinuman = FXCollections.observableArrayList(listMi);
            menuMinuman.setCellValueFactory(new PropertyValueFactory<Minuman, String>("namaMinuman"));
            hargaMinuman.setCellValueFactory(new PropertyValueFactory<Minuman, Integer>("hargaMinuman"));
            listMinuman.setItems(dataMinuman);

            //Masukin data ke keranjang
            
            // Spinner data
            maQty.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1));
            miQty.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
    	
	@FXML
	public void Order(ActionEvent event) throws Exception{
		namaPemesan = nama.getText();
		if(namaPemesan.equals("")){
			JFXDialogLayout isi = new JFXDialogLayout();
			isi.setHeading(new Text("Message"));
			isi.setBody(new Text("Silakan Isi Nama Pemesan"));
			JFXDialog dialog = new JFXDialog();
			dialog.setContent(isi);
			dialog.show(pane);
		}else{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderQueue.fxml"));
            Parent rootOrder = fxmlLoader.load();
            Stage orderQueue = new Stage();
            orderQueue.setScene(new Scene(rootOrder, 515, 361));
            orderQueue.setTitle("Order");
            orderQueue.show();
		}
	}
	
	@FXML
	public void ok1(ActionEvent event){
		Makanan orderedMakanan = listMakanan.getSelectionModel().getSelectedItem();
        String orderedNama = orderedMakanan.getNamaMakanan();
        int orderedHarga = orderedMakanan.getHargaMakanan();
        int orderedJumlah = maQty.getValue();
        
        if (orderedJumlah == 0){
        	JFXDialogLayout isi = new JFXDialogLayout();
			isi.setHeading(new Text("Message"));
			isi.setBody(new Text("Silakan Isi Jumlah Pesanan"));
			JFXDialog dialog = new JFXDialog();
			dialog.setContent(isi);
			dialog.show(pane);
        }else{
	        OrderedItems orderedItems = new OrderedItems(orderedNama, orderedHarga, orderedJumlah);
	        orderedItemsArrayList.add(orderedItems);
	        ObservableList<OrderedItems> dataOrdered = FXCollections.observableArrayList(orderedItemsArrayList);
	        orderedMenu.setCellValueFactory(new PropertyValueFactory<OrderedItems, String>("namaItem"));
	        columnOrderedHarga.setCellValueFactory(new PropertyValueFactory<OrderedItems, Integer>("hargaItem"));
	        columnOrderedJumlah.setCellValueFactory(new PropertyValueFactory<OrderedItems, Integer>("jumlahItem"));
	        keranjangList.setItems(dataOrdered);
	        
	        totalha = totalha + (orderedHarga*orderedJumlah);
	        total.setText(Integer.toString(totalha));
        }
	}
	
	@FXML
	public void ok2(ActionEvent event){
        Minuman orderedMinuman = listMinuman.getSelectionModel().getSelectedItem();
        String orderedNama = orderedMinuman.getNamaMinuman();
        int orderedHarga = orderedMinuman.getHargaMinuman();
        int orderedJumlah = miQty.getValue();
        OrderedItems orderedItems = new OrderedItems(orderedNama, orderedHarga, orderedJumlah);
        if (orderedJumlah == 0){
        	JFXDialogLayout isi = new JFXDialogLayout();
			isi.setHeading(new Text("Message"));
			isi.setBody(new Text("Silakan Isi Jumlah Pesanan"));
			JFXDialog dialog = new JFXDialog();
			dialog.setContent(isi);
			dialog.show(pane);        
        }else{
        	orderedItemsArrayList.add(orderedItems);
	        ObservableList<OrderedItems> dataOrdered = FXCollections.observableArrayList(orderedItemsArrayList);
	        orderedMenu.setCellValueFactory(new PropertyValueFactory<OrderedItems, String>("namaItem"));
	        columnOrderedHarga.setCellValueFactory(new PropertyValueFactory<OrderedItems, Integer>("hargaItem"));
	        columnOrderedJumlah.setCellValueFactory(new PropertyValueFactory<OrderedItems, Integer>("jumlahItem"));
	        keranjangList.setItems(dataOrdered);
	        
	        totalha = totalha + (orderedHarga*orderedJumlah);
	        total.setText(Integer.toString(totalha));
	        
        }
	}
	
    public void setNamaPemesan(String namaPemesan) {
        Controller.namaPemesan = namaPemesan;
    }

    public static String getNamaPemesan() {
        return namaPemesan;
    }

    public void chh() {
        System.out.println(namaPemesan);
    }
}
