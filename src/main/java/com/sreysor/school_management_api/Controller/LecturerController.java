package com.sreysor.school_management_api.Controller;

import com.sreysor.school_management_api.DTO.LecturerDTO;
import com.sreysor.school_management_api.Entity.Lecturer;
import com.sreysor.school_management_api.Repository.LecturerRepository;
import com.sreysor.school_management_api.Repository.SubjectRepository;
import com.sreysor.school_management_api.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor

@RequestMapping("/api/lecturers")

public class LecturerController {
    private final LecturerRepository lecturerRepo;
    private final SubjectRepository subjectRepo;
    private final UserRepository userRepo;

    @PostMapping
    public Lecturer create(@RequestBody LecturerDTO dto) {
        Lecturer lecturer = new Lecturer();
        lecturer.setFirstName(dto.getFirstName());
        lecturer.setLastName(dto.getLastName());
        lecturer.setSubject(subjectRepo.findById(dto.getSubjectId()).orElse(null));
        lecturer.setCreateBy(userRepo.findById(dto.getCreateById()).orElse(null));
        lecturer.setUpdateBy(userRepo.findById(dto.getUpdateById()).orElse(null));
        lecturer.setStatus(dto.getStatus());
        return lecturerRepo.save(lecturer);
    }

    @GetMapping
    public List<Lecturer> getAll() {
        return lecturerRepo.findAll();
    }

    @GetMapping("/{id}")
    public Lecturer get(@PathVariable Long id) {
        return lecturerRepo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Lecturer update(@PathVariable Long id, @RequestBody LecturerDTO dto) {
        Lecturer lecturer = lecturerRepo.findById(id).orElseThrow();
        lecturer.setFirstName(dto.getFirstName());
        lecturer.setLastName(dto.getLastName());
        lecturer.setSubject(subjectRepo.findById(dto.getSubjectId()).orElse(null));
        lecturer.setUpdateBy(userRepo.findById(dto.getUpdateById()).orElse(null));
        lecturer.setStatus(dto.getStatus());
        return lecturerRepo.save(lecturer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lecturerRepo.deleteById(id);
    }
}
