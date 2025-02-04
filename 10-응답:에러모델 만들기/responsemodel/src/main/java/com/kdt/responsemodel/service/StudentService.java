package com.kdt.responsemodel.service;

import com.kdt.responsemodel.entity.Student;
import com.kdt.responsemodel.exception.CustomException;
import com.kdt.responsemodel.exception.ErrorCode;
import com.kdt.responsemodel.exception.InputRestriction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final List<Student> studentList = new ArrayList<>();
    private static final int MAX_GRADE = 6;

    public Student addStudent(Student student) {
        if (student.getGrade() > MAX_GRADE) {
            throw new CustomException(ErrorCode.INVALID_GRADE, new InputRestriction());
        }
        studentList.add(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return studentList.stream().sorted(Comparator.comparingInt(Student::getGrade)).collect(Collectors.toList());
    }

    public List<Student> getStudentsByGrade(int grade) {
        return studentList.stream().filter(s -> s.getGrade() == grade).collect(Collectors.toList());
    }
}
