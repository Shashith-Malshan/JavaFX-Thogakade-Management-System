package controller.item;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.ItemDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemController implements ItemService{
    @Override
    public void AddItem(String itemCode,String description,String category,int quantity,double price) {

        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO item VALUES (?,?,?,?,?)");
            preparedStatement.setObject(1,itemCode);
            preparedStatement.setObject(2,description);
            preparedStatement.setObject(3,category);
            preparedStatement.setObject(4,quantity);
            preparedStatement.setObject(5,price);

            preparedStatement.execute();





        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void UpdateItem(String description,String category,int quantity,double price,String itemCode) {

    }

    @Override
    public void DeleteItem(String itemCode) {

    }

    public ObservableList<ItemDto> getAllValue(ObservableList<ItemDto> itemDtos){
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM item");
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                itemDtos.add(new ItemDto(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5)

                ));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return itemDtos;
    }
}
