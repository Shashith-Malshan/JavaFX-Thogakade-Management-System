package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ItemDto {

    private String itemCode;
    private String description;
    private String category;
    private int quantity;
    private double price;

}
