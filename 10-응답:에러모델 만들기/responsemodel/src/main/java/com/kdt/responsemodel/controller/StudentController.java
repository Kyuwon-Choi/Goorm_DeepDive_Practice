package com.kdt.responsemodel.controller;

import com.kdt.responsemodel.entity.Student;
import com.kdt.responsemodel.response.ApiResponse;
import com.kdt.responsemodel.service.StudentService;
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

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Student> addStudent(@RequestBody Student student) {
        return ApiResponse.makeResponse(studentService.addStudent(student));
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ApiResponse.makeResponse(students);
    }


    @GetMapping(value = "/search" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<Student>> searchStudentByGrade(@RequestParam int grade) {
        List<Student> students = studentService.getStudentsByGrade(grade);
        return ApiResponse.makeResponse(students);
    }
}
