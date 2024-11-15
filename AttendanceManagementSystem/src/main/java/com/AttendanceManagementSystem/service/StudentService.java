package com.AttendanceManagementSystem.service;

import java.util.List;
import com.AttendanceManagementSystem.entity.Student;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student saveStudent(Student student);
    Student getStudentById(int id);
    void deleteById(int id);
}
