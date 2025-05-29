package com.sreysor.school_management_api.Controller;

import com.sreysor.school_management_api.DTO.LecturerClassDTO;
import com.sreysor.school_management_api.Entity.LecturerClass;
import com.sreysor.school_management_api.Repository.ClassroomRepository;
import com.sreysor.school_management_api.Repository.LecturerClassRepository;
import com.sreysor.school_management_api.Repository.LecturerRepository;
import com.sreysor.school_management_api.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/api/lecturer-classes")

public class LecturerClassController {
    private final LecturerClassRepository lecturerClassRepo;
    private final LecturerRepository lecturerRepo;
    private final ClassroomRepository classroomRepo;
    private final UserRepository userRepo;

    @PostMapping
    public LecturerClass create(@RequestBody LecturerClassDTO dto) {
        LecturerClass lc = new LecturerClass();
        lc.setLecturer(lecturerRepo.findById(dto.getLecturerId()).orElse(null));
        lc.setClassroom(classroomRepo.findById(dto.getClassId()).orElse(null));
        lc.setCreateBy(userRepo.findById(dto.getCreateById()).orElse(null));
        lc.setUpdateBy(userRepo.findById(dto.getUpdateById()).orElse(null));
        lc.setStatus(dto.getStatus());
        return lecturerClassRepo.save(lc);
    }

    @GetMapping
    public List<LecturerClass> getAll() {
        return lecturerClassRepo.findAll();
    }

    @GetMapping("/{id}")
    public LecturerClass get(@PathVariable Long id) {
        return lecturerClassRepo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public LecturerClass update(@PathVariable Long id, @RequestBody LecturerClassDTO dto) {
        LecturerClass lc = lecturerClassRepo.findById(id).orElseThrow();
        lc.setLecturer(lecturerRepo.findById(dto.getLecturerId()).orElse(null));
        lc.setClassroom(classroomRepo.findById(dto.getClassId()).orElse(null));
        lc.setUpdateBy(userRepo.findById(dto.getUpdateById()).orElse(null));
        lc.setStatus(dto.getStatus());
        return lecturerClassRepo.save(lc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lecturerClassRepo.deleteById(id);
    }
}
