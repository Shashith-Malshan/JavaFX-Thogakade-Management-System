package controller.customer;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.CustomerDto;

import java.sql.*;

public class CustomerController implements CustomerService {

    public void addCustomer(String customerId,String title,String name,String dob,Double salary,String address,String city,String province,String postalCode){

        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)");

            preparedStatement.setObject(1,customerId);
            preparedStatement.setObject(2,title);
            preparedStatement.setObject(3,name);
            preparedStatement.setObject(4,dob);
            preparedStatement.setObject(5,salary);
            preparedStatement.setObject(6,address);
            preparedStatement.setObject(7,city);
            preparedStatement.setObject(8,province);
            preparedStatement.setObject(9,postalCode);


            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void updateCustomer(String title,String name,String dob,Double salary,String address,String city,String province,String postalCode,String customerId){

        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String SQL="UPDATE customer SET Title=?,Name=?,DateOfBirth=?,Salary=?,Address=?,City=?,Province=?,PostalCode=? WHERE CustomerID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(SQL);

            preparedStatement.setObject(1,title);
            preparedStatement.setObject(2,name);
            preparedStatement.setObject(3,dob);
            preparedStatement.setObject(4,salary);
            preparedStatement.setObject(5,address);
            preparedStatement.setObject(6,city);
            preparedStatement.setObject(7,province);
            preparedStatement.setObject(8,postalCode);
            preparedStatement.setObject(9,customerId);

            preparedStatement.executeUpdate();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteCustomer(String customerId){

        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM customer WHERE CustomerID=?");
            preparedStatement.setObject(1,customerId);
            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ObservableList<CustomerDto> getAllValues(ObservableList<CustomerDto> customerInfoDtos ){
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet= preparedStatement.executeQuery();

            while (resultSet.next()){

                CustomerDto customerDto=new CustomerDto(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9)
                );

                customerInfoDtos.add(customerDto);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerInfoDtos;

    }





}
