package id.doublesinlove.TodoPlanner;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @file    	: ControllerQueue.java
 * @author 		: Novia Ismi Nuqoyati
 * @date		: 8 Jun 2017
 */
public class ControllerQueue implements Initializable {
	
	@FXML
	private TableView<FinalOrder> tabelAntri;
	@FXML
    private TableColumn<FinalOrder, String> columnPemesan, columnPesanan; 
	@FXML
	private TableColumn<FinalOrder, Integer> columnTotal;
	@FXML
	private JFXButton delete;
	@FXML
	private StackPane pane;
    private String namaPemesan;
    private ArrayList<String> pesanan = new ArrayList<>();
    private ArrayList<Integer> total = new ArrayList<>();
	private ArrayList<OrderedItems> orderList = new ArrayList<>();
    private ArrayList<FinalOrder> finalOrders = new ArrayList<>();


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        try {
//          Parent parent = fxmlLoader.load();
            Controller controller = fxmlLoader.getController();
            namaPemesan = Controller.getNamaPemesan();
            controller.setOrderedItemsArrayList(orderList);
            for (OrderedItems list:orderList) {
                String pesananItem = list.getNamaItem() + list.getJumlahItem();
                pesanan.add(pesananItem);
            }
            FinalOrder finalOrder = new FinalOrder(namaPemesan, pesanan.toString(), 200);
            finalOrders.add(finalOrder);
            ObservableList<FinalOrder> dataFinal = FXCollections.observableArrayList(finalOrders);
            columnPemesan.setCellValueFactory(new PropertyValueFactory<FinalOrder, String>("namaPemesan"));
            columnPesanan.setCellValueFactory(new PropertyValueFactory<FinalOrder, String>("pesanan"));
            columnTotal.setCellValueFactory(new PropertyValueFactory<FinalOrder, Integer>("total"));
            tabelAntri.setItems(dataFinal);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	@FXML
	public void delete(ActionEvent event) throws Exception{
		tabelAntri.setEditable(true);
		int selectedIndex = tabelAntri.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        tabelAntri.getItems().remove(selectedIndex);
	    } else {
	    	JFXDialogLayout isi = new JFXDialogLayout();
			isi.setHeading(new Text("Message"));
			isi.setBody(new Text("Tidak Ada Baris Yang Dipilih"));
			JFXDialog dialog = new JFXDialog();
			dialog.setContent(isi);
			dialog.show(pane);  
	    }
	}
	
	public void tabel(ActionEvent event){
		
	}


}
