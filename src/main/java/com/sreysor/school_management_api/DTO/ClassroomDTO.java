package com.sreysor.school_management_api.DTO;
import lombok.Data;

@Data
public class ClassroomDTO {
    private Long id;
    private String className;
    private Long createById;
    private Long updateById;
    private Long statusById;
}
