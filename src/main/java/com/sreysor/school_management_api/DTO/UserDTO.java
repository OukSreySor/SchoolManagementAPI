package com.sreysor.school_management_api.DTO;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String status;
}
