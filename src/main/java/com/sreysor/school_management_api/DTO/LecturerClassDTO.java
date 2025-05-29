package com.sreysor.school_management_api.DTO;
import lombok.Data;

@Data
public class LecturerClassDTO {
    private Long id;
    private Long lecturerId;
    private Long classId;
    private Long createById;
    private Long updateById;
    private String status;
}
