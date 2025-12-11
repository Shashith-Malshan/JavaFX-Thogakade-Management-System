package controller.customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CustomerDto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerDashboardController implements Initializable {

    ObservableList<CustomerDto> customerInfoDtos= FXCollections.observableArrayList();
    CustomerService customerService =new CustomerController();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustId;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private DatePicker date;

    @FXML
    private TableView<CustomerDto> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private ComboBox<String> txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        String customerId=txtCustId.getText();
        String title=cmbTitle.getValue();
        String name=txtName.getText();
        String dob= String.valueOf(date.getValue());
        Double salary= Double.valueOf(txtSalary.getText());
        String address=txtAddress.getText();
        String city=txtCity.getText();
        String province=txtProvince.getValue();
        String postalCode=txtPostalCode.getText();


        customerService.addCustomer(customerId,title,name,dob,salary,address,city,province,postalCode);
        clearFields();
        loadCustomerDetails();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String customerId=txtCustId.getText();
        customerService.deleteCustomer(customerId);
        clearFields();
        loadCustomerDetails();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
       String customerId=txtCustId.getText();
       String title=cmbTitle.getValue();
       String name=txtName.getText();
       String dob= String.valueOf(date.getValue());
       Double salary= Double.valueOf(txtSalary.getText());
       String address=txtAddress.getText();
       String city=txtCity.getText();
       String province=txtProvince.getValue();
       String postalCode=txtPostalCode.getText();

       customerService.updateCustomer(title,name,dob,salary,address,city,province,postalCode,customerId);
       clearFields();
       loadCustomerDetails();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colCustId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        loadCustomerDetails();

        ObservableList<String> title= FXCollections.observableArrayList("Mr","Mrs","Ms","Miss");
        cmbTitle.setItems(title);

        ObservableList<String> province=FXCollections.observableArrayList("Nothern","Western","Western");
        txtProvince.setItems(province);

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{

            if (newValue != null) {
                setSelectedValue(newValue);
            }

        });




    }

    //---------All Methods------------

    private void loadCustomerDetails(){
        customerInfoDtos.clear();
        tblCustomer.setItems(customerService.getAllValues(customerInfoDtos));

    }

    private void clearFields(){
        txtCustId.clear();
        cmbTitle.setValue(null);
        txtName.clear();
        date.setValue(null);
        txtSalary.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.setValue(null);
        txtPostalCode.clear();
    }
    private void emptyMethod(){
        System.out.println("Test_empty");
    }

    private void setSelectedValue(CustomerDto selectedValue){
        if(selectedValue == null){
            clearFields();
            return;
        }

        txtCustId.setText(selectedValue.getCustomerId());
        cmbTitle.setValue(selectedValue.getTitle());
        txtName.setText(selectedValue.getName());
        date.setValue(LocalDate.from(LocalDate.parse(selectedValue.getDob())));
        txtSalary.setText(String.valueOf(selectedValue.getSalary()));
        txtAddress.setText(selectedValue.getAddress());
        txtCity.setText(selectedValue.getCity());
        txtProvince.setValue(selectedValue.getProvince());
        txtPostalCode.setText(selectedValue.getPostalCode());


    }
}
