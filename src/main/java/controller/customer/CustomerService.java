package controller.customer;

import javafx.collections.ObservableList;
import model.dto.CustomerDto;

public interface CustomerService {

    void addCustomer(String customerId,String title,String name,String dob,Double salary,String address,String city,String province,String postalCode);

    void updateCustomer(String title,String name,String dob,Double salary,String address,String city,String province,String postalCode,String customerId);

    void deleteCustomer(String customerId);

    ObservableList<CustomerDto> getAllValues(ObservableList<CustomerDto> customerInfoDtos);

}
