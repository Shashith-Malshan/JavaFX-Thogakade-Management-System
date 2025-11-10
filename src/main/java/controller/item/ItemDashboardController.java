package controller.item;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.ItemDto;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemDashboardController implements Initializable {

    ItemService itemService=new ItemController();
    ObservableList<ItemDto> itemDtos=FXCollections.observableArrayList();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbCategory;

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItem;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colUnit;

    @FXML
    private TableView<ItemDto> tblItem;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtItem;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtUnit;

    @FXML
    void addOnAction(ActionEvent event) {
         String itemCode=txtItem.getText();
         String description=txtDescription.getText();
         String category=cmbCategory.getValue();
         int quantity= Integer.parseInt(txtQuantity.getText());
         double price=Double.parseDouble(txtUnit.getText());

         itemService.AddItem(itemCode,description,category,quantity,price);


    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        String itemCode=txtItem.getText();
        itemService.DeleteItem(itemCode);


    }

    @FXML
    void updateOnAction(ActionEvent event) {

        String itemCode=txtItem.getText();
        String description=txtDescription.getText();
        String category=cmbCategory.getValue();
        int quantity= Integer.parseInt(txtQuantity.getText());
        double price=Double.parseDouble(txtUnit.getText());

        itemService.UpdateItem(description,category,quantity,price,itemCode);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colItem.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colUnit.setCellValueFactory(new PropertyValueFactory<>("price"));

        loadItemDetails();

        ObservableList<String> category= FXCollections.observableArrayList("Grocery","Meat","Seafood","Fruits");
        cmbCategory.setItems(category);

    }

    private void loadItemDetails() {
       tblItem.setItems(itemService.getAllValue(itemDtos));
    }
}
