package controller.item;

import javafx.collections.ObservableList;
import model.dto.ItemDto;

public interface ItemService {

    void AddItem(String itemCode,String description,String category,int quantity,double price);
    void UpdateItem(String description,String category,int quantity,double price,String itemCode);
    void DeleteItem(String itemCode);

    ObservableList<ItemDto> getAllValue(ObservableList<ItemDto> itemDtos);



}
