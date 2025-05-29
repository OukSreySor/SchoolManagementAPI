package com.sreysor.school_management_api.Controller;

import com.sreysor.school_management_api.DTO.ClassroomDTO;
import com.sreysor.school_management_api.Entity.Classroom;
import com.sreysor.school_management_api.Repository.ClassroomRepository;
import com.sreysor.school_management_api.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classrooms")

public class ClassroomController {
    private final ClassroomRepository classroomRepo;
    private final UserRepository userRepo;

    @PostMapping
    public Classroom create(@RequestBody ClassroomDTO dto) {
        Classroom classroom = new Classroom();
        classroom.setClassName(dto.getClassName());
        classroom.setCreateBy(userRepo.findById(dto.getCreateById()).orElse(null));
        classroom.setUpdateBy(userRepo.findById(dto.getUpdateById()).orElse(null));
        classroom.setStatusBy(userRepo.findById(dto.getStatusById()).orElse(null));
        return classroomRepo.save(classroom);
    }

    @GetMapping
    public List<Classroom> getAll() {
        return classroomRepo.findAll();
    }

    @GetMapping("/{id}")
    public Classroom get(@PathVariable Long id) {
        return classroomRepo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Classroom update(@PathVariable Long id, @RequestBody ClassroomDTO dto) {
        Classroom classroom = classroomRepo.findById(id).orElseThrow();
        classroom.setClassName(dto.getClassName());
        classroom.setUpdateBy(userRepo.findById(dto.getUpdateById()).orElse(null));
        classroom.setStatusBy(userRepo.findById(dto.getStatusById()).orElse(null));
        return classroomRepo.save(classroom);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        classroomRepo.deleteById(id);
    }
}
