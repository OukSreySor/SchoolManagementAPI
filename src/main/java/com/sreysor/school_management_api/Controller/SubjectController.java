package com.sreysor.school_management_api.Controller;

import com.sreysor.school_management_api.DTO.SubjectDTO;
import com.sreysor.school_management_api.Entity.Subject;
import com.sreysor.school_management_api.Repository.SubjectRepository;
import com.sreysor.school_management_api.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subjects")
public class SubjectController {
    private final SubjectRepository subjectRepo;
    private final UserRepository userRepo;

    @PostMapping
    public Subject create(@RequestBody SubjectDTO dto) {
        Subject subject = new Subject();
        subject.setSubject(dto.getSubject());
        subject.setCreateBy(userRepo.findById(dto.getCreateById()).orElse(null));
        subject.setUpdateBy(userRepo.findById(dto.getUpdateById()).orElse(null));
        subject.setStatus(dto.getStatus());
        return subjectRepo.save(subject);
    }

    @GetMapping
    public List<Subject> getAll() {
        return subjectRepo.findAll();
    }

    @GetMapping("/{id}")
    public Subject get(@PathVariable Long id) {
        return subjectRepo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Subject update(@PathVariable Long id, @RequestBody SubjectDTO dto) {
        Subject subject = subjectRepo.findById(id).orElseThrow();
        subject.setSubject(dto.getSubject());
        subject.setUpdateBy(userRepo.findById(dto.getUpdateById()).orElse(null));
        subject.setStatus(dto.getStatus());
        return subjectRepo.save(subject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subjectRepo.deleteById(id);
    }
}