package com.sreysor.school_management_api.DTO;
import lombok.Data;

@Data
public class LecturerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Long subjectId;
    private Long createById;
    private Long updateById;
    private String status;
}