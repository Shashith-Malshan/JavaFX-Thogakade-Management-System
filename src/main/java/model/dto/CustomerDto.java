package model.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor@ToString

public class CustomerDto {

    private String customerId;
    private String title;
    private String name;
    private String dob;
    private Double salary;
    private String address;
    private String city;
    private String province;
    private String postalCode;

}
