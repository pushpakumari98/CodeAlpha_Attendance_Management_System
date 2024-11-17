package com.AttendanceManagementSystem.serviceImpl;

import com.AttendanceManagementSystem.entity.Teacher;
import com.AttendanceManagementSystem.repository.TeacherRepository;
import com.AttendanceManagementSystem.service.TeacherService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(int id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
    }

    @Override
    public void deleteById(int id) {
        teacherRepository.deleteById(id);
    }
}