package com.AttendanceManagementSystem.service;

import com.AttendanceManagementSystem.entity.Student;
import com.AttendanceManagementSystem.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> getAllTeachers();
    public Teacher saveTeacher(Teacher teacher);
    public Teacher getTeacherById(int id);
    void deleteById(int id);
}
