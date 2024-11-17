package com.AttendanceManagementSystem.controller;

import com.AttendanceManagementSystem.entity.Student;
import com.AttendanceManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class studentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/home")
    public String home() {

        return "home"; // returns the view page-> home.html
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";  // returns the view page students.html
    }

    @GetMapping("students/new")
    public String createStudentForm(Model model) {
        Student student = new Student(); // To hold the student object
        model.addAttribute("student", student);
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteById(@PathVariable int id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }
}
