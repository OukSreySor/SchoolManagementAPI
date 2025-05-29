package com.sreysor.school_management_api.DTO;
import lombok.Data;

@Data
public class SubjectDTO {
    private Long id;
    private String subject;
    private Long createById;
    private Long updateById;
    private String status;
}
