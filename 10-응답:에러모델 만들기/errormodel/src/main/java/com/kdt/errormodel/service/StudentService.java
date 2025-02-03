package com.kdt.errormodel.service;

import com.kdt.errormodel.entity.Student;
import com.kdt.errormodel.exception.CustomException;
import com.kdt.errormodel.exception.ErrorCode;
import com.kdt.errormodel.exception.InputRestriction;
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
            throw new CustomException(ErrorCode.SERVER_ERROR, "grade 는 6 이상을 입력 할 수 없습니다.", new InputRestriction(MAX_GRADE));
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
