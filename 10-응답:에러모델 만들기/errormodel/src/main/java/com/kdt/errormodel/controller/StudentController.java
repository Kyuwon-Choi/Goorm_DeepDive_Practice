package com.kdt.errormodel.controller;

import com.kdt.errormodel.entity.Student;
import com.kdt.errormodel.response.ApiResponse;
import com.kdt.errormodel.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/add")
    public ApiResponse<Student> addStudent(@RequestBody Student student) {
        return ApiResponse.makeResponse(studentService.addStudent(student));
    }

    @GetMapping("/all")
    public ApiResponse<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ApiResponse.makeResponse(students);
    }

    @GetMapping("/search")
    public ApiResponse<List<Student>> searchStudentByGrade(@RequestParam int grade) {
        List<Student> students = studentService.getStudentsByGrade(grade);
        return ApiResponse.makeResponse(students);
    }
}
