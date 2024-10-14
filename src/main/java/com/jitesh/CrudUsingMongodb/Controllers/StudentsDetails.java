package com.jitesh.CrudUsingMongodb.Controllers;

import com.jitesh.CrudUsingMongodb.Model.Students;
import com.jitesh.CrudUsingMongodb.Repo.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/students")
public class StudentsDetails {

    @Autowired
    private StudentsRepository studentsRepository;

//    create
    @PostMapping
    public String addStudents(@RequestBody Students students){
        studentsRepository.save(students);
        return "Student " + students.getId() + "Created successful";
    }

//    read

    // Get all students
    @GetMapping
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public Optional<Students> getStudentById(@PathVariable String id) {
        return studentsRepository.findById(id);
    }

    // Update a student by ID
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable String id, @RequestBody Students updatedStudent) {
        Optional<Students> optionalStudent = studentsRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Students students = optionalStudent.get();
            students.setName(updatedStudent.getName());
            students.setAge(updatedStudent.getAge());
            students.setMail(updatedStudent.getMail());
            studentsRepository.save(students);
            return "Student updated successfully.";
        } else {
            return "Student not found.";
        }
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {
        Optional<Students> optionalStudent = studentsRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentsRepository.deleteById(id);
            return "Student deleted successfully.";
        } else {
            return "Student not found.";
        }
    }

}
